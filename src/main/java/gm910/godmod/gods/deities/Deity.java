package gm910.godmod.gods.deities;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.common.util.INBTSerializable;

public class Deity implements INBTSerializable<CompoundNBT>{

	public final String name;
	protected String natureOfBeing;
	protected String domain;
	protected String placeOfWorship;
	protected String displayName;
	
	public Deity(String name) {
		this(name, name, "Everything", "Deity", "Temple");
	}
	
	public Deity(String name, String element, String nature, String worshipPlace) {
		this(name, name, element, nature, worshipPlace);
	}

	
	public Deity(String name, String displayName, String element, String nature, String worshipPlace) {
		this.name = name;
		this.displayName = displayName;
		this.domain = element;
		this.natureOfBeing = nature;
		this.placeOfWorship = worshipPlace;
	}
	
	public Deity setDisplayName(String dn) {
		displayName = dn;
		return this;
	}
	
	public String getDomain() {
		return domain;
	}
	public String getName() {
		return name;
	}
	public String getNatureOfBeing() {
		return natureOfBeing;
	}
	public String getPlaceOfWorship() {
		return placeOfWorship;
	}
	
	public Deity setDomain(String domain) {
		this.domain = domain;
		return this;
	}
	
	public Deity setNatureOfBeing(String natureOfBeing) {
		this.natureOfBeing = natureOfBeing;
		return this;
	}
	
	public Deity setPlaceOfWorship(String placeOfWorship) {
		this.placeOfWorship = placeOfWorship;
		return this;
	}
	
	public ITextComponent getDisplayName() {
		return new StringTextComponent(displayName);
	}
	
	public ITextComponent getDisplayName(String concatBefore, String concatAfter) {
		return new StringTextComponent(concatBefore + displayName + concatAfter);
	}
	
	public String getStringDisplayName() {
		return displayName;
	}
	
	@Override
	public void deserializeNBT(CompoundNBT nbt) {
		this.displayName = nbt.getString("Name");
		this.domain = nbt.getString("Domain");
		this.natureOfBeing = nbt.getString("Nature");
		this.placeOfWorship = nbt.getString("WorshipPlace");
	}
	
	@Override
	public CompoundNBT serializeNBT() {
		CompoundNBT nbt = new CompoundNBT();
		nbt.putString("Name", this.displayName);
		nbt.putString("Domain", domain);
		nbt.putString("Nature", natureOfBeing);
		nbt.putString("WorshipPlace", placeOfWorship);
		return nbt;
	}
}
