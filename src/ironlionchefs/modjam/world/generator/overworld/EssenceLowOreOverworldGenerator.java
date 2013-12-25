package ironlionchefs.modjam.world.generator.overworld;

import ironlionchefs.modjam.src.ModJam;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class EssenceLowOreOverworldGenerator implements IWorldGenerator
{
	
	public void generateSurface(World world, Random random, int chunkX, int chunkZ)
	{
		for (int i = 0; i < 1; i ++)
		{
			int randPosX = chunkX + random.nextInt(16);
			int randPosY = random.nextInt(64);
			int randPosZ = chunkZ + random.nextInt(16);
			new WorldGenMinable(ModJam.essenceLowOreOverworld.blockID, 6).generate(world, random, randPosX, randPosY, randPosZ);
		}
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch (world.provider.dimensionId)
		{
			case 0:
				generateSurface(world, random, chunkZ * 16, chunkZ * 16);
				break;
		}
	}
}
