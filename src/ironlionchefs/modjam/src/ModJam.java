package ironlionchefs.modjam.src;

import ironlionchefs.modjam.blocks.cauldron.PotionCauldron;
import ironlionchefs.modjam.blocks.cauldron.TileEntityCauldron;
import ironlionchefs.modjam.blocks.essence.BlockHighEssence;
import ironlionchefs.modjam.blocks.essence.BlockLowEssence;
import ironlionchefs.modjam.blocks.essence.BlockMedEssence;
import ironlionchefs.modjam.blocks.magic.BlockLeavesMagic;
import ironlionchefs.modjam.blocks.magic.BlockNewGrass;
import ironlionchefs.modjam.blocks.ore.OreEssenceHighOverworld;
import ironlionchefs.modjam.blocks.ore.OreEssenceLowOverworld;
import ironlionchefs.modjam.blocks.ore.OreEssenceMedOverworld;
import ironlionchefs.modjam.blocks.renderer.RenderPotionCauldron;
import ironlionchefs.modjam.items.essence.armor.high.HighEssenceBoots;
import ironlionchefs.modjam.items.essence.armor.high.HighEssenceChest;
import ironlionchefs.modjam.items.essence.armor.high.HighEssenceHelmet;
import ironlionchefs.modjam.items.essence.armor.high.HighEssenceLegs;
import ironlionchefs.modjam.items.essence.armor.low.LowEssenceBoots;
import ironlionchefs.modjam.items.essence.armor.low.LowEssenceChest;
import ironlionchefs.modjam.items.essence.armor.low.LowEssenceHelmet;
import ironlionchefs.modjam.items.essence.armor.low.LowEssenceLegs;
import ironlionchefs.modjam.items.essence.armor.med.MedEssenceBoots;
import ironlionchefs.modjam.items.essence.armor.med.MedEssenceChest;
import ironlionchefs.modjam.items.essence.armor.med.MedEssenceHelmet;
import ironlionchefs.modjam.items.essence.armor.med.MedEssenceLegs;
import ironlionchefs.modjam.items.essence.dust.ItemEssenceHigh;
import ironlionchefs.modjam.items.essence.dust.ItemEssenceLow;
import ironlionchefs.modjam.items.essence.dust.ItemEssenceMed;
import ironlionchefs.modjam.items.essence.ingot.ItemEssenceHighIngot;
import ironlionchefs.modjam.items.essence.ingot.ItemEssenceLowIngot;
import ironlionchefs.modjam.items.essence.ingot.ItemEssenceMedIngot;
import ironlionchefs.modjam.items.essence.tools.high.HighEssenceAxe;
import ironlionchefs.modjam.items.essence.tools.high.HighEssenceHoe;
import ironlionchefs.modjam.items.essence.tools.high.HighEssencePickaxe;
import ironlionchefs.modjam.items.essence.tools.high.HighEssenceShovel;
import ironlionchefs.modjam.items.essence.tools.high.HighEssenceSword;
import ironlionchefs.modjam.items.essence.tools.low.LowEssencePickaxe;
import ironlionchefs.modjam.items.essence.tools.low.LowEssenceAxe;
import ironlionchefs.modjam.items.essence.tools.low.LowEssenceHoe;
import ironlionchefs.modjam.items.essence.tools.low.LowEssenceShovel;
import ironlionchefs.modjam.items.essence.tools.low.LowEssenceSword;
import ironlionchefs.modjam.items.essence.tools.med.MedEssenceAxe;
import ironlionchefs.modjam.items.essence.tools.med.MedEssenceHoe;
import ironlionchefs.modjam.items.essence.tools.med.MedEssencePickaxe;
import ironlionchefs.modjam.items.essence.tools.med.MedEssenceShovel;
import ironlionchefs.modjam.items.essence.tools.med.MedEssenceSword;
import ironlionchefs.modjam.items.pendants.ItemPendantDiamond;
import ironlionchefs.modjam.items.pendants.ItemPendantGold;
import ironlionchefs.modjam.items.pendants.ItemPendantIron;
import ironlionchefs.modjam.items.pendants.ItemPendantStone;
import ironlionchefs.modjam.items.pendants.enchants.PendantEnchantRegistry;
import ironlionchefs.modjam.items.pendants.parts.ItemPendantPieceDiamond;
import ironlionchefs.modjam.items.pendants.parts.ItemPendantPieceGold;
import ironlionchefs.modjam.items.pendants.parts.ItemPendantPieceIron;
import ironlionchefs.modjam.items.pendants.parts.ItemPendantPieceStone;
import ironlionchefs.modjam.items.potion.ItemPotionMixed;
import ironlionchefs.modjam.world.generator.magic.BiomeMagic;
import ironlionchefs.modjam.world.generator.magic.MagicHighOreGenerator;
import ironlionchefs.modjam.world.generator.magic.MagicLowOreGenerator;
import ironlionchefs.modjam.world.generator.magic.MagicMedOreGenerator;
import ironlionchefs.modjam.world.generator.magic.WorldGenStructures;
import ironlionchefs.modjam.world.generator.overworld.EssenceHighOreOverworldGenerator;
import ironlionchefs.modjam.world.generator.overworld.EssenceLowOreOverworldGenerator;
import ironlionchefs.modjam.world.generator.overworld.EssenceMedOreOverworldGenerator;
import ironlionchefs.modjam.world.provider.magic.WorldProviderMagicWorld;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.src.ModLoader;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "ModJamILC", name = "ModJam IronLionChefs", version = "1.0.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class ModJam
{
	//Pendants
	public static Item stonePendant = new ItemPendantStone(3072);
	public static Item ironPendant = new ItemPendantIron(3073);
	public static Item goldPendant = new ItemPendantGold(3074);
	public static Item diamondPendant = new ItemPendantDiamond(3075);
	
	public static Item itemPendantPieceStone = new ItemPendantPieceStone(3110);
	public static Item itemPendantPieceIron = new ItemPendantPieceIron(3111);
	public static Item itemPendantPieceGold = new ItemPendantPieceGold(3112);
	public static Item itemPendantPieceDiamond = new ItemPendantPieceDiamond(3113);
	
	//Essence dust
	public static Item essenceLow = new ItemEssenceLow(3076);
	public static Item essenceMed = new ItemEssenceMed(3077);
	public static Item essenceHigh = new ItemEssenceHigh(3078);
	
	//Essence ingots
	public static Item essenceLowIngot = new ItemEssenceLowIngot(3079);
	public static Item essenceMedIngot = new ItemEssenceMedIngot(3080);
	public static Item essenceHighIngot = new ItemEssenceHighIngot(3081);
	
	//Low essence armor
	public static Item lowEssenceBoots = new LowEssenceBoots(3082);
	public static Item lowEssenceChest = new LowEssenceChest(3083);
	public static Item lowEssenceHelmet = new LowEssenceHelmet(3084);
	public static Item lowEssenceLegs = new LowEssenceLegs (3085);
	
	//low essence tools
	public static Item lowEssenceHoe = new LowEssenceHoe(3086);
	public static Item lowEssenceShovel = new LowEssenceShovel(3087);
	public static Item lowEssenceSword = new LowEssenceSword(3088);
	public static Item lowEssenceAxe = new LowEssenceAxe(3089);
	public static Item essenceLowPickaxe = new LowEssencePickaxe(3090);


	//High essence armor
	public static Item highEssenceBoots = new HighEssenceBoots(3091);
	public static Item highEssenceChest = new HighEssenceChest(3092);
	public static Item highEssenceHelmet = new HighEssenceHelmet(3093);
	public static Item highEssenceLegs = new HighEssenceLegs(3094);
	
	//High essence tools
	public static Item highEssenceHoe = new HighEssenceHoe(3095);
	public static Item highEssencePickaxe = new HighEssencePickaxe(3096);
	public static Item highEssenceShovel = new HighEssenceShovel(3097);
	public static Item highEssenceSword = new HighEssenceSword(3098);
	public static Item highEssenceAxe = new HighEssenceAxe(3099);
	
	//Med Essence tools
	public static Item medEssenceAxe = new MedEssenceAxe(3100);
	public static Item medEssenceHoe = new MedEssenceHoe(3105);
	public static Item medEssencePickaxe = new MedEssencePickaxe(3107);
	public static Item medEssenceShovel = new MedEssenceShovel(3108); 
	public static Item medEssenceSword = new MedEssenceSword(3109);
	
	//Med Essence armor
	public static Item medEssenceBoots = new MedEssenceBoots(3101);
	public static Item medEssenceHelmet = new MedEssenceHelmet(3102);
	public static Item medEssenceChest = new MedEssenceChest(3104);
	public static Item medEssenceLegs = new MedEssenceLegs(3106);
	
	//Custom Potions
	public static Item mixedPotionItem = new ItemPotionMixed(3103, 0, false);
	
	//Blocks
	public static Block potionCauldron = new PotionCauldron(4072);
	public static Block essenceLowOreOverworld = new OreEssenceLowOverworld(4073);
	public static Block essenceMedOreOverworld = new OreEssenceMedOverworld(4074);
	public static Block essenceHighOreOverworld = new OreEssenceHighOverworld(4075);
	
	public static Block blockNewDimGrass = new BlockNewGrass(255);
	public static Block lowEssenceBlock = new BlockLowEssence(4078);
	public static Block medEssenceBlock = new BlockMedEssence(4079);
	public static Block highEssenceBlock = new BlockHighEssence(4080);
	
	public static Block magicLeaves = new BlockLeavesMagic(4081);
	//Render IDs
	public static int potionCauldronRenderID = RenderingRegistry.getNextAvailableRenderId();
	int count = 0;

	public final static int magicDimID = 45;
	public static final BiomeGenBase baseMagicWorldBiome = new BiomeMagic(25);
	
	public CreativeTabs tabModJamGeneral = new CreativeTabs("ModJam")
	{
		public ItemStack getIconItemStack()
		{
			return new ItemStack(ModJam.essenceMedIngot, 1, 0);
		}
	};
	
	public CreativeTabs tabModJamArmor = new CreativeTabs("ModJam")
	{
		public ItemStack getIconItemStack()
		{
			return new ItemStack(ModJam.medEssenceChest, 1, 0);
		}
	};
	
	public CreativeTabs tabModJamTools = new CreativeTabs("ModJam")
	{
		public ItemStack getIconItemStack()
		{
			return new ItemStack(ModJam.medEssenceAxe, 1, 0);
		}
	};

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{

	}

	public void registerOre(Block b, IWorldGenerator i, String name, CreativeTabs ct)
	{
		registerObject(b, ct, name);
		GameRegistry.registerWorldGenerator(i);
		b.setCreativeTab(ct);
	}

	public void registerObject(Object obj, CreativeTabs ct, String name)
	{
		count++;
		if (obj instanceof Block)
		{
			GameRegistry.registerBlock((Block) obj, name);
			LanguageRegistry.addName((Block) obj, name);
			Block b = (Block) obj;
			b.setCreativeTab(ct);
		}
		else if (obj instanceof Item)
		{
			Item a = (Item) obj;
			GameRegistry.registerItem(a, name);
			LanguageRegistry.addName(a, name);
			a.setCreativeTab(ct);
		}
	}

	public void registerStonePendantEnchants()
	{
		PendantEnchantRegistry.stonePendantEnchants.add((new PotionEffect(Potion.moveSpeed.getId(), 0, 1)));
		PendantEnchantRegistry.stonePendantEnchants.add((new PotionEffect(Potion.jump.getId(), 0, 1)));

		PendantEnchantRegistry.stonePendantEnchants.add((new PotionEffect(Potion.weakness.getId(), 0, 1)));
	}

	public void registerIronPendantEnchants()
	{
		PendantEnchantRegistry.ironPendantEnchants.add(new PotionEffect(Potion.blindness.getId(), 0, 1));

		PendantEnchantRegistry.ironPendantEnchants.add(new PotionEffect(Potion.damageBoost.getId(), 0, 1));
		PendantEnchantRegistry.ironPendantEnchants.add(new PotionEffect(Potion.fireResistance.getId(), 0, 1));
		PendantEnchantRegistry.ironPendantEnchants.add(new PotionEffect(Potion.moveSpeed.getId(), 0, 1));
	}

	public void registerGoldPendantEnchants()
	{
		PendantEnchantRegistry.goldPendantEnchants.add(new PotionEffect(Potion.confusion.getId(), 0, 2));
		PendantEnchantRegistry.goldPendantEnchants.add(new PotionEffect(Potion.digSlowdown.getId(), 0, 2));

		PendantEnchantRegistry.goldPendantEnchants.add(new PotionEffect(Potion.digSpeed.getId(), 0, 2));
		PendantEnchantRegistry.goldPendantEnchants.add(new PotionEffect(Potion.heal.getId(), 0, 2));
		PendantEnchantRegistry.goldPendantEnchants.add(new PotionEffect(Potion.nightVision.getId(), 0, 2));
	}

	public void registerDiamondPendantEnchants()
	{
		PendantEnchantRegistry.diamondPendantEnchants.add(new PotionEffect(Potion.digSpeed.getId(), 0, 3));
		PendantEnchantRegistry.diamondPendantEnchants.add(new PotionEffect(Potion.heal.getId(), 0, 3));
		PendantEnchantRegistry.diamondPendantEnchants.add(new PotionEffect(Potion.nightVision.getId(), 0, 3));
		PendantEnchantRegistry.diamondPendantEnchants.add(new PotionEffect(Potion.damageBoost.getId(), 0, 3));
		PendantEnchantRegistry.diamondPendantEnchants.add(new PotionEffect(Potion.fireResistance.getId(), 0, 3));
		PendantEnchantRegistry.diamondPendantEnchants.add(new PotionEffect(Potion.invisibility.getId(), 0, 3));
		PendantEnchantRegistry.diamondPendantEnchants.add(new PotionEffect(Potion.jump.getId(), 0, 3));
		PendantEnchantRegistry.diamondPendantEnchants.add(new PotionEffect(Potion.moveSpeed.getId(), 0, 3));
		PendantEnchantRegistry.diamondPendantEnchants.add(new PotionEffect(Potion.resistance.getId(), 0, 3));
		PendantEnchantRegistry.diamondPendantEnchants.add(new PotionEffect(Potion.waterBreathing.getId(), 0, 3));
		PendantEnchantRegistry.diamondPendantEnchants.add(new PotionEffect(Potion.regeneration.getId(), 0, 3));
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		// Creative Tabs
		LanguageRegistry.instance().addStringLocalization("itemGroup.ModJam", "en_US", "ModJam: Iron Lion Chefs");
		RenderingRegistry.registerBlockHandler(potionCauldronRenderID, new RenderPotionCauldron());

		registerStonePendantEnchants();
		registerIronPendantEnchants();
		registerGoldPendantEnchants();
		registerDiamondPendantEnchants();

		// Ores Overworld
		registerOre(essenceLowOreOverworld, new EssenceLowOreOverworldGenerator(), "Weak Essence Ore", this.tabModJamGeneral);
		registerOre(essenceMedOreOverworld, new EssenceMedOreOverworldGenerator(), "Normal Essence Ore", this.tabModJamGeneral);
		registerOre(essenceHighOreOverworld, new EssenceHighOreOverworldGenerator(), "Potent Essence Ore", this.tabModJamGeneral);

		ModLoader.addSmelting(essenceLow.itemID, new ItemStack(essenceLowIngot));
		ModLoader.addSmelting(essenceMed.itemID, new ItemStack(essenceMedIngot));
		ModLoader.addSmelting(essenceHigh.itemID, new ItemStack(essenceHighIngot));

		ModLoader.addRecipe(new ItemStack(potionCauldron, 1), new Object[] { "XXX", "IYI", "DDD", 'D', essenceHigh, 'I', essenceMed, 'Y', Item.cauldron, 'X', essenceLow});
		
		ModLoader.addRecipe(new ItemStack(highEssenceBoots, 1), new Object[] { "   ", "X X", "X X", 'X', essenceHighIngot});
		ModLoader.addRecipe(new ItemStack(highEssenceChest, 1), new Object[] { "X X", "XXX", "XXX", 'X', essenceHighIngot});
		ModLoader.addRecipe(new ItemStack(highEssenceHelmet, 1), new Object[] { "XXX", "X X", "   ", 'X', essenceHighIngot});
		ModLoader.addRecipe(new ItemStack(highEssenceLegs, 1), new Object[] { "XXX", "X X", "X X", 'X', essenceHighIngot});
		
		ModLoader.addRecipe(new ItemStack(lowEssenceBoots, 1), new Object[] { "   ", "X X", "X X", 'X', essenceLowIngot});
		ModLoader.addRecipe(new ItemStack(lowEssenceChest, 1), new Object[] { "X X", "XXX", "XXX", 'X', essenceLowIngot});
		ModLoader.addRecipe(new ItemStack(lowEssenceHelmet, 1), new Object[] { "XXX", "X X", "   ", 'X', essenceLowIngot});
		ModLoader.addRecipe(new ItemStack(lowEssenceLegs, 1), new Object[] { "XXX", "X X", "X X", 'X', essenceLowIngot});
		
		ModLoader.addRecipe(new ItemStack(medEssenceBoots, 1), new Object[] { "   ", "X X", "X X", 'X', essenceMedIngot});
		ModLoader.addRecipe(new ItemStack(medEssenceChest, 1), new Object[] { "X X", "XXX", "XXX", 'X', essenceMedIngot});
		ModLoader.addRecipe(new ItemStack(medEssenceHelmet, 1), new Object[] { "XXX", "X X", "   ", 'X', essenceMedIngot});
		ModLoader.addRecipe(new ItemStack(medEssenceLegs, 1), new Object[] { "XXX", "X X", "X X", 'X', essenceMedIngot});
		
		ModLoader.addRecipe(new ItemStack(highEssenceAxe, 1), new Object[] { " XX", " IX", " I ", 'X', essenceHighIngot, 'I', Item.stick});
		ModLoader.addRecipe(new ItemStack(highEssenceHoe, 1), new Object[] { " XX", " I ", " I ", 'X', essenceHighIngot, 'I', Item.stick});
		ModLoader.addRecipe(new ItemStack(highEssencePickaxe, 1), new Object[] { "XXX", " I ", " I ", 'X', essenceHighIngot, 'I', Item.stick});
		ModLoader.addRecipe(new ItemStack(highEssenceShovel, 1), new Object[] { " X ", " I ", " I ", 'X', essenceHighIngot, 'I', Item.stick});
		ModLoader.addRecipe(new ItemStack(highEssenceSword, 1), new Object[] { " X ", " X ", " I ", 'X', essenceHighIngot, 'I', Item.stick});
		
		ModLoader.addRecipe(new ItemStack(medEssenceAxe, 1), new Object[] { " XX", " IX", " I ", 'X', essenceMedIngot, 'I', Item.stick});
		ModLoader.addRecipe(new ItemStack(medEssenceHoe, 1), new Object[] { " XX", " I ", " I ", 'X', essenceMedIngot, 'I', Item.stick});
		ModLoader.addRecipe(new ItemStack(medEssencePickaxe, 1), new Object[] { "XXX", " I ", " I ", 'X', essenceMedIngot, 'I', Item.stick});
		ModLoader.addRecipe(new ItemStack(medEssenceShovel, 1), new Object[] { " X ", " I ", " I ", 'X', essenceMedIngot, 'I', Item.stick});
		ModLoader.addRecipe(new ItemStack(medEssenceSword, 1), new Object[] { " X ", " X ", " I ", 'X', essenceMedIngot, 'I', Item.stick});
		
		ModLoader.addRecipe(new ItemStack(lowEssenceAxe, 1), new Object[] { " XX", " IX", " I ", 'X', essenceLowIngot, 'I', Item.stick});
		ModLoader.addRecipe(new ItemStack(lowEssenceHoe, 1), new Object[] { " XX", " I ", " I ", 'X', essenceLowIngot, 'I', Item.stick});
		ModLoader.addRecipe(new ItemStack(essenceLowPickaxe, 1), new Object[] { "XXX", " I ", " I ", 'X', essenceLowIngot, 'I', Item.stick});
		ModLoader.addRecipe(new ItemStack(lowEssenceShovel, 1), new Object[] { " X ", " I ", " I ", 'X', essenceLowIngot, 'I', Item.stick});
		ModLoader.addRecipe(new ItemStack(lowEssenceSword, 1), new Object[] { " X ", " X ", " I ", 'X', essenceLowIngot, 'I', Item.stick});
		
		ModLoader.addRecipe(new ItemStack(stonePendant, 1), new Object[] { "X X", " X ", " D ", 'D', itemPendantPieceStone, 'X', Item.silk});
		ModLoader.addRecipe(new ItemStack(ironPendant, 1), new Object[] { "X X", " X ", " D ", 'D', itemPendantPieceIron, 'X', Item.silk});
		ModLoader.addRecipe(new ItemStack(goldPendant, 1), new Object[] { "X X", " X ", " D ", 'D', itemPendantPieceGold, 'X', Item.silk});
		ModLoader.addRecipe(new ItemStack(diamondPendant, 1), new Object[] { "X X", " X ", " D ", 'D', itemPendantPieceDiamond, 'X', Item.silk});
		
		ModLoader.addRecipe(new ItemStack(itemPendantPieceStone, 1), new Object[] { "XXX", "XYX", "XXX", 'Y', Block.stone, 'X', essenceLow});
		ModLoader.addRecipe(new ItemStack(itemPendantPieceIron, 1), new Object[] { "XXX", "XYX", "XXX", 'Y', Item.ingotIron, 'X', essenceMed});
		ModLoader.addRecipe(new ItemStack(itemPendantPieceGold, 1), new Object[] { "XXX", "XYX", "XXX", 'Y', Item.ingotGold, 'X', essenceMed});
		ModLoader.addRecipe(new ItemStack(itemPendantPieceDiamond, 1), new Object[] { "XXX", "XYX", "XXX", 'Y', Item.diamond, 'X', essenceHigh});


		

		
		ModLoader.addRecipe(new ItemStack(highEssenceAxe, 1), new Object[] { " XX", " IX", " I ", 'X', essenceHighIngot, 'I', Item.stick});
		

		// Blocks
		registerObject(potionCauldron, this.tabModJamGeneral, "Potion Cauldron");

		// Items
		registerObject(stonePendant, this.tabModJamArmor, "Stone Pendant");
		registerObject(ironPendant, this.tabModJamArmor, "Iron Pendant");
		registerObject(goldPendant, this.tabModJamArmor, "Gold Pendant");
		registerObject(diamondPendant, this.tabModJamArmor, "Diamond Pendant");
		
		registerObject(essenceLow, this.tabModJamGeneral, "Weak Essence Dust");
		registerObject(essenceMed, this.tabModJamGeneral, "Normal Dust");
		registerObject(essenceHigh, this.tabModJamGeneral, "Potent Essence Dust");
		
		registerObject(essenceLowIngot, this.tabModJamGeneral, "Weak Essence Ingot");
		registerObject(essenceMedIngot, this.tabModJamGeneral, "Normal Essence Ingot");
		registerObject(essenceHighIngot, this.tabModJamGeneral, "Potent Essence Ingot");
		
		registerObject(highEssencePickaxe, this.tabModJamTools, "Potent Essence Pickaxe");
		registerObject(highEssenceShovel, this.tabModJamTools, "Potent Essence Shovel");
		registerObject(highEssenceAxe, this.tabModJamTools, "Potent Essence Axe");
		registerObject(highEssenceHoe, this.tabModJamTools, "Potent Essence Hoe");
		registerObject(highEssenceSword, this.tabModJamTools, "Potent Essence Sword");
		
		
		registerObject(highEssenceBoots, this.tabModJamArmor, "Potent Essence Boots");
		registerObject(highEssenceChest, this.tabModJamArmor, "Potent Essence Chestplate");
		registerObject(highEssenceHelmet, this.tabModJamArmor, "Potent Essence Helmet");
		registerObject(highEssenceLegs, this.tabModJamArmor, "Potent Essence Leggings");
		
		
		registerObject(lowEssenceAxe, this.tabModJamTools, "Weak Essence Axe");
		registerObject(lowEssenceBoots, this.tabModJamArmor, "Weak Essence Boots");
		registerObject(lowEssenceChest, this.tabModJamArmor, "Weak Essence Chestplate");
		registerObject(lowEssenceHelmet, this.tabModJamArmor, "Weak Essence Helmet");
		registerObject(lowEssenceHoe, this.tabModJamTools, "Weak Essence Hoe");
		registerObject(lowEssenceLegs, this.tabModJamArmor, "Weak Essence Legs");
		registerObject(essenceLowPickaxe, this.tabModJamTools, "Weak Essence Pickaxe");
		registerObject(lowEssenceShovel, this.tabModJamTools, "Weak Essence Shovel");
		registerObject(lowEssenceSword, this.tabModJamTools, "Weak Essence Sword");
		
		
		registerObject(medEssenceAxe, this.tabModJamTools, "Normal Essence Axe");
		registerObject(medEssenceBoots, this.tabModJamArmor, "Normal Essence Boots");
		registerObject(medEssenceChest, this.tabModJamArmor, "Normal Essence Chest");
		registerObject(medEssenceHoe, this.tabModJamTools, "Normal Essence Hoe");
		

		registerObject(mixedPotionItem, this.tabModJamGeneral, "Mixed Potion");
		
		
		registerObject(medEssenceHelmet, this.tabModJamArmor, "Normal Essence Helmet");
		registerObject(medEssenceLegs, this.tabModJamArmor, "Normal Essence Leggings");
		registerObject(medEssencePickaxe, this.tabModJamTools, "Normal Essence Pickaxe");
		registerObject(medEssenceShovel, this.tabModJamTools, "Normal Essence Shovel");
		registerObject(medEssenceSword, this.tabModJamTools, "Normal Essence Sword");
		
		registerObject(itemPendantPieceStone, this.tabModJamGeneral, "Stone Pendant Part");
		registerObject(itemPendantPieceIron, this.tabModJamGeneral, "Iron Pendant Part");
		registerObject(itemPendantPieceGold, this.tabModJamGeneral, "Gold Pendant Part");
		registerObject(itemPendantPieceDiamond, this.tabModJamGeneral, "Diamond Pendant Part");
		
		registerObject(lowEssenceBlock, this.tabModJamGeneral, "Weak Essence Block");
		registerObject(medEssenceBlock, this.tabModJamGeneral, "Normal Essence Block");
		registerObject(highEssenceBlock, this.tabModJamGeneral, "High Essence Block");
		
		registerObject(blockNewDimGrass, this.tabModJamGeneral, "Grass");
		registerObject(magicLeaves, this.tabModJamGeneral, "Leaves");
		
		GameRegistry.registerTileEntity(TileEntityCauldron.class, "TileEntityCauldron");
		
		DimensionManager.registerProviderType(ModJam.magicDimID, WorldProviderMagicWorld.class, true);
		DimensionManager.registerDimension(ModJam.magicDimID, ModJam.magicDimID);
		GameRegistry.registerWorldGenerator(new WorldGenStructures());
		GameRegistry.registerWorldGenerator(new MagicHighOreGenerator());
		GameRegistry.registerWorldGenerator(new MagicMedOreGenerator());
		GameRegistry.registerWorldGenerator(new MagicLowOreGenerator());
		
		System.out.println("Registered " + count + " items!");
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{

	}
}