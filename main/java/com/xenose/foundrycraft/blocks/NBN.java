package com.xenose.foundrycraft.blocks;

import com.xenose.foundrycraft.FoundryApi.blocks.FoundryBlock;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class NBN extends FoundryBlock 
{
	public NBN(String name) 
	{
		super(Material.ROCK, name);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		for (int x = 0; x <= 8; x++) 
		{
			for (int y = 0; y <= 8; y++) 
			{
				for (int z = 0; z <= 8; z++) 
				{
					if (y == 0 || y == 8 || z == 0 || z == 8 || x == 0 || x == 8)
						worldIn.setBlockState(new BlockPos(pos.getX() + x - 4, pos.getY() - 1 + y, pos.getZ() + z - 4), Blocks.STONE.getDefaultState(), 1);
					else
						worldIn.setBlockToAir(new BlockPos(pos.getX() + x - 4, pos.getY() - 1 + y, pos.getZ() + z - 4));
				}
			}
		}
		
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
	}
}
