package gm910.godmod.lists;

import java.util.HashMap;
import java.util.Map;

import gm910.godmod.GodMod;
import gm910.godmod.items.ItemBase;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent.Register;

public class ItemList {
	
	public static Item pyrite;
	
	public static Item pyrite_block;
	
	public static final Map<String, Item> ITEMS = new HashMap<String, Item>();
	
	public static void createItems() {
		
	}
	
	public static void itemInit(final Register<Item> event) {
		createItems();
		event.getRegistry().registerAll(
				pyrite = new Item(ItemBase.itemProps()).setRegistryName(ItemBase.location("fools_gold")),
				pyrite_block = new BlockItem(BlockList.pyrite_block, ItemBase.itemProps()).setRegistryName(BlockList.pyrite_block.getRegistryName())
		);
	}

	
}
