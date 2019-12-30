package gm910.godmod.lists;

import gm910.godmod.GodMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;

public class ItemList {
	
	public static Item holy_book;
	
	public static void itemInit() {
		ItemList.holy_book = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("holy_book"));
	}
	
	public static ResourceLocation location(String name) {
		return new ResourceLocation(GodMod.MODID, name);
	}
	
}
