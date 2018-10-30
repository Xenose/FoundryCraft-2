package com.xenose.foundrycraft.blocks.machines;

import com.xenose.foundrycraft.FoundryCraft;
import com.xenose.foundrycraft.FoundryCraftData;
import com.xenose.foundrycraft.FoundryApi.FoundryBlockAdvanceBlock;
import com.xenose.foundrycraft.TileEntitys.TileEntityIronFurnace;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class IronFurnace extends FoundryBlockAdvanceBlock
{
	public IronFurnace(String name) 
	{
		super(Material.IRON, name);
		SetHardness(4);
	}


	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		if(!worldIn.isRemote) 
		{
			playerIn.openGui(FoundryCraft.instance, FoundryCraftData.GUI_IRON_FURNACE, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) 
	{
		return new TileEntityIronFurnace();
	}

}
