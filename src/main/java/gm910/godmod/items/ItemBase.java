package gm910.godmod.items;

import gm910.godmod.GodMod;
import gm910.godmod.lists.ItemList;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ItemBase extends Item {

	public ItemBase(String name, Properties properties) {
		super(properties);
		this.setRegistryName(location(name));
		ItemList.ITEMS.put(name, this);
	}
	
	public ItemBase(String name) {
		this(name, itemProps());
	}

	
	public static ResourceLocation location(String name) {
		return new ResourceLocation(GodMod.MODID, name);
	}
	
	public static Item.Properties itemProps() {
		return new Item.Properties().group(GodMod.GOD_ITEM_GROUP);
	}
}
