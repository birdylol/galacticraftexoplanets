package net.birdylol.gcexoplanets.objects.celestialbodies.kapteynsystem.b;


import asmodeuscore.api.dimension.IProviderFreeze;
import asmodeuscore.core.astronomy.dimension.world.gen.WorldProviderAdvancedSpace;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.core.client.CloudRenderer;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import net.birdylol.gcexoplanets.GCExo;
import net.birdylol.gcexoplanets.objects.celestialbodies.kapteynsystem.KapteynSystem;
import net.birdylol.gcexoplanets.objects.celestialbodies.kapteynsystem.b.biome.BiomeProviderKapteynb;
import net.birdylol.gcexoplanets.objects.celestialbodies.kapteynsystem.b.sky.SkyProviderKapteynb;
import net.birdylol.gcexoplanets.util.GEXDimensions;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

 

public class WorldProviderKapteynb extends WorldProviderAdvancedSpace implements IProviderFreeze{
	
    @Override
    public double getHorizon()
    {
        return 44.0D;
    }

    @Override

    public float getFallDamageModifier() {
        return 0.16F;
    }
 

    @Override
    public double getFuelUsageMultiplier() {

        return 0.8;

    }

    @Override

    public double getMeteorFrequency() {

        return 3.0;

    }

 

    @Override

    public float getSoundVolReductionAmount() {

        return Float.MAX_VALUE;

    }

    @Override
    public boolean canRainOrSnow() {
        return true;
    }

 

    @Override
    public CelestialBody getCelestialBody() {

        return KapteynSystem.kapteynb;

    }
    
    //Created later
    @Override

    public Class<? extends IChunkGenerator> getChunkProviderClass() {

        return ChunkProviderKapteynb.class;

    }
    
    @Override 
    public Class<? extends BiomeProvider> getBiomeProviderClass() { 
    	return BiomeProviderKapteynb.class;
    }
    
    @Override
    public Vector3 getFogColor() {

    	float f = 1.0F - this.getStarBrightness(1.5F);
   	 	return new Vector3(32 / 255.0F * f, 32 / 255.0F * f, 32 / 255.0F * f);
    }
    
    @Override
    public Vector3 getSkyColor() {

    	float f = 1.0F - this.getStarBrightness(1.0F);
   	 	return new Vector3(12 / 255.0F * f, 12 / 255.0F * f, 12 / 255.0F * f);
    }

     
	@Override
	public boolean isSkyColored() {
		return false;
	}
 
 

	@Override
	public boolean hasSunset() {
		return false;
	}

 

    //Can players respawn here?

    @Override
    public boolean shouldForceRespawn() {
        return !ConfigManagerCore.forceOverworldRespawn;
    }    
    
    @Override
    @SideOnly(Side.CLIENT)
    public float getStarBrightness(float par1)
    {
        final float var2 = this.world.getCelestialAngle(par1);
        float var3 = 1.0F - (MathHelper.cos(var2 * (float) Math.PI * 2.0F) * 2.0F + 0.25F);

        if (var3 < 0.0F)
        {
            var3 = 0.0F;
        }

        if (var3 > 1.0F)
        {
            var3 = 1.0F;
        }

        return var3 * var3 * 0.5F + 0.3F;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public float getSunBrightness(float par1) {
       float f1 = this.world.getCelestialAngle(1.0F);
       float f2 = 1.25F - (MathHelper.cos(f1 * 3.1415927F * 2.0F) * 2.0F + 0.2F);
       float f3 = this.world.getWorldTime();
       if(f2 < 0.0F) {
          f2 = 0.0F;
       }

       if(f2 > 1.0F) {
          f2 = 1.0F;
       }

       f2 = 1.2F - f2;
       return f2 * 0.25F;
    }
    
    @Override

    public IRenderHandler getCloudRenderer(){
        return new CloudRenderer();
    }

	@SideOnly(Side.CLIENT)
    public IRenderHandler getSkyRenderer()
    {
    	if (super.getSkyRenderer() == null)
		{
			this.setSkyRenderer(new SkyProviderKapteynb());
		}

		return super.getSkyRenderer();
    }

	@Override
	public int getDungeonSpacing() {
		return 0;
	}

	@Override
	public ResourceLocation getDungeonChestType() {
		return null;
	}

	@Override
	public List<Block> getSurfaceBlocks() {
		return null;
	}

	@Override
	public DimensionType getDimensionType() {
	
		return GEXDimensions.KAPTEYN_B;
	}

	@Override
	protected float getThermalValueMod()
	{
		return 0.1F;
	}

}