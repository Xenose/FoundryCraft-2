package com.xenose.foundrycraft;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.metal.MetalScrollBarUI;

import com.xenose.foundrycraft.FoundryApi.FoundryItem;
import com.xenose.foundrycraft.FoundryApi.FoundryRegister;
import com.xenose.foundrycraft.FoundryApi.blocks.FoundryBlock;
import com.xenose.foundrycraft.MetalTypes.Metal;
import com.xenose.foundrycraft.blocks.BleedingObsidian;
import com.xenose.foundrycraft.blocks.ClearGlass;
import com.xenose.foundrycraft.blocks.Lamp;
import com.xenose.foundrycraft.blocks.machines.IronFurnace;
import com.xenose.foundrycraft.items.CoalDust;

import net.minecraft.block.material.Material;

public class AddObjects 
{	
	public static final FoundryItem lowgradesteelingot = new FoundryItem("lowgradesteelingot");
	public static final FoundryItem highgradesteelingot = new FoundryItem("highgradesteelingot");
	
	public static final FoundryItem lowgradesteeldust = new FoundryItem("lowgradesteeldust");
	public static final FoundryItem highgradesteeldust = new FoundryItem("highgradesteeldust");
	
	public static final FoundryBlock lowgradesteelblock = new FoundryBlock(Material.IRON, "lowgradesteelblock");
	public static final FoundryBlock highgradesteelblock = new FoundryBlock(Material.IRON, "highgradesteelblock");
	
	public static final FoundryItem irondust = new FoundryItem("irondust");
	public static final CoalDust coaldust = new CoalDust("coaldust");
	
	public static final Metal aluminium = new Metal("aluminium", 4, 18, 2, 5, 60, 150);
	public static final Metal cobalt = new Metal("cobalt", 20, 20, 3, 5, 1, 10);
	public static final Metal copper = new Metal("copper", 4, 10, 2, 7, 50, 60 );
	public static final Metal lead = new Metal("lead", 16);
	public static final Metal lithium = new Metal("lithium", 3, 10, 10, 25);
	public static final Metal magnesium = new Metal("magnesium", 16);
	public static final Metal nickel = new Metal("nickel", 16);
	public static final Metal platinum = new Metal("platinum", 20, 40, 1, 2, 0, 1);
	public static final Metal silver = new Metal("silver", 16);
	public static final Metal tin = new Metal("tin", 16);
	public static final Metal titanium = new Metal("titanium", 16);
	public static final Metal tungsten = new Metal("tungsten", 16);
	public static final Metal uranium = new Metal("uranium", 16);
	public static final Metal zinc = new Metal("zinc", 16);
	
	public static final FoundryBlock snowstone = new FoundryBlock("snowstone");
	public static final Lamp lamp = new Lamp("lamp");
	public static final ClearGlass clearglass = new ClearGlass("clearglass");
	public static final BleedingObsidian bleedingobsidian = new BleedingObsidian("bleedingobsidian");
	
	public static final IronFurnace ironfurnace = new IronFurnace("ironfurnace");
	
	private static List<FoundryItem> itemList;
	private static List<FoundryBlock> blockList;
	
	public static void Init() 
	{
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
		
		itemList.add(coaldust);
		itemList.add(irondust);
		
		itemList.add(lowgradesteeldust);
		itemList.add(lowgradesteelingot);
		
		blockList.add(snowstone);
		blockList.add(lamp);
		blockList.add(clearglass);
		blockList.add(bleedingobsidian);
		blockList.add(ironfurnace);
	}

}
