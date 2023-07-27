package dev.xkmc.l2complements.content.modifiers.core;

import dev.xkmc.l2complements.content.config.ModifierConfig;
import dev.xkmc.l2complements.init.L2Hostility;
import dev.xkmc.l2complements.init.data.TagGen;
import dev.xkmc.l2complements.init.registrate.LHModifiers;
import dev.xkmc.l2damagetracker.contents.attack.AttackCache;
import dev.xkmc.l2damagetracker.contents.attack.CreateSourceEvent;
import dev.xkmc.l2library.base.NamedEntry;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class MobModifier extends NamedEntry<MobModifier> {

	public MobModifier() {
		super(LHModifiers.MODIFIERS);
	}

	@SuppressWarnings("ConstantConditions")
	public ModifierConfig getConfig() {
		ModifierConfig ans = L2Hostility.MODIFIER.getEntry(getRegistryName());
		if (ans == null) return ModifierConfig.DEFAULT;
		return ans;
	}

	public int getCost() {
		return getConfig().cost;
	}

	public int getMaxLevel() {
		return getConfig().maxLevel;
	}

	public boolean allow(LivingEntity le, int difficulty) {
		ModifierConfig config = getConfig();
		if (difficulty < config.cost) return false;
		if (config.blacklist.contains(le.getType())) return false;
		if (!config.whitelist.isEmpty() && !config.whitelist.contains(le.getType())) return false;
		return le.getRandom().nextDouble() < config.chance;
	}

	public void initialize(LivingEntity le, int level) {
	}

	public void tick(LivingEntity mob, int level) {
	}

	public void onHurtTarget(int level, LivingEntity attacker, AttackCache cache) {
	}

	public void onHurtByOthers(int level, LivingEntity entity, LivingHurtEvent event) {
	}

	public void onCreateSource(int level, LivingEntity attacker, CreateSourceEvent event) {
	}

}
