package dev.xkmc.l2hostility.content.config;

import dev.xkmc.l2library.serial.config.BaseConfig;
import dev.xkmc.l2library.serial.config.CollectType;
import dev.xkmc.l2library.serial.config.ConfigCollect;
import dev.xkmc.l2serial.serialization.SerialClass;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.dimension.DimensionType;

import java.util.HashMap;

@SerialClass
public class WorldDifficultyConfig extends BaseConfig {

	@ConfigCollect(CollectType.MAP_OVERWRITE)
	@SerialClass.SerialField
	public final HashMap<ResourceLocation, DifficultyConfig> levelMap = new HashMap<>();

	@ConfigCollect(CollectType.MAP_OVERWRITE)
	@SerialClass.SerialField
	public final HashMap<ResourceLocation, DifficultyConfig> biomeMap = new HashMap<>();

	@ConfigCollect(CollectType.MAP_OVERWRITE)
	@SerialClass.SerialField
	public final HashMap<EntityType<?>, DifficultyConfig> entityMap = new HashMap<>();

	public record DifficultyConfig(int min, int base, double variation, double scale, double apply_chance,
								   double trait_chance) {

	}

	public WorldDifficultyConfig putDim(ResourceKey<DimensionType> key, int min, int base, double var, double scale) {
		levelMap.put(key.location(), new DifficultyConfig(min, base, var, scale, 1, 1));
		return this;
	}

	@SafeVarargs
	public final WorldDifficultyConfig putBiome(int min, int base, double var, double scale, ResourceKey<Biome>... keys) {
		for (var key : keys) {
			biomeMap.put(key.location(), new DifficultyConfig(min, base, var, scale, 1, 1));
		}
		return this;
	}

	public final WorldDifficultyConfig putEntity(int min, int base, double var, double scale, EntityType<?>... keys) {
		for (var key : keys) {
			entityMap.put(key, new DifficultyConfig(min, base, var, scale, 1, 1));
		}
		return this;
	}

}
