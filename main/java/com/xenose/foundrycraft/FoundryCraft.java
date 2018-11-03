package com.xenose.foundrycraft;

import com.xenose.foundrycraft.FoundryApi.FoundryOreDictionary;
import com.xenose.foundrycraft.FoundryApi.FoundryRegister;
import com.xenose.foundrycraft.FoundryApi.FoundryWorldGen;
import com.xenose.foundrycraft.FoundryApi.Proxy.CommonProxy;
import com.xenose.foundrycraft.FoundryApi.blocks.FoundryOre;
import com.xenose.foundrycraft.TileEntitys.TileEntityIronFurnace;
import com.xenose.foundrycraft.TileEntitys.tests.testTileEntity;
import com.xenose.foundrycraft.crafting.FoundryRecipes;

import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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

		GameRegistry.registerTileEntity(testTileEntity.class, new ResourceLocation(FoundryCraftData.id + "testTileEntity"));
		AddObjects.Init();
		System.out.println("FoundryCraft [Blocks loaded] : " + FoundryRegister.blockCount + ", [Items loaded] : " + FoundryRegister.itemCount);
		
		GameRegistry.registerWorldGenerator(new FoundryWorldGen(), 3);
    }

    @EventHandler
    public void Init(FMLInitializationEvent event)
    {
    	commonProxy.Init();
    	FoundryOreDictionary.Init();
    	FoundryRecipes.Init();
    }
    
    @EventHandler
    public void PostInit(FMLPostInitializationEvent event) 
    {
    	
    }
    
}
