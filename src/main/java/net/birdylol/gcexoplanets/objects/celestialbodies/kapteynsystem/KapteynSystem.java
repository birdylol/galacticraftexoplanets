package net.birdylol.gcexoplanets.objects.celestialbodies.kapteynsystem;

import asmodeuscore.api.dimension.IAdvancedSpace;
import asmodeuscore.core.astronomy.BodiesData;
import asmodeuscore.core.astronomy.BodiesRegistry;
import asmodeuscore.core.astronomy.dimension.world.gen.ACBiome;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.Planet;
import micdoodle8.mods.galacticraft.api.galaxies.SolarSystem;
import micdoodle8.mods.galacticraft.api.galaxies.Star;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.core.util.WorldUtil;
import net.birdylol.gcexoplanets.objects.celestialbodies.kapteynsystem.b.WorldProviderKapteynb;
import net.birdylol.gcexoplanets.util.GEXDimensions;

public class KapteynSystem
{

    public static SolarSystem kapteyn;
    public static Planet kapteync;
    public static Planet kapteynb;




    kapteyn = new SolarSystem("kapteyn", "milky_way").setMapPosition(new Vector3(1F, -2.6F, 0.0F));
    Star starSol = (Star) new Star("kapteyn").setParentSolarSystem(kapteyn).setTierRequired(-1);
    starSol.setBodyIcon(new ResourceLocation("gcexoplanets:textures/gui/celestialbodies/kapteyn/kstar.png"));
    kapteyn.setMainStar(starSol);
    BodiesData data = new BodiesData(IAdvancedSpace.TypeBody.STAR, IAdvancedSpace.ClassBody.SUBDWARF).setStarColor(IAdvancedSpace.StarColor.RED);
    BodiesRegistry.registerBodyData(kapteyn.getMainStar(), data);


    kapteynb = BodiesRegistry.registerExPlanet(kapteyn, "kapteynb", "gcexoplanets:lang/en_us.lang", 0.48F);
    kapteynb.setBodyIcon(new ResourceLocation("gcexoplanets:textures/gui/celestialbodies/kapteyn/kb.png"));
    BodiesRegistry.setPlanetData(kapteynb, 4.0F, 3, 36000L, BodiesRegistry.calculateGravity(7.8F), false);
    BodiesRegistry.setProviderData(kapteynb, WorldProviderKapteynb .class, -1338, 6, ACBiome.ACSpace);
    BodiesRegistry.setOrbitData(kapteynb, (float) Math.PI, 1.2F, 0.9F);
    GalaxyRegistry.registerPlanet(kapteynb);
    GalacticraftRegistry.registerTeleportType(WorldProviderKapteynb.class, new TeleportTypeKapteynb());


    kapteync = BodiesRegistry.registerExPlanet(kapteyn, "kapteync", "gcexoplanets:lang/en_us.lang", 0.75F);
    kapteync.setBodyIcon(new ResourceLocation("gcexoplanets:textures/gui/celestialbodies/kapteyn/kc.png"));
    BodiesRegistry.setOrbitData(kapteync, (float) Math.PI, 1.4F, 1.5F);
    GalaxyRegistry.registerPlanet(kapteync);

    GalaxyRegistry.registerSolarSystem(kapteyn);

    //Planets
    GEXDimensions.KAPTEYN_B = WorldUtil.getDimensionTypeById(-15);



}