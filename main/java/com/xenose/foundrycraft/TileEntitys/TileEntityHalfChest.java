package com.xenose.foundrycraft.TileEntitys;

import javax.swing.plaf.basic.BasicComboBoxUI.ItemHandler;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityHalfChest extends TileEntity 
{
	public static final int size = 9;
	
	public ItemStackHandler itemStackHandler = new ItemStackHandler(size)
	{
		@Override
		protected void onContentsChanged(int slot) 
		{
			TileEntityHalfChest.this.markDirty();
		};
	};
}
