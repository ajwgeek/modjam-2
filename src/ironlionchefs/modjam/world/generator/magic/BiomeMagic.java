package ironlionchefs.modjam.world.generator.magic;

import java.util.Random;
import java.util.Random;

import ironlionchefs.modjam.src.ModJam;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
public class BiomeMagic extends BiomeGenBase
{
	public final Material blockMaterial;
	public final WorldGenMagicTree worldGenTree = new WorldGenMagicTree(true);
		
	public BiomeMagic(int par1)
	{
		super(par1);
		this.blockMaterial = Material.water;
		this.minHeight = 0.1F;
		this.maxHeight = 0.6F;
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();

		this.spawnableMonsterList.add(new SpawnListEntry(EntitySpider.class, 10, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntitySkeleton.class, 10, 4, 4));

		this.topBlock = ((byte) ModJam.blockNewDimGrass.blockID);
		this.fillerBlock = ((byte) Block.dirt.blockID);
		this.setBiomeName("Magic");
		this.waterColorMultiplier = 0xE42D17;
		this.theBiomeDecorator.treesPerChunk = 3;
	}

	@Override
	public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
	{
		return (WorldGenerator) this.worldGenTree;
	}
}