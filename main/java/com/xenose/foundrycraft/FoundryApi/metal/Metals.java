package com.xenose.foundrycraft.FoundryApi.metal;

import java.util.List;

import scala.collection.mutable.Cloneable;
import scala.tools.nsc.backend.icode.analysis.TypeFlowAnalysis.MTFAGrowable;

import com.xenose.foundrycraft.FoundryCraftData;
import com.xenose.foundrycraft.FoundryApi.FoundryWorldGen;
import com.xenose.foundrycraft.FoundryApi.blocks.FoundryBlock;
import com.xenose.foundrycraft.FoundryApi.blocks.FoundryOre;
import com.xenose.foundrycraft.FoundryApi.items.FoundryItem;
import com.xenose.foundrycraft.blocks.LithiumOre;

import net.minecraft.block.material.Material;
import net.minecraftforge.oredict.OreDictionary;

public class Metals 
{
	FoundryItem _dust = null;
	FoundryItem _ingot = null;
	
	FoundryOre _ore = null;
	FoundryBlock _block = null;
	
	public Metals(Metal metal)
	{
		_ingot = new FoundryItem(metal.GetName() + "ingot");
		_dust = new FoundryItem(metal.GetName() + "dust");
		_block = new FoundryBlock(Material.IRON, metal.GetName() + "block");
		
		_block.SetHardness(metal.GetHardness());
		
		_block.setCreativeTab(FoundryCraftData.oreTab);
		_ingot.setCreativeTab(FoundryCraftData.oreTab);
		_dust.setCreativeTab(FoundryCraftData.oreTab);
		
		if (metal.GetHasOre()) 
		{
			switch (metal.GetName()) 
			{
				case "lithium":
					_ore = new LithiumOre(metal.GetName() + "ore");
					break;
				default:
					_ore = new FoundryOre(metal.GetName() + "ore");
					break;
			}
			
			_ore.SetHardness(metal.GetHardness());
			_ore.SetHarvestLevel(metal.GetHarvestLevel());
			
			_ore.SetSpawnChance(metal.GetSpawnChance());
			_ore.SetMinMaxHight(metal.GetMinSpawnHight(), metal.GetMaxSpawnHight());
			_ore.SetSpawnSize(metal.GetMinSpawnSize(), metal.GetMaxSpawnSize());
			
			if (_ore != null)
				FoundryWorldGen.oreGenList_overWolrd.add(_ore);
		}
		
	}
	
	public final FoundryItem GetDust() { return _dust; }
	public final FoundryItem GetIngot() { return _ingot; }
	
	public final FoundryBlock GetOre() { return _ore; }
	public final FoundryBlock GetBlock() { return _block; }
	
	public void AddToList(List<FoundryItem> itemList, List<FoundryBlock> blockList) 
	{
		itemList.add(_dust);
		itemList.add(_ingot);
		blockList.add(_block);
		
		if (_ore != null)
			blockList.add(_ore);
	}

}
