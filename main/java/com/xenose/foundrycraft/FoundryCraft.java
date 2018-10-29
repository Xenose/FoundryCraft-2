package com.xenose.foundrycraft;

import com.xenose.foundrycraft.FoundryApi.FoundryOreDictionary;
import com.xenose.foundrycraft.FoundryApi.FoundryRegister;
import com.xenose.foundrycraft.FoundryApi.FoundryWorldGen;
import com.xenose.foundrycraft.FoundryApi.Proxy.CommonProxy;
import com.xenose.foundrycraft.blocks.FoundryOre;
import com.xenose.foundrycraft.crafting.FoundryRecipes;

import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = FoundryCraftData.id, name = FoundryCraftData.name, version = FoundryCraftData.version)
public class FoundryCraft
{
	
	@Instance
	public static FoundryCraft instance;
	
	@SidedProxy(clientSide = FoundryCraftData.clientProxy, serverSide = FoundryCraftData.serverProxy)
	public static CommonProxy commonProxy;
	
	@EventHandler
    public void PreInit(FMLPreInitializationEvent event)
    {
		for(int i = 0; i < 100; i++) 
		{
			System.out.println("");
		}
		AddObjects.Init();
		System.out.println("FoundryCraft [Blocks loaded] : " + FoundryRegister.blockCount + ", [Items loaded] : " + FoundryRegister.itemCount);
		
		GameRegistry.registerWorldGenerator(new FoundryWorldGen(), 3);
    }

    @EventHandler
    public void Init(FMLInitializationEvent event)
    {
    	commonProxy.Init();
    	FoundryRecipes.Init();
    	FoundryOreDictionary.Init();
    }
    
    @EventHandler
    public void PostInit(FMLPostInitializationEvent event) 
    {
    	
    }
}
