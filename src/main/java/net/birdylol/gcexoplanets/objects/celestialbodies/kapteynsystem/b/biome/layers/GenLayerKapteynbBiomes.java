package net.birdylol.gcexoplanets.objects.celestialbodies.kapteynsystem.b.biome.layers;

import net.birdylol.gcexoplanets.GCExo;
import micdoodle8.mods.miccore.IntCache;
import net.birdylol.gcexoplanets.objects.celestialbodies.kapteynsystem.KapteynSystem;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;

public class GenLayerKapteynbBiomes extends GenLayer {
	private static final Biome[] biomes = new Biome[KapteynSystem.kapteynb.getBiomes().size()];

	public GenLayerKapteynbBiomes(long l, GenLayer parent) {
		super(l);		
		for(int i = 0; i < KapteynSystem.kapteynb.getBiomes().size(); i++)
			biomes[i] = KapteynSystem.kapteynb.getBiomes().get(i);
		
		this.parent = parent;
	}

	public GenLayerKapteynbBiomes(long l) {
		super(l);		
		for(int i = 0; i < KapteynSystem.kapteynb.getBiomes().size(); i++)
			biomes[i] = KapteynSystem.kapteynb.getBiomes().get(i);
	}

	@Override
	public int[] getInts(int x, int z, int width, int depth) {
		int[] dest = IntCache.getIntCache(width * depth);

		for (int k = 0; k < depth; ++k) {
			for (int i = 0; i < width; ++i) {
				initChunkSeed(x + i, z + k);
				dest[i + k * width] = Biome.getIdForBiome(biomes[nextInt(biomes.length)]);
			}
		}

		return dest;
	}
}
