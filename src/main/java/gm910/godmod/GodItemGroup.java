package gm910.godmod;

import gm910.godmod.lists.ItemList;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class GodItemGroup extends ItemGroup {

	public GodItemGroup() {
		super("godmod");
	}

	@Override
	public ItemStack createIcon() {
		
		return new ItemStack(ItemList.pyrite, 1);
	}

}
