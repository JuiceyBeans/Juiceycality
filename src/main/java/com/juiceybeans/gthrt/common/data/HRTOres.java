package com.juiceybeans.gthrt.common.data;

import com.gregtechceu.gtceu.api.data.worldgen.GTOreDefinition;
import com.gregtechceu.gtceu.api.data.worldgen.WorldGenLayers;
import com.gregtechceu.gtceu.api.data.worldgen.generator.veins.VeinedVeinGenerator;
import com.gregtechceu.gtceu.common.data.GTOres;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.valueproviders.UniformInt;

import static com.gregtechceu.gtceu.common.data.GTMaterials.Gold;
import static com.juiceybeans.gthrt.common.data.HRTMaterials.GoldAlloy;

public class HRTOres {

    public static final GTOreDefinition RICH_GOLD_VEIN = GTOres.create(ResourceLocation.tryParse("rich_gold_vein"), vein -> vein
            .clusterSize(UniformInt.of(40, 52)).density(1.0f).weight(50)
            .layer(WorldGenLayers.STONE)
            .heightRangeUniform(-10, 160)
            .biomes(BiomeTags.IS_OVERWORLD)
            .veinedVeinGenerator(generator -> generator
                    .oreBlock(new VeinedVeinGenerator.VeinBlockDefinition(GoldAlloy, 5))
                    .oreBlock(new VeinedVeinGenerator.VeinBlockDefinition(HRTMaterials.PreciousMetal, 2))
                    .rareBlockChance(0.05f)
                    .veininessThreshold(0.1f)
                    .maxRichnessThreshold(0.175f)
                    .minRichness(0.4f)
                    .maxRichness(0.7f)
                    .edgeRoundoffBegin(3)
                    .maxEdgeRoundoff(0.1f)
            )
            .surfaceIndicatorGenerator(indicator -> indicator
                    .surfaceRock(Gold)
            )
    );

    public static void init() {

    }
}
