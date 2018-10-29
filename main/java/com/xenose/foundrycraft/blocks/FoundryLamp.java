package com.xenose.foundrycraft.blocks;

import com.xenose.foundrycraft.FoundryApi.FoundryBlock;

import net.minecraft.block.material.Material;

public class FoundryLamp extends FoundryBlock
{

	public FoundryLamp(Material materialIn) 
	{ 
		super(materialIn);
		this.SetLightLevel(1.0f);
	}
	
	public FoundryLamp(Material materialIn, String name) 
	{ 
		super(materialIn, name);
		this.SetLightLevel(1.0f);
	}
	
	public FoundryLamp(Material materialIn, String name, float hardness) 
	{ 
		super(materialIn, name, hardness); 
		this.SetLightLevel(1.0f);
	}

}
