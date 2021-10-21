package net.birdylol.gcexoplanets;

import asmodeuscore.AsmodeusCore;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.*;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.core.util.WorldUtil;
import net.birdylol.gcexoplanets.objects.celestialbodies.kapteynsystem.b.TeleportTypeKapteynb;
import net.birdylol.gcexoplanets.objects.celestialbodies.kapteynsystem.b.WorldProviderKapteynb;
import net.birdylol.gcexoplanets.proxy.CommonProxy;
import net.birdylol.gcexoplanets.util.GEXDimensions;
import net.birdylol.gcexoplanets.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import asmodeuscore.api.IBodies;
import asmodeuscore.api.IBodiesHandler;
import asmodeuscore.api.dimension.IAdvancedSpace.ClassBody;
import asmodeuscore.api.dimension.IAdvancedSpace.StarColor;
import asmodeuscore.api.dimension.IAdvancedSpace.TypeBody;
import asmodeuscore.core.astronomy.BodiesData;
import asmodeuscore.core.astronomy.BodiesRegistry;
import asmodeuscore.core.astronomy.BodiesRegistry.Galaxies;
import asmodeuscore.core.astronomy.dimension.world.gen.ACBiome;
import asmodeuscore.core.handler.ColorBlockHandler;


@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class GCExo
{



    @Instance
    public static GCExo instance;

    @SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.COMMON)
    public static CommonProxy proxy;

    @EventHandler
    public static void preInit(FMLPreInitializationEvent event)
    {
        for(IBodies list : AsmodeusCore.bodies)
        {
            list.preInitialization(event);

            if(list.canRegister())
                list.preInit(event);
        }


        //Systems

        //----Kapteyn



    }

    @EventHandler
    public static void init(FMLInitializationEvent event)
    {
        for(IBodies list : AsmodeusCore.bodies)
            if(list.canRegister())
                list.init(event);
    }

    @EventHandler
    public static void postInit(FMLPostInitializationEvent event)
    {
        //Galactic Registration
        //Systems




    }

}
