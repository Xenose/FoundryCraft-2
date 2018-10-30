package com.xenose.foundrycraft.blocks;

import com.xenose.foundrycraft.FoundryApi.FoundryBlock;

import net.minecraft.block.material.Material;

public class Lamp extends FoundryBlock
{
	public Lamp(String name) 
	{ 
		super(Material.IRON, name);
		this.SetLightLevel(1.0f);
	}
}
