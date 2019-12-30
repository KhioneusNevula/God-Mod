package gm910.godmod.gods;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import gm910.godmod.GodMod;
import gm910.godmod.gods.deities.Deity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.WorldSavedData;
import net.minecraftforge.common.util.Constants.NBT;

public class GodData extends WorldSavedData {
	
	public static final String NAME = GodMod.MODID + "_goddata";

	public final Map<String, Deity> DEITIES;
	
	public GodData() {
		super(NAME);
		DEITIES = new HashMap<String, Deity>();
	}
	
	public GodData createDeity(String name, String domain, String natureOfBeing, String worshipPlace) {
		Deity deity = new Deity(name, domain, natureOfBeing, worshipPlace);
		DEITIES.put(name, deity);
		this.markDirty();
		return this;
	}
	
	public ITextComponent getListComponent() {
		
		ITextComponent string = new StringTextComponent("-> ");
		if (!DEITIES.isEmpty()) {
			for (Deity deity : DEITIES.values()) {
				string = string.appendSibling(deity.getDisplayName("", "; "));
			}
		}
		
		return string;
	}
	
	@Override
	public void read(CompoundNBT nbt) {
		DEITIES.clear();
		ListNBT deities = nbt.getList("Deities", NBT.TAG_COMPOUND);
		if (!deities.isEmpty()) {
			for (INBT tag_ : deities) {
				CompoundNBT tag = (CompoundNBT)tag_;
				Deity deity = new Deity(tag.getString("Name"));
				deity.deserializeNBT(tag.getCompound("Deity"));
				DEITIES.put(deity.name, deity);
			}
		}
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		ListNBT deities = new ListNBT();
		if (!DEITIES.isEmpty()) {
			for (Entry<String, Deity> entry : DEITIES.entrySet()) {
				CompoundNBT tag = new CompoundNBT();
				tag.putString("Name", entry.getKey());
				tag.put("Deity", entry.getValue().serializeNBT());
			}
		}
		compound.put("Deities", deities);
		return compound;
	}
	
	public static GodData get(ServerWorld world) {
		if (world.dimension.getType().getId() != 0) return null;
		GodData instance = world.getSavedData().getOrCreate(() -> new GodData(), NAME);
		  
		return instance;
	}

}
