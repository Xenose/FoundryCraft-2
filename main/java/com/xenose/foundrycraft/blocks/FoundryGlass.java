package com.xenose.foundrycraft.blocks;

import com.xenose.foundrycraft.FoundryApi.FoundryBlock;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class FoundryGlass extends FoundryBlock
{
	
	public FoundryGlass(Material materialIn) 
	{
		super(materialIn, "setNamePlzzz", 1);
	}
	
	public FoundryGlass(Material materialIn, String name) 
	{
		super(materialIn, name, 1);
	}

	public FoundryGlass(Material materialIn, String name, float hardness) 
	{
		super(materialIn, name, hardness);
	}
	
	@Override
	public BlockRenderLayer getBlockLayer() 
	{
		return BlockRenderLayer.CUTOUT;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) 
	{
		return false;
	}
	
	@Override
	public boolean isTranslucent(IBlockState state) 
	{
		return true;
	}

}
