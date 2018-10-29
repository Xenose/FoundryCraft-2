package com.xenose.foundrycraft.FoundryApi;

import java.util.Random;

import com.xenose.foundrycraft.FoundryCraft;
import com.xenose.foundrycraft.FoundryCraftData;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.xml.transform.RewriteRule;;

public class FoundryBlock extends Block
{

	public FoundryBlock(Material materialIn) 
	{
		super(materialIn);
		InitBlock(materialIn, "setNamePlzzz", 1);
	}
	
	public FoundryBlock(Material materialIn, String name) 
	{
		super(materialIn);
		InitBlock(materialIn, name, 1);
	}
	
	public FoundryBlock(Material materialIn, String name, float hardness) 
	{
		super(materialIn);
		InitBlock(materialIn, name, hardness);
		
	}
	
	private void InitBlock(Material materialIn, String name, float hardness) 
	{
		this.setRegistryName(FoundryCraftData.id, name);
		this.setUnlocalizedName(name);
		SetHardness(hardness);
		
		this.setCreativeTab(getCreativeTabToDisplayOn().MISC);
	}
	
	public void SetHardness(float hardness) 
	{
		this.setHardness(hardness);
	}
	
	public void SetTexture() 
	{
		FoundryCraft.commonProxy.SetBlockTexture(this, 0, "inventory");
	}
	
	public void SetLightLevel(float value) 
	{
		this.setLightLevel(value);
	}
	
	public void SetLightOpacity(int opacity)
    {
        this.setLightOpacity(opacity);
    }
	
	public void SetBlockLayer() 
	{
	}
	
	
	public void QuantityDropped(Random random)
    {
		this.quantityDropped(random);
    }

    public void IsFullBlock(IBlockState state)
    {
    }

    protected boolean CanSilkHarvest()
    {
        return CanSilkHarvest();
    }
}
