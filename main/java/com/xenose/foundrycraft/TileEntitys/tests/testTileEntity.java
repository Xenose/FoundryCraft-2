package com.xenose.foundrycraft.TileEntitys.tests;

import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.NonNullList;

public class testTileEntity extends TileEntity 
{
	NonNullList<ItemStack> _item = NonNullList.<ItemStack>withSize(1, ItemStack.EMPTY);
	
	int _maxStackSize;
	
	public boolean Add(Item itemIn, int amount) 
	{
		System.out.println("lol");
		if (itemIn == _item.get(0).getItem() || _item.get(0) == ItemStack.EMPTY) 
		{
			if (_item.get(0) == ItemStack.EMPTY) 
			{
				_item.get(0).getItem().setContainerItem(itemIn);
			}
			
			_item.get(0).grow(amount);
			markDirty();
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public boolean Decrece(int amount) 
	{
		System.out.println("lol");
		if (_item.get(0).getCount() < 0) 
		{
			return false;
		}
		else 
		{	
			_item.get(0).shrink(amount);
			markDirty();
			return true;
		}
	}
	
	public ItemStack GetItemStack() 
	{
		return _item.get(0);
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) 
	{
		ItemStackHelper.saveAllItems(compound, _item);
		return super.writeToNBT(compound);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) 
	{
		super.readFromNBT(compound);
		ItemStackHelper.loadAllItems(compound, _item);
	}
}
