package com.xenose.foundrycraft.FoundryApi;

import com.xenose.foundrycraft.AddObjects;

import net.minecraftforge.oredict.OreDictionary;

public class FoundryOreDictionary {
	
	public static void Init() 
	{
		OreDictionary.registerOre("dustCoal", AddObjects.coaldust);
		OreDictionary.registerOre("dustIron", AddObjects.irondust);
		
		OreDictionary.registerOre("dustBronze", 	AddObjects.metalList.get("bronze").GetDust());
		OreDictionary.registerOre("dustSteel", 		AddObjects.metalList.get("highgradesteel").GetDust());
		
		OreDictionary.registerOre("dustAluminium", 	AddObjects.metalList.get("aluminium").GetDust());
		OreDictionary.registerOre("dustCobalt", 	AddObjects.metalList.get("cobalt").GetDust());
		OreDictionary.registerOre("dustCopper", 	AddObjects.metalList.get("copper").GetDust());
		OreDictionary.registerOre("dustLead", 		AddObjects.metalList.get("copper").GetDust());
		OreDictionary.registerOre("dustLithium", 	AddObjects.metalList.get("lithium").GetDust());
		OreDictionary.registerOre("dustMagnesium", 	AddObjects.metalList.get("magnesium").GetDust());
		OreDictionary.registerOre("dustNickel", 	AddObjects.metalList.get("nickel").GetDust());
		OreDictionary.registerOre("dustPlatinum", 	AddObjects.metalList.get("platinum").GetDust());
		OreDictionary.registerOre("dustSilver", 	AddObjects.metalList.get("silver").GetDust());
		OreDictionary.registerOre("dustTin", 		AddObjects.metalList.get("tin").GetDust());
		OreDictionary.registerOre("dustTitanium", 	AddObjects.metalList.get("titanium").GetDust());
		OreDictionary.registerOre("dustTungsten", 	AddObjects.metalList.get("tungsten").GetDust());
		OreDictionary.registerOre("dustUranium", 	AddObjects.metalList.get("uranium").GetDust());
		OreDictionary.registerOre("dustZinc", 		AddObjects.metalList.get("zinc").GetDust());
		
		OreDictionary.registerOre("ingotSteel", 	AddObjects.metalList.get("highgradesteel").GetIngot());
		
		OreDictionary.registerOre("ingotAluminium", AddObjects.metalList.get("aluminium").GetIngot());
		OreDictionary.registerOre("ingotCobalt", 	AddObjects.metalList.get("cobalt").GetIngot());
		OreDictionary.registerOre("ingotCopper", 	AddObjects.metalList.get("copper").GetIngot());
		OreDictionary.registerOre("ingotLead", 		AddObjects.metalList.get("lead").GetIngot());
		OreDictionary.registerOre("ingotLithium", 	AddObjects.metalList.get("lithium").GetIngot());
		OreDictionary.registerOre("ingotMagnesium", AddObjects.metalList.get("magnesium").GetIngot());
		OreDictionary.registerOre("ingotNickel", 	AddObjects.metalList.get("nickel").GetIngot());
		OreDictionary.registerOre("ingotPlatinum", 	AddObjects.metalList.get("platinum").GetIngot());
		OreDictionary.registerOre("ingotSilver", 	AddObjects.metalList.get("silver").GetIngot());
		OreDictionary.registerOre("ingotTin", 		AddObjects.metalList.get("tin").GetIngot());
		OreDictionary.registerOre("ingotTitanium", 	AddObjects.metalList.get("titanium").GetIngot());
		OreDictionary.registerOre("ingotTungsten", 	AddObjects.metalList.get("tungsten").GetIngot());
		OreDictionary.registerOre("ingotUranium", 	AddObjects.metalList.get("uranium").GetIngot());
		OreDictionary.registerOre("ingotZinc", 		AddObjects.metalList.get("zinc").GetIngot());
		
		OreDictionary.registerOre("oreAluminium", 	AddObjects.metalList.get("aluminium").GetOre());
		OreDictionary.registerOre("oreCobalt", 		AddObjects.metalList.get("aluminium").GetOre());
		OreDictionary.registerOre("oreCopper", 		AddObjects.metalList.get("copper").GetOre());
		OreDictionary.registerOre("oreLead", 		AddObjects.metalList.get("lead").GetOre());
		OreDictionary.registerOre("oreLithium", 	AddObjects.metalList.get("lithium").GetOre());
		OreDictionary.registerOre("oreMagnesium", 	AddObjects.metalList.get("magnesium").GetOre());
		OreDictionary.registerOre("oreNickel", 		AddObjects.metalList.get("nickel").GetOre());
		OreDictionary.registerOre("orePlatinum", 	AddObjects.metalList.get("platinum").GetOre());
		OreDictionary.registerOre("oreSilver", 		AddObjects.metalList.get("silver").GetOre());
		OreDictionary.registerOre("oreTin", 		AddObjects.metalList.get("tin").GetOre());
		OreDictionary.registerOre("oreTitanium", 	AddObjects.metalList.get("titanium").GetOre());
		OreDictionary.registerOre("oreTungsten", 	AddObjects.metalList.get("tungsten").GetOre());
		OreDictionary.registerOre("oreUranium", 	AddObjects.metalList.get("uranium").GetOre());
		OreDictionary.registerOre("oreZinc", 		AddObjects.metalList.get("zinc").GetOre());
		
		OreDictionary.registerOre("blockAluminium", AddObjects.metalList.get("aluminium").GetBlock());
	}

}
