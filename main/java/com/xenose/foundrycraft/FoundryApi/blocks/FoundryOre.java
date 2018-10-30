package com.xenose.foundrycraft.FoundryApi.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class FoundryOre extends FoundryBlock
{

	int _chance = 5;
	int _size = 4;
	int _minSize = 0;
	int _max = 70, _min = 16;
	
	
	public FoundryOre(String name) 
	{
		super(Material.ROCK, name);
		SetSoundType(SoundType.STONE);
	}
	
	public void SetSpawnChance(int chance) 
	{
		_chance = chance;
	}
	
	public void SetSpawnSize(int max, int min) 
	{
		_size = max;
		_minSize = min;
	}
	
	public final int GetSpawnChance() 
	{
		return _chance;
	}
	
	public final int GetMinSpawnSize() 
	{
		return _minSize;
	}
	
	public final int GetMaxSpawnSize() 
	{
		return _size;
	}
	
	public void SetMinMaxHight(int min, int max) 
	{
		_min = min;
		_max = max;
	}
	
	public final int GetMinHeight() 
	{
		return _min;
	}
	
	public final int GetMaxHeight() 
	{
		return _max;
	}

}
