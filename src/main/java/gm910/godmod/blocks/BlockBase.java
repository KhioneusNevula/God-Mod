package gm910.godmod.blocks;

import gm910.godmod.GodMod;
import gm910.godmod.items.ItemBase;
import gm910.godmod.lists.BlockList;
import gm910.godmod.lists.ItemList;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.util.ResourceLocation;

public class BlockBase extends Block {

	public BlockBase(String name, Properties properties, boolean makeItem) {
		super(properties);
		this.setRegistryName(new ResourceLocation(GodMod.MODID, name));
		BlockList.BLOCKS.put(name, this);
		/*if (makeItem) {
			String nombre = name;
			if (!nombre.contains("block")) {
				nombre = nombre + "_block";
			}
			ItemList.ITEMS.put(nombre, new BlockItem(this, ItemBase.itemProps()));
		}*/
	}
	
	public BlockBase(String name, Properties properties) {
		this(name, properties, true);
	}

}
