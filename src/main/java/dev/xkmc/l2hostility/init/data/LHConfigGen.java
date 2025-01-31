package dev.xkmc.l2hostility.init.data;

import dev.xkmc.l2hostility.content.config.WorldDifficultyConfig;
import dev.xkmc.l2hostility.init.L2Hostility;
import dev.xkmc.l2library.serial.config.ConfigDataProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LHConfigGen extends ConfigDataProvider {

	public static final List<Consumer<Collector>> LIST = new ArrayList<>();

	public LHConfigGen(DataGenerator generator) {
		super(generator, "L2Hostility Config");
	}

	@Override
	public void add(Collector collector) {
		LIST.forEach(e -> e.accept(collector));

		collector.add(L2Hostility.DIFFICULTY, new ResourceLocation(L2Hostility.MODID, "overworld"), new WorldDifficultyConfig()
				.putDim(BuiltinDimensionTypes.OVERWORLD, 0, 0, 4, 1)
				.putBiome(0, 10, 1, 0,
						Biomes.LUSH_CAVES,
						Biomes.FOREST, Biomes.FLOWER_FOREST, Biomes.BIRCH_FOREST,
						Biomes.JUNGLE, Biomes.BAMBOO_JUNGLE, Biomes.SPARSE_JUNGLE,
						Biomes.DESERT,
						Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU,
						Biomes.TAIGA, Biomes.SNOWY_TAIGA
				)
				.putBiome(0, 10, 1, 1,
						Biomes.DRIPSTONE_CAVES,
						Biomes.DARK_FOREST,
						Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_SAVANNA
				)
				.putBiome(0, 20, 1, 1,
						Biomes.BADLANDS, Biomes.ERODED_BADLANDS, Biomes.WOODED_BADLANDS,
						Biomes.DEEP_COLD_OCEAN, Biomes.DEEP_OCEAN, Biomes.DEEP_FROZEN_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN,
						Biomes.MUSHROOM_FIELDS,
						Biomes.STONY_SHORE,
						Biomes.SWAMP, Biomes.MANGROVE_SWAMP
				)
				.putBiome(0, 30, 1, 1,
						Biomes.SNOWY_SLOPES,
						Biomes.ICE_SPIKES,
						Biomes.FROZEN_PEAKS, Biomes.JAGGED_PEAKS, Biomes.STONY_PEAKS
				)
				.putBiome(0, 50, 4, 2, Biomes.DEEP_DARK)
		);

		collector.add(L2Hostility.DIFFICULTY, new ResourceLocation(L2Hostility.MODID, "nether"), new WorldDifficultyConfig()
				.putDim(BuiltinDimensionTypes.NETHER, 0, 20, 16, 2)
		);

		collector.add(L2Hostility.DIFFICULTY, new ResourceLocation(L2Hostility.MODID, "end"), new WorldDifficultyConfig()
				.putDim(BuiltinDimensionTypes.END, 0, 40, 16, 3)
		);

		collector.add(L2Hostility.DIFFICULTY, new ResourceLocation(L2Hostility.MODID, "mobs"), new WorldDifficultyConfig()
				.putEntity(0, 20, 1, 0, EntityType.ELDER_GUARDIAN, EntityType.PIGLIN_BRUTE)
				.putEntity(0, 50, 1, 0, EntityType.WITHER)
				.putEntity(100, 50, 1, 0, EntityType.ENDER_DRAGON)
		);

	}

}