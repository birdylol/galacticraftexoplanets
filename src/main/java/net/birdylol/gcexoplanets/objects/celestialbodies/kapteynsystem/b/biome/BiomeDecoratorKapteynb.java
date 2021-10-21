package net.birdylol.gcexoplanets.objects.celestialbodies.kapteynsystem.b.biome;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import net.minecraft.world.World;

public class BiomeDecoratorKapteynb extends BiomeDecoratorSpace
{

    private World currentWorld;
    //private WorldGenerator nickelGen;

    public BiomeDecoratorKapteynb()
    {
        //this.nickelGen = new WorldGenMinableMeta(GSBlocks.MERCURY_BLOCKS, 4, 3, true, GSBlocks.MERCURY_BLOCKS, 2);
       
    }

    @Override
    protected void decorate()
    {
    	//if(GSConfigCore.enableOresGeneration) this.generateOre(12, nickelGen, 5, 20);
    }

    @Override
    protected void setCurrentWorld(World world)
    {
        this.currentWorld = world;
    }

    @Override
    protected World getCurrentWorld()
    {
        return this.currentWorld;
    }
}
