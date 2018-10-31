package com.xenose.foundrycraft.FoundryApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.xenose.foundrycraft.AddObjects;
import com.xenose.foundrycraft.FoundryApi.blocks.FoundryOre;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

public class FoundryWorldGen implements IWorldGenerator
{

	public static List<FoundryOre> oreGenList_overWolrd = new ArrayList<FoundryOre>();
	
	boolean first = true;
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) 
	{
		
		if (world.provider.getDimension() == 0) 
		{
			for (int i = 0; i < oreGenList_overWolrd.size(); i++) 
			{
				WorldGen(
						oreGenList_overWolrd.get(i).getDefaultState(), 
						world, 
						random, 
						new BlockPos(chunkX * 16, oreGenList_overWolrd.get(i).GetMinHeight(),chunkZ * 16),  
						oreGenList_overWolrd.get(i).GetMaxHeight() - oreGenList_overWolrd.get(i).GetMinHeight(), 
						random.nextInt(oreGenList_overWolrd.get(i).GetMaxSpawnSize()) + oreGenList_overWolrd.get(i).GetMinSpawnSize(), 
						oreGenList_overWolrd.get(i).GetSpawnChance());
			}
		}
	}
	
	private void WorldGen(IBlockState ore, World world, Random random, BlockPos pos, int deltaHeight, int clusterSize, int chance)
	{
		//System.out.println("\n\n\n World Gen valuse <=========== \n" + ore +"\n" + world +"\n" + random +"\n" + deltaHeight + "\n" + clusterSize + "\n" + chance + "\n\n");
		
		for (int i = 0; i < chance; i++) 
		{
			BlockPos tmpPos = new BlockPos(pos.getX() + random.nextInt(16), pos.getY() + random.nextInt(deltaHeight), pos.getZ() + random.nextInt(16));
			WorldGenMinable tmp = new WorldGenMinable(ore, clusterSize);
			tmp.generate(world, random, tmpPos);
		}
	}
	
}
