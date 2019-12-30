package gm910.godmod.handling;

import gm910.godmod.GodMod;
import gm910.godmod.gods.GodData;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid=GodMod.MODID, bus=Mod.EventBusSubscriber.Bus.FORGE, value=Dist.DEDICATED_SERVER)
public class EventHandling {

	@SubscribeEvent
	public void onLoad(WorldEvent.Load event) {
		
		if (event.getWorld().isRemote()) return;
		ServerWorld world = ((ServerWorld)event.getWorld().getWorld()).getWorldServer();
		MinecraftServer server = world.getServer();
		ServerWorld overworld = server.getWorld(DimensionType.OVERWORLD);
		GodData gods = GodData.get(overworld);
		server.getPlayerList().sendMessage(gods.getListComponent());
	}
	
}
