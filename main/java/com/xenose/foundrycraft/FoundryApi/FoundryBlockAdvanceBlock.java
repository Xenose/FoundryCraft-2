package com.xenose.foundrycraft.FoundryApi;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;

public class FoundryBlockAdvanceBlock extends FoundryBlock
{
	public static final PropertyDirection _facing = BlockHorizontal.FACING;
	
	public FoundryBlockAdvanceBlock(Material materialIn, String name) 
	{ 
		super(materialIn, name); 
	}

}
