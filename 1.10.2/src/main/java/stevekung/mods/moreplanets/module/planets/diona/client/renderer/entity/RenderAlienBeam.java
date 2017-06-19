package stevekung.mods.moreplanets.module.planets.diona.client.renderer.entity;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.module.planets.diona.entity.EntityAlienBeam;

@SideOnly(Side.CLIENT)
public class RenderAlienBeam extends Render<EntityAlienBeam>
{
    public RenderAlienBeam(RenderManager manager)
    {
        super(manager);
    }

    @Override
    public void doRender(EntityAlienBeam entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        int k = 512;
        GlStateManager.alphaFunc(516, 0.1F);
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        GlStateManager.disableFog();
        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("textures/entity/beacon_beam.png"));
        GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, 10497.0F);
        GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, 10497.0F);
        GlStateManager.disableBlend();
        GlStateManager.depthMask(true);
        GlStateManager.blendFunc(770, 1);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);
        double d0 = (double)Minecraft.getMinecraft().theWorld.getTotalWorldTime() + (double)partialTicks;
        double d1 = MathHelper.func_181162_h(-d0 * 0.2D - MathHelper.floor_double(-d0 * 0.1D));
        float red = 0.4F;
        float green = 0.6F;
        float blue = 1.0F;
        double d2 = d0 * 0.025D * -1.5D;
        double d4 = 0.5D + Math.cos(d2 + 2.356194490192345D) * 0.2D;
        double d5 = 0.5D + Math.sin(d2 + 2.356194490192345D) * 0.2D;
        double d6 = 0.5D + Math.cos(d2 + Math.PI / 4D) * 0.2D;
        double d7 = 0.5D + Math.sin(d2 + Math.PI / 4D) * 0.2D;
        double d8 = 0.5D + Math.cos(d2 + 3.9269908169872414D) * 0.2D;
        double d9 = 0.5D + Math.sin(d2 + 3.9269908169872414D) * 0.2D;
        double d10 = 0.5D + Math.cos(d2 + 5.497787143782138D) * 0.2D;
        double d11 = 0.5D + Math.sin(d2 + 5.497787143782138D) * 0.2D;
        double d12 = 0.0D;
        double d13 = 1.0D;
        double d14 = -1.0D + d1;
        double d15 = (float)512 * 512 * 2.5D + d14;
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        worldrenderer.pos(x + d4, y + k, z + d5).tex(1.0D, d15).color(red, green, blue, 1.0F).endVertex();
        worldrenderer.pos(x + d4, y, z + d5).tex(1.0D, d14).color(red, green, blue, 1.0F).endVertex();
        worldrenderer.pos(x + d6, y, z + d7).tex(0.0D, d14).color(red, green, blue, 1.0F).endVertex();
        worldrenderer.pos(x + d6, y + k, z + d7).tex(0.0D, d15).color(red, green, blue, 1.0F).endVertex();
        worldrenderer.pos(x + d10, y + k, z + d11).tex(1.0D, d15).color(red, green, blue, 1.0F).endVertex();
        worldrenderer.pos(x + d10, y, z + d11).tex(1.0D, d14).color(red, green, blue, 1.0F).endVertex();
        worldrenderer.pos(x + d8, y, z + d9).tex(0.0D, d14).color(red, green, blue, 1.0F).endVertex();
        worldrenderer.pos(x + d8, y + k, z + d9).tex(0.0D, d15).color(red, green, blue, 1.0F).endVertex();
        worldrenderer.pos(x + d6, y + k, z + d7).tex(1.0D, d15).color(red, green, blue, 1.0F).endVertex();
        worldrenderer.pos(x + d6, y, z + d7).tex(1.0D, d14).color(red, green, blue, 1.0F).endVertex();
        worldrenderer.pos(x + d10, y, z + d11).tex(0.0D, d14).color(red, green, blue, 1.0F).endVertex();
        worldrenderer.pos(x + d10, y + k, z + d11).tex(0.0D, d15).color(red, green, blue, 1.0F).endVertex();
        worldrenderer.pos(x + d8, y + k, z + d9).tex(1.0D, d15).color(red, green, blue, 1.0F).endVertex();
        worldrenderer.pos(x + d8, y, z + d9).tex(1.0D, d14).color(red, green, blue, 1.0F).endVertex();
        worldrenderer.pos(x + d4, y, z + d5).tex(0.0D, d14).color(red, green, blue, 1.0F).endVertex();
        worldrenderer.pos(x + d4, y + k, z + d5).tex(0.0D, d15).color(red, green, blue, 1.0F).endVertex();
        tessellator.draw();
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.depthMask(false);
        d2 = 0.2D;
        d4 = 0.8D;
        d5 = 0.2D;
        d6 = 0.2D;
        d7 = 0.8D;
        d8 = 0.8D;
        d9 = 0.8D;
        d10 = 0.0D;
        d11 = 1.0D;
        d12 = -1.0D + d1;
        d13 = (float)512 * 512 + d12;
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        worldrenderer.pos(x + 0.2D, y + k, z + 0.2D).tex(1.0D, d13).color(red, green, blue, 0.125F).endVertex();
        worldrenderer.pos(x + 0.2D, y, z + 0.2D).tex(1.0D, d12).color(red, green, blue, 0.125F).endVertex();
        worldrenderer.pos(x + 0.8D, y, z + 0.2D).tex(0.0D, d12).color(red, green, blue, 0.125F).endVertex();
        worldrenderer.pos(x + 0.8D, y + k, z + 0.2D).tex(0.0D, d13).color(red, green, blue, 0.125F).endVertex();
        worldrenderer.pos(x + 0.8D, y + k, z + 0.8D).tex(1.0D, d13).color(red, green, blue, 0.125F).endVertex();
        worldrenderer.pos(x + 0.8D, y, z + 0.8D).tex(1.0D, d12).color(red, green, blue, 0.125F).endVertex();
        worldrenderer.pos(x + 0.2D, y, z + 0.8D).tex(0.0D, d12).color(red, green, blue, 0.125F).endVertex();
        worldrenderer.pos(x + 0.2D, y + k, z + 0.8D).tex(0.0D, d13).color(red, green, blue, 0.125F).endVertex();
        worldrenderer.pos(x + 0.8D, y + k, z + 0.2D).tex(1.0D, d13).color(red, green, blue, 0.125F).endVertex();
        worldrenderer.pos(x + 0.8D, y, z + 0.2D).tex(1.0D, d12).color(red, green, blue, 0.125F).endVertex();
        worldrenderer.pos(x + 0.8D, y, z + 0.8D).tex(0.0D, d12).color(red, green, blue, 0.125F).endVertex();
        worldrenderer.pos(x + 0.8D, y + k, z + 0.8D).tex(0.0D, d13).color(red, green, blue, 0.125F).endVertex();
        worldrenderer.pos(x + 0.2D, y + k, z + 0.8D).tex(1.0D, d13).color(red, green, blue, 0.125F).endVertex();
        worldrenderer.pos(x + 0.2D, y, z + 0.8D).tex(1.0D, d12).color(red, green, blue, 0.125F).endVertex();
        worldrenderer.pos(x + 0.2D, y, z + 0.2D).tex(0.0D, d12).color(red, green, blue, 0.125F).endVertex();
        worldrenderer.pos(x + 0.2D, y + k, z + 0.2D).tex(0.0D, d13).color(red, green, blue, 0.125F).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.depthMask(true);
        GlStateManager.enableFog();
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityAlienBeam entity)
    {
        return null;
    }
}