package ironlionchefs.modjam.blocks.renderer;

import ironlionchefs.modjam.blocks.cauldron.PotionCauldron;
import ironlionchefs.modjam.blocks.cauldron.TileEntityCauldron;
import ironlionchefs.modjam.src.ModJam;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCauldron;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderPotionCauldron extends RenderBlocks implements ISimpleBlockRenderingHandler
{

	@Override
	public void renderInventoryBlock(Block par1Block, int par2, int par3, RenderBlocks renderer)
	{
		Tessellator tessellator = Tessellator.instance;
		boolean flag = false;
		 
        int j;
        float f1;
        float f2;
        float f3;
     
        if (this.useInventoryTint)
        {
            j = par1Block.getRenderColor(par2);

            if (flag)
            {
                j = 16777215;
            }

            f1 = (float)(j >> 16 & 255) / 255.0F;
            f2 = (float)(j >> 8 & 255) / 255.0F;
            f3 = (float)(j & 255) / 255.0F;
            GL11.glColor4f(f1 * par3, f2 * par3, f3 * par3, 1.0F);
        }

        j = par1Block.getRenderType();
        this.setRenderBoundsFromBlock(par1Block);
        int k;

        
        par1Block.setBlockBoundsForItemRender();
        renderer.setRenderBoundsFromBlock(par1Block);
        GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        Icon icon1 = PotionCauldron.func_94375_b("inner");
        //this.renderFaceYNeg(par1Block, 0.0D, 0.0D, 0.0D, this.getBlockIconFromSideAndMetadata(par1Block, 0, par2));
        this.renderFaceYNeg(par1Block, 0.0D, 0.0D, 0.0D, icon1);
        tessellator.draw();

        if (flag && this.useInventoryTint)
        {
            k = par1Block.getRenderColor(par2);
            f2 = (float)(k >> 16 & 255) / 255.0F;
            f3 = (float)(k >> 8 & 255) / 255.0F;
            float f7 = (float)(k & 255) / 255.0F;
            GL11.glColor4f(f2 * par3, f3 * par3, f7 * par3, 1.0F);
        }


        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        this.renderFaceYPos(par1Block, 0.0D, 0.0D, 0.0D, this.getBlockIconFromSideAndMetadata(par1Block, 1, par2));
        tessellator.draw();

        if (flag && this.useInventoryTint)
        {
            GL11.glColor4f(par3, par3, par3, 1.0F);
        }

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        this.renderFaceZNeg(par1Block, 0.0D, 0.0D, 0.0D, this.getBlockIconFromSideAndMetadata(par1Block, 2, par2));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        this.renderFaceZPos(par1Block, 0.0D, 0.0D, 0.0D, this.getBlockIconFromSideAndMetadata(par1Block, 3, par2));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        this.renderFaceXNeg(par1Block, 0.0D, 0.0D, 0.0D, this.getBlockIconFromSideAndMetadata(par1Block, 4, par2));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        this.renderFaceXPos(par1Block, 0.0D, 0.0D, 0.0D, this.getBlockIconFromSideAndMetadata(par1Block, 5, par2));
        tessellator.draw();

        

        
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess blockAccess, int x, int y, int z, Block par1BlockCauldron, int modelId, RenderBlocks renderer)
	{
		renderer.renderBlockCauldron((BlockCauldron) par1BlockCauldron, x, y, z);

		Tessellator tessellator = Tessellator.instance;

		PotionCauldron pc = (PotionCauldron) par1BlockCauldron;
		TileEntityCauldron c = (TileEntityCauldron) blockAccess.getBlockTileEntity(x, y, z);
		

		int l = c.readNBTData(x, y, z, "color");
		
		int i1 = c.readNBTData(x, y, z, "height");
	
		if (i1 > 3)
		{
			i1 = 3;
		}

		float f = (float) (l >> 16 & 255) / 255.0F;
		float f1 = (float) (l >> 8 & 255) / 255.0F;
		float f2 = (float) (l & 255) / 255.0F;

		float f9 = 1.0F;
		float f4 = 1.0F;

		if (i1 > 0)
		{
			Icon icon2 = pc.water;

			if (i1 > 3)
			{
				i1 = 3;
			}
			tessellator.setColorOpaque_F(f4 * f9 * f, f4 * f9 * f1, f4 * f9 * f2);

			renderer.renderFaceYPos(par1BlockCauldron, (double) x, (double) ((float) y - 1.0F + (6.0F + (float) i1 * 3.0F) / 16.0F), (double) z, icon2);
		}

		return true;
	}

	@Override
	public boolean shouldRender3DInInventory()
	{
		return true;
	}

	@Override
	public int getRenderId()
	{
		return ModJam.potionCauldronRenderID;
	}
}