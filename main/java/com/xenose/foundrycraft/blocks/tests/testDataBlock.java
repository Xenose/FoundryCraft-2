package com.xenose.foundrycraft.blocks.tests;

import com.xenose.foundrycraft.FoundryApi.blocks.FoundryBlockAdvanceBlock;
import com.xenose.foundrycraft.TileEntitys.tests.testTileEntity;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class testDataBlock extends FoundryBlockAdvanceBlock implements ITileEntityProvider
{

	protected testTileEntity _tile;
	
	public testDataBlock(String name) 
	{
		super(Material.ROCK , name);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) 
	{
		return new testTileEntity();
	}
	
	public testTileEntity GetTileEntity(World world, BlockPos pos) 
	{
		return (testTileEntity) world.getTileEntity(pos);
	}
	
	@Override
	public boolean onBlockActivated(
			World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, 
			EnumFacing facing, float hitX, float hitY, float hitZ) 
	{

		_tile = GetTileEntity(worldIn, pos);
		
		if (playerIn.getHeldItemMainhand() != ItemStack.EMPTY)
		{
			playerIn.getHeldItemMainhand().shrink(1);
			_tile.Add(playerIn.getHeldItemMainhand().getItem(), 1);
		}
		else 
		{
			playerIn.addItemStackToInventory(new ItemStack(_tile.GetItemStack().getItem(), 1));
			_tile.Decrece(1);
		}
		
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
	}

	@Override
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) 
	{
		if (!worldIn.isRemote) 
		{
			EntityItem tmp = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), ((testTileEntity)GetTileEntity(worldIn, pos)).GetItemStack());
			worldIn.spawnEntity(tmp);
		}
		super.onBlockDestroyedByPlayer(worldIn, pos, state);
	}
}
