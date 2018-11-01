package com.xenose.foundrycraft;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import javax.swing.plaf.metal.MetalScrollBarUI;

import com.xenose.foundrycraft.FoundryApi.FoundryRegister;
import com.xenose.foundrycraft.FoundryApi.blocks.FoundryBlock;
import com.xenose.foundrycraft.FoundryApi.blocks.FoundryBlockAdvanceBlock;
import com.xenose.foundrycraft.FoundryApi.blocks.FoundryOre;
import com.xenose.foundrycraft.FoundryApi.items.FoundryItem;
import com.xenose.foundrycraft.FoundryApi.items.tools.BedrockRemovelTool;
import com.xenose.foundrycraft.FoundryApi.items.tools.FoundryPickaxe;
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
			new Metal("aluminium",  1, 4,  true, 	18, 	60, 70, 	3, 7),
			new Metal("cobalt", 	5, 20, true, 	20, 	1, 10, 		1, 3),
			new Metal("copper", 	2, 4,  true, 	10, 	40, 60, 	3, 8),
			
			new Metal("lead", 		3, 16, true,    5,		20, 60,		2, 7),
			new Metal("lithium", 	2, 3,  true, 	4, 		50, 100, 	5, 15),
			new Metal("magnesium", 	2, 16, true,	10,		35, 45,		1, 5),
			
			new Metal("nickel", 	2, 16, true,	10,		1, 35,		2, 4),
			new Metal("platinum", 	4, 20, true, 	20, 	1, 4, 		1, 2),
			new Metal("silver", 	3, 16, true,	6,		1, 20,		1, 5),
			
			new Metal("tin", 		2, 16, true,	2,		20, 40,		4, 9),
			new Metal("titanium", 	5, 16, true,	10,		1, 6,		5, 10),
			new Metal("tungsten", 	6, 16, true,	10,		20, 25,		2, 4),
			
			new Metal("uranium", 	4, 16, true,	15,		10,	50,		1, 3),
			new Metal("zinc", 		3, 16, true,	20,		70, 100,	4, 10),
			
			new Metal("lowgradesteel", 	2, 16, false),
			new Metal("highgradesteel", 4, 16, false)
	};
	
	public static TreeMap<String, Metals> metalList = new TreeMap<>();
	
	public static final FoundryItem irondust = new FoundryItem("irondust");
	public static final CoalDust coaldust = new CoalDust("coaldust");
	
	public static final BedrockRemovelTool bedrockremoveltool = new BedrockRemovelTool("bedrockremoveltool");
	
	public static final FoundryPickaxe tungstenpickaxe = new FoundryPickaxe("tungstenpickaxe", 2,2);
	
	public static final FoundryBlock snowstone = new FoundryBlock("snowstone");
	public static final Lamp lamp = new Lamp("lamp");
	public static final ClearGlass clearglass = new ClearGlass("clearglass");
	public static final BleedingObsidian bleedingobsidian = new BleedingObsidian("bleedingobsidian");
	
	public static final FoundryBlockAdvanceBlock test = new FoundryBlockAdvanceBlock(Material.ROCK, "test");
	
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
		
		itemList.add(coaldust);
		itemList.add(irondust);
		itemList.add(bedrockremoveltool);
		itemList.add(tungstenpickaxe);
		
		blockList.add(snowstone);
		blockList.add(lamp);
		blockList.add(clearglass);
		blockList.add(bleedingobsidian);
		blockList.add(ironfurnace);
		blockList.add(test);
	}

}
