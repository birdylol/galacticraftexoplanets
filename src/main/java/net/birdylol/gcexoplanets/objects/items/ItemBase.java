package net.birdylol.gcexoplanets.objects.items;

import net.birdylol.gcexoplanets.GCExo;
import net.birdylol.gcexoplanets.init.ItemInit;
import net.birdylol.gcexoplanets.util.IHasModel;

import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;


public class ItemBase extends Item implements IHasModel
{

	public ItemBase(String name) 
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		
		ItemInit.ITEMS.add(this);
	}

	@Override
	public void registerModels() 
	{
		GCExo.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
}
