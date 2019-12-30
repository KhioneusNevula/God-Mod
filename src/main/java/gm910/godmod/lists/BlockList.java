package gm910.godmod.lists;

import java.util.HashMap;
import java.util.Map;

import gm910.godmod.blocks.BlockBase;
import gm910.godmod.items.ItemBase;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent.Register;

public class BlockList {

	public static Block pyrite_block;
	
	public static final Map<String, Block> BLOCKS = new HashMap<String, Block>();
	
	public static void createBlocks() {
		
	}
	
	public static void blockInit(final Register<Block> event) {
			event.getRegistry().registerAll(
					pyrite_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3, 6).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)).setRegistryName(ItemBase.location("pyrite_block"))
			);
	}

}
