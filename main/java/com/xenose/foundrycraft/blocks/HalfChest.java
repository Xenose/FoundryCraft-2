package com.xenose.foundrycraft.blocks;

import com.xenose.foundrycraft.FoundryCraft;
import com.xenose.foundrycraft.FoundryApi.blocks.FoundryBlockAdvanceBlock;
import com.xenose.foundrycraft.TileEntitys.TileEntityHalfChest;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HalfChest extends FoundryBlockAdvanceBlock implements ITileEntityProvider
{

	public static final int GUI_ID = 1;
	
	public HalfChest(String name) 
	{
		super(Material.WOOD, name);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) 
	{
		return null;
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, 
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		if (worldIn.isRemote) 
		{
			return true;
		}
		
		TileEntity te = worldIn.getTileEntity(pos);
		
		if (te instanceof TileEntityHalfChest) 
		{
			return false;
		}
		
		playerIn.openGui(FoundryCraft.instance, GUI_ID, worldIn, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}

}
