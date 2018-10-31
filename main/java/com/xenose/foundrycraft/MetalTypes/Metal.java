package com.xenose.foundrycraft.MetalTypes;

import com.xenose.foundrycraft.FoundryApi.blocks.FoundryBlock;
import com.xenose.foundrycraft.FoundryApi.blocks.FoundryOre;
import com.xenose.foundrycraft.blocks.LithiumOre;


public class Metal {
	
	private String _name;
	private int _harvestLevel;
	private float _hardness;
	private boolean _hasOre;
	
	private int _spawnChance;
	private int _maxSpawnHight;
	private int _minSpawnHight;
	private int _maxSpawnSize;
	private int _minSpawnSize;
	
	public Metal() {}
	
	public Metal(String name, int harvestLevel, float hardness, boolean hasOre) 
	{
		SetName(name);
		SetHarvestLevel(harvestLevel);
		SetHardness(hardness);
		SetHasOre(hasOre);
		
		
		
		SetSpawnChance(20);
		SetSpawnHight(10, 100);
		SetSpawnSize(3, 30);
	}
	
	public Metal(String name, int harvestLevel, float hardness, boolean hasOre, int spawnChance, int minSpawnHight, int maxSpawnHight, int minSpawnSize, int maxSpawnSize) 
	{
		SetName(name);
		SetHarvestLevel(harvestLevel);
		SetHardness(hardness);
		SetHasOre(hasOre);
		
		SetSpawnChance(spawnChance);
		SetSpawnHight(minSpawnHight, maxSpawnHight);
		SetSpawnSize(minSpawnSize, maxSpawnSize);
	}
	
	public void SetName(String name) { this._name = name; }
	public void SetHarvestLevel(int level) { this._harvestLevel = level; }
	public void SetHardness(float hardness) { this._hardness = hardness; }
	public void SetHasOre(boolean has) { this._hasOre = has; }
	
	public void SetSpawnChance(int spawnChance) { this._spawnChance = spawnChance; }
	public void SetMaxSpawnHight(int maxHight) { this._maxSpawnHight = maxHight; }
	public void SetMinSpawnHight(int minHight) { this._minSpawnHight = minHight; }
	
	public void SetSpawnHight(int minHight, int maxHight) 
	{
		SetMinSpawnHight(minHight);
		SetMaxSpawnHight(maxHight);
	}
	
	public void SetMaxSpawnSize(int maxSize) { this._maxSpawnSize = maxSize; }
	public void SetMinSpawnSize(int minSize) { this._minSpawnSize = minSize; }
	
	public void SetSpawnSize(int minSize, int maxSize) 
	{
		SetMinSpawnSize(minSize);
		SetMaxSpawnSize(maxSize);
	}
	
	public final String GetName() { return _name; }
	public int GetHarvestLevel() { return this._harvestLevel; }
	public final float GetHardness() { return _hardness; }
	public boolean GetHasOre() { return this._hasOre; }
	
	public final int GetSpawnChance() { return _spawnChance; }
	public final int GetMaxSpawnHight() { return  _maxSpawnHight; }
	public final int GetMinSpawnHight() { return _minSpawnSize; }
	public final int GetMaxSpawnSize() { return _maxSpawnSize; }
	public final int GetMinSpawnSize() { return _minSpawnSize; }

}
