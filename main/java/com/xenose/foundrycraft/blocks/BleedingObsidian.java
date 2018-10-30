package com.xenose.foundrycraft.blocks;

import com.xenose.foundrycraft.FoundryApi.FoundryBlock;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class BleedingObsidian extends FoundryBlock
{
	public BleedingObsidian(String name) 
	{ 
		super(Material.ROCK, name); 
	}
	
	@Override
	public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) 
	{
		super.onBlockClicked(worldIn, pos, playerIn);
		
		playerIn.setSpawnPoint(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), true);
		System.out.print("Set spawn pos");
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		playerIn.setSpawnPoint(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), true);
		playerIn.sendStatusMessage(new TextComponentTranslation("Spawn point set!", new Object[0]), true);
		
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
	}

}
