package com.xenose.foundrycraft.MetalTypes;

import java.util.List;

import com.xenose.foundrycraft.FoundryApi.FoundryBlock;
import com.xenose.foundrycraft.FoundryApi.FoundryItem;
import com.xenose.foundrycraft.FoundryApi.FoundryOre;
import com.xenose.foundrycraft.FoundryApi.FoundryWorldGen;
import com.xenose.foundrycraft.blocks.LithiumOre;

import net.minecraft.block.material.Material;

public class Metal 
{
	FoundryItem _dust = null;
	FoundryItem _ingot = null;
	
	FoundryOre _ore = null;
	FoundryBlock _block = null;
	
	public Metal(String name, float hardness) 
	{
		Init(name, hardness, 20, 10, 20, 1, 100);
	}
	
	public Metal(String name, float hardness, int worldSpawnChance, int minSpawnSize, int maxSpawnSize)
	{
		Init(name, hardness, worldSpawnChance, minSpawnSize, maxSpawnSize, 1, 100);
	}
	
	public Metal(String name, float hardness, int worldSpawnChance, int minSpawnSize, int maxSpawnSize, int minHeight, int maxHeight) 
	{
		Init(name, hardness, worldSpawnChance, minSpawnSize, maxSpawnSize, minHeight, maxHeight);
	}
	
	private void Init(String name, float hardness, int worldSpawnChance, int minSpawnSize, int maxSpawnSize, int minHeight, int maxHeight) 
	{
		_ingot = new FoundryItem(name + "ingot");
		_dust = new FoundryItem(name + "dust");
		
		if (name != "lithium")
		{
			_ore = new FoundryOre(name + "ore");
		}
		else 
		{
			_ore = new LithiumOre(name + "ore");
		}
		
		_block = new FoundryBlock(Material.IRON, name + "block");
		
		_block.SetHardness(hardness);
		_ore.SetHardness(hardness);
		
		_ore.SetSpawnChance(worldSpawnChance);
		_ore.SetSpawnSize(maxSpawnSize, minSpawnSize);		
		_ore.SetMinMaxHight(minHeight, maxHeight);
		
		if (_ore != null)
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
