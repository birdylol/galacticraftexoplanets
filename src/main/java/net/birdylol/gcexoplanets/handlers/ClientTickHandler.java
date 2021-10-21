package net.birdylol.gcexoplanets.handlers;

import asmodeuscore.core.handler.ColorBlockHandler;
import asmodeuscore.core.utils.worldengine.WE_ChunkProvider;
import asmodeuscore.core.utils.worldengine.WE_PerlinNoise;
import asmodeuscore.core.utils.worldengine.WE_WorldProvider;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldProviderSpace;
import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.core.util.ColorUtil;
import micdoodle8.mods.galacticraft.core.util.PlayerUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkProviderServer;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

import java.util.Random;

public class ClientTickHandler
{


    public Minecraft mc = FMLClientHandler.instance().getClient();
    public Random rand;
    private String[] s;


    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onClientTick(TickEvent.ClientTickEvent event)
    {
        EntityPlayerSP player = Minecraft.getMinecraft().player;
        WorldClient world = mc.world;

        if(event.phase == TickEvent.Phase.END)
        {
            if (Side.CLIENT != null)
            {
                if(player != null && world != null)
                {
                    
                }
            }
        }
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onRenderTick(TickEvent.RenderTickEvent event)
    {
        final Minecraft minecraft = FMLClientHandler.instance().getClient();
        final EntityPlayerSP player = minecraft.player;
        final EntityPlayerSP playerBaseClient = PlayerUtil.getPlayerBaseClientFromPlayer(player, false);

        if (event.phase == TickEvent.Phase.END)

        if (player != null)
        {
        		/*
        		if(player.ridingEntity instanceof EntityTieredRocket)
        		{
        			OverlayRocketHelp.renderSpaceshipOverlay();
        		}*/

            if(minecraft.currentScreen == null)
            {

                long t1 = player.world.provider instanceof WorldProviderSpace ? ((WorldProviderSpace) player.world.provider).getDayLength() : 24000;
                long time = player.world.getWorldTime() % (t1 > 0 ? t1 : 1);

                float temp = player.world.provider instanceof IGalacticraftWorldProvider ? ((IGalacticraftWorldProvider) player.world.provider).getThermalLevelModifier() : 1.0F;
                boolean isWE = player.getEntityWorld().provider instanceof WE_WorldProvider;
                double count = 0;

                World world = ColorBlockHandler.world;
                if(isWE) {
                    WE_ChunkProvider chunk = ((WE_WorldProvider)world.provider).chunk_provider;
                    if(chunk != null) {
                        double scaleX = chunk.biomemapScaleX;
                        double persistance = chunk.biomemapPersistence;
                        count = WE_PerlinNoise.PerlinNoise2D((player.getEntityWorld().getSeed() * 11) ^ 6,	player.getEntityWorld().getChunkFromBlockCoords(player.getPosition()).x / scaleX, player.getEntityWorld().getChunkFromBlockCoords(player.getPosition()).z / scaleX,
                                persistance, chunk.biomemapNumberOfOctaves)
                                * chunk.biomemapScaleY;
                    }
                }


                

                int k = 4;
                if(mc.gameSettings.isKeyDown(mc.gameSettings.keyBindSneak)) k = s.length;
                GL11.glPushMatrix();
                //GlStateManager.disableLighting();
                for(int i = 0; i < k; i++)
                    if(!minecraft.gameSettings.hideGUI)
                        minecraft.fontRenderer.drawStringWithShadow(s[i], 10, 28 + i*10, ColorUtil.to32BitColor(255, 255, 255, 255));
                //GlStateManager.enableLighting();
                GL11.glPopMatrix();

            }
            GlStateManager.disableLighting();

            GL11.glPushMatrix();
            GL11.glPopMatrix();


        }
    }
}
