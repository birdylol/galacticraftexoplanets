package net.birdylol.gcexoplanets;

import asmodeuscore.AsmodeusCore;
import net.birdylol.gcexoplanets.proxy.CommonProxy;
import net.birdylol.gcexoplanets.util.Reference;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.launchwrapper.LogWrapper;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import asmodeuscore.api.IBodies;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static net.birdylol.gcexoplanets.util.Reference.MODID;
import static net.minecraft.launchwrapper.LogWrapper.log;
import static sun.awt.geom.Crossings.debug;


@Mod(modid = MODID, name = Reference.NAME, version = Reference.VERSION)
public class GCExo
{

    public static final String ASSET_PREFIX = MODID;
    private static final String MODID = "gcexoplanets";

    @Instance(GCExo.MODID);
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
        @EventBusSubscriber(modid = MODID)
        class RegistrationHandler
        {
            @SubscribeEvent
            public void registerModels(ModelRegistryEvent event) {
                proxy.registerVariants();
            }

            @SubscribeEvent
            public void registerItems(RegistryEvent.Register<Item> event)
            {

                for(IBodies list : AsmodeusCore.bodies)
                    if(list.canRegister())
                        list.registerItems(event);
            }

            @SubscribeEvent(priority = EventPriority.LOWEST)
            public void registerRecipes(RegistryEvent.Register<IRecipe> event)
            {
                for(IBodies list : AsmodeusCore.bodies)
                    if(list.canRegister())
                        list.registerRecipes();
            }
        }

    }

}
