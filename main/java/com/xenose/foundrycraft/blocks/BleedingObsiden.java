package com.xenose.foundrycraft.blocks;

import com.xenose.foundrycraft.FoundryApi.FoundryBlock;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BleedingObsiden extends FoundryBlock
{
	public BleedingObsiden(Material materialIn) { super(materialIn); }
	public BleedingObsiden(Material materialIn, String name) { super(materialIn, name); }
	public BleedingObsiden(Material materialIn, String name, float hardness) { super(materialIn, name, hardness); }
	
	@Override
	public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) 
	{
		super.onBlockClicked(worldIn, pos, playerIn);
		
		playerIn.setSpawnPoint(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), true);
	}

}
