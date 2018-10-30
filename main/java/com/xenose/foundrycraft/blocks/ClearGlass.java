package com.xenose.foundrycraft.blocks;

import com.xenose.foundrycraft.FoundryApi.blocks.FoundryBlock;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class ClearGlass extends FoundryBlock
{
	public ClearGlass(String name) 
	{
		super(Material.GLASS, name);
		SetHardness(2);
		SetSoundType(SoundType.GLASS);
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
