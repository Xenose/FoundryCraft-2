package com.xenose.foundrycraft.FoundryApi.items.tools;

import com.xenose.foundrycraft.FoundryApi.items.FoundryItem;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BedrockRemovelTool extends FoundryItem
{
	public BedrockRemovelTool(String name)
	{
		super(name);
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		if (worldIn.getBlockState(pos).getBlock() == Blocks.BEDROCK && pos.getY() >= 1)
			worldIn.setBlockToAir(pos);
		
		return EnumActionResult.SUCCESS;
	}
}
