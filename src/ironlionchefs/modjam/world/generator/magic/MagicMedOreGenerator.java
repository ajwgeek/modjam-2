package ironlionchefs.modjam.world.generator.magic;

import ironlionchefs.modjam.src.ModJam;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class MagicMedOreGenerator implements IWorldGenerator
{
	
	public void generateSurface(World world, Random random, int chunkX, int chunkZ)
	{
		for (int i = 0; i < 8; i ++)
		{
			int randPosX = chunkX + random.nextInt(16);
			int randPosY = random.nextInt(64);
			int randPosZ = chunkZ + random.nextInt(16);
			new WorldGenMinable(ModJam.essenceMedOreOverworld.blockID, 8).generate(world, random, randPosX, randPosY, randPosZ);
		}
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
		if (b.biomeName.equals("Magic"))
		{
			generateSurface(world, random, chunkZ * 16, chunkZ * 16);
		}
	}
}
