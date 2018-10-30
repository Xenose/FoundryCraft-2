package com.xenose.foundrycraft.blocks;

import java.util.Random;

import com.xenose.foundrycraft.FoundryApi.blocks.FoundryOre;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class LithiumOre extends FoundryOre 
{

	private int _explotionChance = 16;
	
	public LithiumOre(String name) 
	{ 
		super(name); 
	}
	
	@Override
	public void onBlockDestroyedByExplosion(World worldIn, BlockPos pos, Explosion explosionIn) 
	{
		super.onBlockDestroyedByExplosion(worldIn, pos, explosionIn);
		Explode(worldIn, pos, 10);
	}
	
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) 
	{
		super.onBlockHarvested(worldIn, pos, state, player);
		
		if (player.getHeldItemMainhand().getItem() != Items.WOODEN_PICKAXE)
			Explode(worldIn, pos, 10);
	}
	
	public void Explode(World world, BlockPos pos, int strength) 
	{
		Random random = new Random();
		
		if (random.nextInt(_explotionChance) <= 1)
		{
			int dmg = random.nextInt(12) + 4;
			
			if (!world.isRemote)
				world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), dmg, true);
		}
	}

}
