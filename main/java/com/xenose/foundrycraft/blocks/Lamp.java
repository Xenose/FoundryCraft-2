package com.xenose.foundrycraft.blocks;

import com.xenose.foundrycraft.FoundryApi.blocks.FoundryBlock;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class Lamp extends FoundryBlock
{
	public Lamp(String name) 
	{ 
		super(Material.IRON, name);
		SetSoundType(SoundType.GLASS);
		this.SetLightLevel(1.0f);
	}
}
