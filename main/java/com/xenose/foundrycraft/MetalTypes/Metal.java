package com.xenose.foundrycraft.MetalTypes;

import com.xenose.foundrycraft.FoundryApi.blocks.FoundryOre;

public class Metal {
	
	private String _name;
	private float _hardness;
	private Class _ore;
	
	private int _spawnChance;
	private int _maxSpawnHight;
	private int _minSpawnHight;
	private int _maxSpawnSize;
	private int _minSpawnSize;
	
	public Metal() {}
	
	public Metal(String name, float hardness, Class ore, int spawnChance, int minSpawnHight, int maxSpawnHight, int minSpawnSize, int maxSpawnSize) 
	{
		SetName(name);
		SetHardness(hardness);
		SetSpawnChance(spawnChance);
		SetSpawnHight(minSpawnHight, maxSpawnHight);
		SetSpawnSize(minSpawnSize, maxSpawnSize);
	}
	
	public void SetName(String name) { this._name = name; }
	public void SetHardness(float hardness) { this._hardness = hardness; }
	
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
	public final float GetHardness() { return _hardness; }
	
	public final int GetSpawnChance() { return _spawnChance; }
	public final int GetMaxSpawnHight() { return  _maxSpawnHight; }
	public final int GetMinSpawnHight() { return _minSpawnSize; }
	public final int GetMaxSpawnSize() { return _maxSpawnSize; }
	public final int GetMinSpawnSize() { return _minSpawnSize; }

}
