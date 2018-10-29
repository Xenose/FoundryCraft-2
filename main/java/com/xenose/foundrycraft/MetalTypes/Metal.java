package com.xenose.foundrycraft.MetalTypes;

import java.util.List;

import com.xenose.foundrycraft.FoundryApi.FoundryBlock;
import com.xenose.foundrycraft.FoundryApi.FoundryItem;
import com.xenose.foundrycraft.FoundryApi.FoundryWorldGen;
import com.xenose.foundrycraft.blocks.FoundryOre;

import net.minecraft.block.material.Material;

public class Metal 
{
	FoundryItem _dust;
	FoundryItem _ingot;
	
	FoundryOre _ore;
	FoundryBlock _block;
	
	public Metal(String name, float hardness) 
	{
		_ingot = new FoundryItem(name + "ingot");
		_dust = new FoundryItem(name + "dust");
		_ore = new FoundryOre(Material.ROCK, name + "ore", hardness);
		_block = new FoundryBlock(Material.IRON, name + "block", hardness);
		
		FoundryWorldGen.oreGenList_overWolrd.add(_ore);
	}
	
	public Metal(String name, float hardness, int worldSpawnChance, int minSpawnSize, int maxSpawnSize)
	{
		_ingot = new FoundryItem(name + "ingot");
		_dust = new FoundryItem(name + "dust");
		_ore = new FoundryOre(Material.ROCK, name + "ore", hardness);
		_block = new FoundryBlock(Material.IRON, name + "block", hardness);
		
		_ore.SetSpawnChance(worldSpawnChance);
		_ore.SetSpawnSize(maxSpawnSize, minSpawnSize);
		
		FoundryWorldGen.oreGenList_overWolrd.add(_ore);
	}
	
	public Metal(String name, float hardness, int worldSpawnChance, int minSpawnSize, int maxSpawnSize, int minHeight, int maxHeight) 
	{
		_ingot = new FoundryItem(name + "ingot");
		_dust = new FoundryItem(name + "dust");
		_ore = new FoundryOre(Material.ROCK, name + "ore", hardness);
		_block = new FoundryBlock(Material.IRON, name + "block", hardness);
		
		_ore.SetSpawnChance(worldSpawnChance);
		_ore.SetSpawnSize(maxSpawnSize, minSpawnSize);
		
		_ore.SetMinMaxHight(minHeight, maxHeight);
		
		FoundryWorldGen.oreGenList_overWolrd.add(_ore);
	}
	
	public final FoundryItem GetDust() { return _dust; }
	public final FoundryItem GetIngot() { return _ingot; }
	
	public final FoundryBlock GetOre() { return _ore; }
	public final FoundryBlock GetBlock() { return _block; }
	
	public void AddToList(List<FoundryItem> itemList, List<FoundryBlock> blockList) 
	{
		itemList.add(_dust);
		itemList.add(_ingot);
		
		blockList.add(_ore);
		blockList.add(_block);
	}

}
