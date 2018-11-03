package com.xenose.foundrycraft;

import com.xenose.foundrycraft.FoundryApi.client.tabs.FoundryTab;

public class FoundryCraftData
{
	public static final String id = "xfc";
	public static final String name = "FoundryCraft";
	public static final String version = "1.0.a";
	
	public static final String clientProxy = "com.xenose.foundrycraft.FoundryApi.Proxy.ClientProxy";
	public static final String serverProxy = "com.xenose.foundrycraft.FoundryApi.Proxy.serverProxy";
	
	public static final int GUI_IRON_FURNACE = 0;
	
	public static final FoundryTab
		defualtTab = new FoundryTab("defualttab", 0),
		oreTab = new FoundryTab("oretab", 1);
}
