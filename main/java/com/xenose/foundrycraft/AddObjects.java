package com.xenose.foundrycraft;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import javax.swing.plaf.metal.MetalScrollBarUI;

import com.xenose.foundrycraft.FoundryApi.FoundryItem;
import com.xenose.foundrycraft.FoundryApi.FoundryRegister;
import com.xenose.foundrycraft.FoundryApi.blocks.FoundryBlock;
import com.xenose.foundrycraft.FoundryApi.blocks.FoundryOre;
import com.xenose.foundrycraft.MetalTypes.Metal;
import com.xenose.foundrycraft.MetalTypes.Metals;
import com.xenose.foundrycraft.blocks.BleedingObsidian;
import com.xenose.foundrycraft.blocks.ClearGlass;
import com.xenose.foundrycraft.blocks.Lamp;
import com.xenose.foundrycraft.blocks.machines.IronFurnace;
import com.xenose.foundrycraft.items.CoalDust;

import net.minecraft.block.material.Material;



public class AddObjects 
{	
	
	
	private final static Metal metals[] = {
					//name	Hardness/hasOre/spawnChance/Hight[min,max]/spawnsize[min,max]
			new Metal("aluminium", 	4, 	true, 	18, 	60, 70, 	3, 7),
			new Metal("cobalt", 	20, true, 	20, 	3, 5, 		1, 10),
			new Metal("copper", 	4, 	true, 	10, 	40, 60, 	3, 8),
			
			new Metal("lead", 		16, true,   5,		20, 60,		2, 7),
			new Metal("lithium", 	3, 	true, 	4, 		50, 100, 	5, 15),
			new Metal("magnesium", 	16, true),
			
			new Metal("nickel", 	16, true),
			new Metal("platinum", 	20, true, 	40, 	0, 2, 		1, 2),
			new Metal("silver", 	16, true),
			
			new Metal("tin", 		16, true),
			new Metal("titanium", 	16, true),
			new Metal("tungsten", 	16, true),
			
			new Metal("uranium", 	16, true),
			new Metal("zinc", 		16, true),
			
			new Metal("lowgradesteel", 16, false),
			new Metal("highgradesteel", 16, false)
	};
	
	public static TreeMap<String, Metals> metalList = new TreeMap<>();
	
	public static final FoundryItem irondust = new FoundryItem("irondust");
	public static final CoalDust coaldust = new CoalDust("coaldust");
	
	
	
	public static final FoundryBlock snowstone = new FoundryBlock("snowstone");
	public static final Lamp lamp = new Lamp("lamp");
	public static final ClearGlass clearglass = new ClearGlass("clearglass");
	public static final BleedingObsidian bleedingobsidian = new BleedingObsidian("bleedingobsidian");
	
	public static final IronFurnace ironfurnace = new IronFurnace("ironfurnace");
	
	private static List<FoundryItem> itemList;
	private static List<FoundryBlock> blockList;
	
	public static void Init() 
	{
		for (int i = 0; i < metals.length; i++) 
		{
			metalList.put(metals[i].GetName(), new Metals(metals[i]));
		}
		
		itemList = new ArrayList<FoundryItem>();
		blockList = new ArrayList<FoundryBlock>();
		
		FoundryRegister.Init();
		AddElements();
		
		for (int i = 0; i < itemList.size(); i++) 
		{
			FoundryRegister.AddItemToRegistry(itemList.get(i));
		}
		
		for (int i = 0; i < blockList.size(); i++) 
		{
			FoundryRegister.AddBlockToRegistry(blockList.get(i));
		}
	}
	
	private static void AddElements() 
	{
		for (int i = 0; i < metals.length; i++) 
		{
			metalList.get(metals[i].GetName()).AddToList(itemList, blockList);
		}
		/*
		aluminium.AddToList(itemList, blockList);
		cobalt.AddToList(itemList, blockList);
		copper.AddToList(itemList, blockList);
		lead.AddToList(itemList, blockList);
		lithium.AddToList(itemList, blockList);
		magnesium.AddToList(itemList, blockList);
		nickel.AddToList(itemList, blockList);
		platinum.AddToList(itemList, blockList);
		silver.AddToList(itemList, blockList);
		tin.AddToList(itemList, blockList);
		titanium.AddToList(itemList, blockList);
		tungsten.AddToList(itemList, blockList);
		uranium.AddToList(itemList, blockList);
		zinc.AddToList(itemList, blockList);
		
		lowgradesteel.AddToList(itemList, blockList);
		*/
		
		itemList.add(coaldust);
		itemList.add(irondust);
		
		
		blockList.add(snowstone);
		blockList.add(lamp);
		blockList.add(clearglass);
		blockList.add(bleedingobsidian);
		blockList.add(ironfurnace);
	}

}
