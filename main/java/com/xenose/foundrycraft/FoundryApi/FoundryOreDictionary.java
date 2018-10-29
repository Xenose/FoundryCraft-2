package com.xenose.foundrycraft.FoundryApi;

import com.xenose.foundrycraft.AddObjects;

import net.minecraftforge.oredict.OreDictionary;

public class FoundryOreDictionary {
	
	public static void Init() 
	{
		OreDictionary.registerOre("dustCoal", AddObjects.coaldust);
		OreDictionary.registerOre("dustIron", AddObjects.irondust);
		
		OreDictionary.registerOre("dustAluminium", AddObjects.aluminium.GetDust());
		OreDictionary.registerOre("dustCobalt", AddObjects.cobalt.GetDust());
		OreDictionary.registerOre("dustCopper", AddObjects.copper.GetDust());
		OreDictionary.registerOre("dustLead", AddObjects.lead.GetDust());
		OreDictionary.registerOre("dustLithium", AddObjects.lithium.GetDust());
		OreDictionary.registerOre("dustMagnesium", AddObjects.magnesium.GetDust());
		OreDictionary.registerOre("dustNickel", AddObjects.nickel.GetDust());
		OreDictionary.registerOre("dustPlatinum", AddObjects.platinum.GetDust());
		OreDictionary.registerOre("dustSilver", AddObjects.silver.GetDust());
		OreDictionary.registerOre("dustTin", AddObjects.tin.GetDust());
		OreDictionary.registerOre("dustTitanium", AddObjects.titanium.GetDust());
		OreDictionary.registerOre("dustTungsten", AddObjects.tungsten.GetDust());
		OreDictionary.registerOre("dustUranium", AddObjects.uranium.GetDust());
		OreDictionary.registerOre("dustZinc", AddObjects.zinc.GetDust());
		
		OreDictionary.registerOre("ingotSteel", AddObjects.lowgradesteelingot);
		
		OreDictionary.registerOre("ingotAluminium", AddObjects.aluminium.GetIngot());
		OreDictionary.registerOre("ingotCobalt", AddObjects.cobalt.GetIngot());
		OreDictionary.registerOre("ingotCopper", AddObjects.copper.GetIngot());
		OreDictionary.registerOre("ingotLead", AddObjects.lead.GetIngot());
		OreDictionary.registerOre("ingotLithium", AddObjects.lithium.GetIngot());
		OreDictionary.registerOre("ingotMagnesium", AddObjects.magnesium.GetIngot());
		OreDictionary.registerOre("ingotNickel", AddObjects.nickel.GetIngot());
		OreDictionary.registerOre("ingotPlatinum", AddObjects.platinum.GetIngot());
		OreDictionary.registerOre("ingotSilver", AddObjects.silver.GetIngot());
		OreDictionary.registerOre("ingotTin", AddObjects.tin.GetIngot());
		OreDictionary.registerOre("ingotTitanium", AddObjects.titanium.GetIngot());
		OreDictionary.registerOre("ingotTungsten", AddObjects.tungsten.GetIngot());
		OreDictionary.registerOre("ingotUranium", AddObjects.uranium.GetIngot());
		OreDictionary.registerOre("ingotZinc", AddObjects.zinc.GetIngot());
		
		OreDictionary.registerOre("oreAluminium", AddObjects.aluminium.GetOre());
		OreDictionary.registerOre("oreCobalt", AddObjects.aluminium.GetOre());
		OreDictionary.registerOre("oreCopper", AddObjects.copper.GetOre());
		OreDictionary.registerOre("oreLead", AddObjects.lead.GetOre());
		OreDictionary.registerOre("oreLithium", AddObjects.lithium.GetOre());
		OreDictionary.registerOre("oreMagnesium", AddObjects.magnesium.GetOre());
		OreDictionary.registerOre("oreNickel", AddObjects.nickel.GetOre());
		OreDictionary.registerOre("orePlatinum", AddObjects.platinum.GetOre());
		OreDictionary.registerOre("oreSilver", AddObjects.silver.GetOre());
		OreDictionary.registerOre("oreTin", AddObjects.tin.GetOre());
		OreDictionary.registerOre("oreTitanium", AddObjects.titanium.GetOre());
		OreDictionary.registerOre("oreTungsten", AddObjects.tungsten.GetOre());
		OreDictionary.registerOre("oreUranium", AddObjects.uranium.GetOre());
		OreDictionary.registerOre("oreZinc", AddObjects.zinc.GetOre());
		
		OreDictionary.registerOre("blockAluminium", AddObjects.aluminium.GetBlock());
	}

}
