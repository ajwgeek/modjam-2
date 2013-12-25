package ironlionchefs.modjam.blocks.essence;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
public class BlockHighEssence extends Block
{
    public BlockHighEssence(int par1)
    {
        super(par1, Material.iron);
    }

    public int idDropped(int par1, Random par2Random, int par3)
    {
        return blockID;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("ModJam:BlockHighEssence");
		this.setUnlocalizedName("Potent Essence Block");
    }
}