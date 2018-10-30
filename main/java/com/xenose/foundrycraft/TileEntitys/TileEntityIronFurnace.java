package com.xenose.foundrycraft.TileEntitys;

import com.xenose.foundrycraft.FoundryApi.FoundryTileEntity;
import com.xenose.foundrycraft.crafting.Smelting;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.ITickable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBoat;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.datafix.FixTypes;
import net.minecraft.util.datafix.walkers.ItemStackDataLists;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityIronFurnace extends FoundryTileEntity implements ITickable, ISidedInventory
{
	private static final int[] _slotsTop = new int[] { 0 };
	private static final int[] _slotsBottom = new int[] { 2, 1 };
	private static final int[] _slotsSides = new int[] { 1 };
	
	/// the current cooking stack
	private NonNullList<ItemStack> invStack = NonNullList.<ItemStack>withSize(3, ItemStack.EMPTY);
	
	private int 
		_totalBurnTime,
		_currentBurnTime,
		_totalCookTime,
		_currentCookTime;
	
	private String _customName;
	
	@Override
	public int getSizeInventory() 
	{
		return invStack.size();
	}
	
	@Override
	public boolean isEmpty() 
	{
		for (ItemStack i : invStack) 
		{
			if (!i.isEmpty()) 
			{
				return false;
			}
		}
		
		return true;
	}
	
	@Override
	public ItemStack getStackInSlot(int index) 
	{
		return invStack.get(index);
	}
	
	@Override
	public ItemStack decrStackSize(int index, int count) 
	{
		return ItemStackHelper.getAndSplit(invStack, index, count);
	}
	
	@Override
	public ItemStack removeStackFromSlot(int index) 
	{
		return ItemStackHelper.getAndRemove(invStack, index);
	}
	
	@Override
	public void setInventorySlotContents(int index, ItemStack stack) 
	{
		ItemStack tmpStack = invStack.get(index);
		
		boolean flag = 
				!tmpStack.isEmpty() && tmpStack.isItemEqual(tmpStack) && 
				tmpStack.areItemStackTagsEqual(stack, tmpStack);
		
		if (stack.getCount() > getInventoryStackLimit())
			stack.setCount(getInventoryStackLimit());
		
		if (index == 0 && !flag) 
		{
			_totalCookTime = GetCookTime(stack);
			_currentCookTime = 0;
			this.markDirty();
		}
	}
	
	@Override
	public String getName() 
	{
		return hasCustomName() ? _customName : "container.ironfurnace";
	}
	
	@Override
	public boolean hasCustomName() 
	{
		return _customName != null && !_customName.isEmpty();
	}
	
	public void SetCustomInventoryName(String invName) 
	{
		_customName = invName;
	}
	
	public void RegisterFixesFurnace(DataFixer fixer) 
	{
		fixer.registerWalker(
				FixTypes.BLOCK_ENTITY, 
				new ItemStackDataLists(TileEntityIronFurnace.class, 
				new String[] {"Items"})
				);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) 
	{
		super.readFromNBT(compound);
		
		invStack = NonNullList.<ItemStack>withSize(getSizeInventory(), ItemStack.EMPTY);
		ItemStackHelper.loadAllItems(compound, invStack);
		
		_totalBurnTime = compound.getInteger("BurnTime");
		_currentCookTime = compound.getInteger("CookingTime");
		_totalCookTime = compound.getInteger("TotalCookTime");
		_currentBurnTime = GetItemBurnTime(invStack.get(1));
		
		if (compound.hasKey("CustomeName", 8)) 
		{
			_customName = compound.getString("CustomName");
		}
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) 
	{
		super.writeToNBT(compound);
		
		compound.setInteger("BurnTime", (short)_totalBurnTime);
		compound.setInteger("CookTime", (short)_currentCookTime);
		compound.setInteger("TotalCookTime", (short)_totalCookTime);
		ItemStackHelper.saveAllItems(compound, invStack);
		
		if (hasCustomName()) 
		{
			compound.setString("CustomName", _customName);
		}
		
		return compound;
	}
	
	@Override
	public int getInventoryStackLimit() 
	{
		return 64;
	}
	
	public boolean IsBurning() 
	{
		return _currentBurnTime > 0;
	}
	
	@SideOnly(Side.CLIENT)
	public static boolean IsBurning(IInventory inv) 
	{
		return inv.getField(0) > 0;
	}
	
	public void Update() 
	{
		boolean flag = IsBurning();
		boolean flag1 = false;
		
		if (IsBurning())
			_currentBurnTime--;
		
		if (!world.isRemote)
		{
			ItemStack tmpStack = invStack.get(1);
			
			if (IsBurning() && CanSmelt()) 
			{
				
				_totalBurnTime = GetItemBurnTime(tmpStack);
				_currentBurnTime = _totalBurnTime;
				
				if (IsBurning()) 
				{
					flag1 = true;
					
					if (!tmpStack.isEmpty()) 
					{
						Item item = tmpStack.getItem();
						tmpStack.shrink(1);
						
						if (tmpStack.isEmpty()) 
						{
							ItemStack item1 = item.getContainerItem(tmpStack);
							invStack.set(1, item1);
						}
					}
				}
				
				if (IsBurning() && CanSmelt()) 
				{
					_currentCookTime++;
					
					if (_currentBurnTime == _totalCookTime) 
					{
						_currentCookTime = 0;
						_totalCookTime = GetCookTime(invStack.get(0));
						SmeltItem();
						flag1 = true;
					}
				}
				
				else 
				{
					_currentCookTime = 0;
				}
				
			}
			
			else if (!IsBurning() && _currentCookTime > 0) 
				_currentCookTime = MathHelper.clamp(_currentCookTime -2, 0, _totalCookTime);
			
			if (flag != IsBurning()) 
			{
				flag1 = true;
				//IronFurnace.SetState(IsBurning(), world, pos);
			}
			
		}
		
		if (flag1)
			markDirty();
	}
	
	private int GetCookTime(ItemStack stack) 
	{
		return 150;
	}
	
	private boolean CanSmelt() 
	{
		if (((ItemStack)invStack.get(0)).isEmpty())
			return false;
		else
		{
			ItemStack itemStack = FurnaceRecipes.instance().getSmeltingResult(invStack.get(0));
			
			if (itemStack.isEmpty())
				return false;
			else 
			{
				ItemStack itemStack1 = invStack.get(2);
				
				if (itemStack1.isEmpty())
					return true;
				else if (!itemStack1.isItemEqual(itemStack))
					return false;
				else if (itemStack1.getCount() + itemStack.getCount() <= getInventoryStackLimit() && 
						itemStack1.getCount() + itemStack.getCount() <= itemStack1.getMaxStackSize())
					return true;
				else
					return itemStack1.getCount() + itemStack.getCount() <= itemStack.getMaxStackSize();
			}
		}
	}

	private void SmeltItem()
	{
		if (CanSmelt()) 
		{
			ItemStack itemStack = invStack.get(0);
			ItemStack itemstack1 = FurnaceRecipes.instance().getSmeltingResult(itemStack);
			ItemStack itemStack2 = invStack.get(2);
			
			if (itemStack2.isEmpty()) 
				invStack.set(2, itemstack1.copy());
			
			else if (itemStack2.getItem() == itemstack1.getItem())
				itemStack2.grow(itemstack1.getCount());
			
			
			if (itemStack.getItem() == Item.getItemFromBlock(Blocks.SPONGE) && itemStack.getMetadata() == 1 &&
				!((ItemStack)invStack.get(1)).isEmpty() && ((ItemStack)invStack.get(1)).getItem() == Items.BUCKET)
			{
				invStack.set(1, new ItemStack(Items.WATER_BUCKET));
			}
				
			itemStack.shrink(1);
		}
	}

	

	public static int GetItemBurnTime(ItemStack itemStack) 
	{
		if (itemStack.isEmpty()) 
		{
			return 0;
		}
		
		else 
		{
			 int burnTime = net.minecraftforge.event.ForgeEventFactory.getItemBurnTime(itemStack);
	            if (burnTime >= 0) return burnTime;
	            Item item = itemStack.getItem();

	            if (item == Item.getItemFromBlock(Blocks.WOODEN_SLAB))
	            {
	                return 150;
	            }
	            else if (item == Item.getItemFromBlock(Blocks.WOOL))
	            {
	                return 100;
	            }
	            else if (item == Item.getItemFromBlock(Blocks.CARPET))
	            {
	                return 67;
	            }
	            else if (item == Item.getItemFromBlock(Blocks.LADDER))
	            {
	                return 300;
	            }
	            else if (item == Item.getItemFromBlock(Blocks.WOODEN_BUTTON))
	            {
	                return 100;
	            }
	            else if (Block.getBlockFromItem(item).getDefaultState().getMaterial() == Material.WOOD)
	            {
	                return 300;
	            }
	            else if (item == Item.getItemFromBlock(Blocks.COAL_BLOCK))
	            {
	                return 16000;
	            }
	            else if (item instanceof ItemTool && "WOOD".equals(((ItemTool)item).getToolMaterialName()))
	            {
	                return 200;
	            }
	            else if (item instanceof ItemSword && "WOOD".equals(((ItemSword)item).getToolMaterialName()))
	            {
	                return 200;
	            }
	            else if (item instanceof ItemHoe && "WOOD".equals(((ItemHoe)item).getMaterialName()))
	            {
	                return 200;
	            }
	            else if (item == Items.STICK)
	            {
	                return 100;
	            }
	            else if (item != Items.BOW && item != Items.FISHING_ROD)
	            {
	                if (item == Items.SIGN)
	                {
	                    return 200;
	                }
	                else if (item == Items.COAL)
	                {
	                    return 1600;
	                }
	                else if (item == Items.LAVA_BUCKET)
	                {
	                    return 20000;
	                }
	                else if (item != Item.getItemFromBlock(Blocks.SAPLING) && item != Items.BOWL)
	                {
	                    if (item == Items.BLAZE_ROD)
	                    {
	                        return 2400;
	                    }
	                    else if (item instanceof ItemDoor && item != Items.IRON_DOOR)
	                    {
	                        return 200;
	                    }
	                    else
	                    {
	                        return item instanceof ItemBoat ? 400 : 0;
	                    }
	                }
	                else
	                {
	                    return 100;
	                }
	            }
	            else
	            {
	                return 300;
	            }
		}
	}
	
	public static boolean IsItemFuel(ItemStack stack) 
	{
		return GetItemBurnTime(stack) > 0;
	}
	
	@Override
	public boolean isUsableByPlayer(EntityPlayer player) 
	{
		if (this.world.getTileEntity(this.pos) != this) 
		{
			return false;
		}
		else 
		{
			return player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
		}
	}
	
	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) 
	{
		if(index == 2)
			return false;
		else if (index != 1)
			return true;
		else 
		{
			ItemStack itemStack = invStack.get(1);
			return IsItemFuel(itemStack) || SlotFurnaceFuel.isBucket(stack) &&  itemStack.getItem() != Items.BUCKET;
		}
	}

	@Override
	public void tick() 
	{
		Update();	
	}

	@Override
	public int[] getSlotsForFace(EnumFacing side) 
	{
		 if (side == EnumFacing.DOWN)
	        {
	            return _slotsBottom;
	        }
	        else
	        {
	            return side == EnumFacing.UP ? _slotsTop : _slotsSides;
	        }
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) 
	{
		return this.isItemValidForSlot(index, itemStackIn);
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) 
	{
		 if (direction == EnumFacing.DOWN && index == 1)
	        {
	            Item item = stack.getItem();

	            if (item != Items.WATER_BUCKET && item != Items.BUCKET)
	            {
	                return false;
	            }
	        }

	        return true;
	}
	
	public String getGuiID()
    {
        return "xfc:ironfurnace";
    }
	 
	 public int getField(int id)
	 {
        switch (id)
        {
            case 0:
                return this._totalBurnTime;
            case 1:
                return this._currentBurnTime;
            case 2:
                return this._currentCookTime;
            case 3:
                return this._totalCookTime;
            default:
                return 0;
        }
	  }

	    public void setField(int id, int value)
	    {
	        switch (id)
	        {
	            case 0:
	                this._totalBurnTime = value;
	                break;
	            case 1:
	                this._currentBurnTime = value;
	                break;
	            case 2:
	                this._currentCookTime = value;
	                break;
	            case 3:
	                this._totalCookTime = value;
	        }
	    }

	    public int getFieldCount()
	    {
	        return 4;
	    }

	    public void clear()
	    {
	        this.invStack.clear();
	    }

	    net.minecraftforge.items.IItemHandler handlerTop = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.UP);
	    net.minecraftforge.items.IItemHandler handlerBottom = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.DOWN);
	    net.minecraftforge.items.IItemHandler handlerSide = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.WEST);

	    
	    @SuppressWarnings("unchecked")
	    @Override
	    @javax.annotation.Nullable
	    public <T> T getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, @javax.annotation.Nullable net.minecraft.util.EnumFacing facing)
	    {
	        if (facing != null && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
	            if (facing == EnumFacing.DOWN)
	                return (T) handlerBottom;
	            else if (facing == EnumFacing.UP)
	                return (T) handlerTop;
	            else
	                return (T) handlerSide;
	        return super.getCapability(capability, facing);
	    }

}
