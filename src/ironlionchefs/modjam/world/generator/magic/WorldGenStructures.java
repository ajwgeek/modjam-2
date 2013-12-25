package ironlionchefs.modjam.world.generator.magic;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenStructures implements IWorldGenerator
{
	final int width = 30;
	final int height = 20;
	final int length = 30;
	
	WorldGenerator well = new StructureWell();
	WorldGenerator castle = new StructureCastle();
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
		int randomChanceWell = random.nextInt(512);
		int randomChanceCastle = random.nextInt(512);
		
		if (randomChanceWell == 1)
		{
			if (b.biomeName.equals("Magic"))
			{
				int randPosX = chunkX + random.nextInt(16);
				int randPosZ = chunkZ + random.nextInt(16);
				int randPosY = world.getHeightValue(randPosX, randPosZ);
				well.generate(world, random, randPosX, randPosY, randPosZ);
			}
		}
		
		if (randomChanceCastle == 1)
		{
			if (b.biomeName.equals("Magic"))
			{
				int randPosX = chunkX + random.nextInt(16);
				int randPosZ = chunkZ + random.nextInt(16);
				int randPosY = world.getHeightValue(randPosX, randPosZ);
				
				castle.generate(world, random, randPosX, randPosY, randPosZ);
			}
		}
	}
}
