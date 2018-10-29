package com.xenose.foundrycraft.FoundryApi;

import com.xenose.foundrycraft.AddObjects;

import net.minecraftforge.oredict.OreDictionary;

public class FoundryOreDictionary {
	
	public void Init() 
	{
		OreDictionary.registerOre("dustCoal", AddObjects.coaldust);
		OreDictionary.registerOre("dustIron", AddObjects.irondust);
		
		OreDictionary.registerOre("oreAluminium", AddObjects.aluminium.GetOre());
		OreDictionary.registerOre("oreCobalt", AddObjects.aluminium.GetOre());
		OreDictionary.registerOre("oreCopper", AddObjects.copper.GetOre());
		OreDictionary.registerOre("oreLead", AddObjects.lead.GetOre());
		OreDictionary.registerOre("oreLithium", AddObjects.lithium.GetOre());
	}

}
