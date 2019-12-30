package gm910.godmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import gm910.godmod.gods.GodData;
import gm910.godmod.handling.EventHandling;
import gm910.godmod.lists.BlockList;
import gm910.godmod.lists.ItemList;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("gm910godmod")
public class GodMod {
	
	public static GodMod instance;
	public static final String MODID = "gm910godmod";
	public static final Logger logger = LogManager.getLogger(MODID);
	
	public static final ItemGroup GOD_ITEM_GROUP = new GodItemGroup();
	
	public GodMod() {
		
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.register(new EventHandling());
	}
	
	public static MinecraftServer getServer() {
		return Minecraft.getInstance().getIntegratedServer();
	}
	
	public static GodData getGods() {
		return GodData.get(Minecraft.getInstance().getIntegratedServer().getWorld(DimensionType.OVERWORLD));
	}
	
	public static ServerWorld getWorld0() {
		return Minecraft.getInstance().getIntegratedServer().getWorld(DimensionType.OVERWORLD);
	}
	
	/**
	 * Pre init, basically
	 */
	private void setup(final FMLCommonSetupEvent event) {
		logger.info("Setup method registered");
	}
	
	/**
	 * Models and stuff
	 */
	private void clientRegistries(final FMLClientSetupEvent event) {
		logger.info("Client Registries method registered");
	}
	
	@EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {
		
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			ItemList.itemInit(event);
			
			logger.info("Items registering");
		}
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) {
			BlockList.blockInit(event);
			
			logger.info("Blocks registering");
		}
		
		
		
		public static ResourceLocation location(String name) {
			return new ResourceLocation(MODID, name);
		}
	}
	
}
