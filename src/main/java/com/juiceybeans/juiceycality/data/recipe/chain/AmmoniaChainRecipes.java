package com.juiceybeans.juiceycality.data.recipe.chain;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.dust;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.rodLong;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;
import static com.juiceybeans.juiceycality.common.data.JCMaterials.*;

public class AmmoniaChainRecipes {
    public static void init(Consumer<FinishedRecipe> provider) {
        ammoniaChainRecipes(provider);
    }

    private static void ammoniaChainRecipes(Consumer<FinishedRecipe> provider) {
        // MAIN CHAIN
        // Step 1: Air or Nitrogen

        // CH4 + H2O + Air(N) -> NH4C(H2O)
        CHEMICAL_RECIPES.recipeBuilder("rich_nitro_mix_from_air").duration(120).EUt(120)
                .notConsumable(dust, NiAlOCatalyst)
                .inputFluids(Methane.getFluid(1000))
                .inputFluids(Steam.getFluid(960))
                .inputFluids(Air.getFluid(1000))
                .outputFluids(RichNitrogenMix.getFluid(3000))
                .save(provider);

        // CH4 + H2O + N -> NH4C(H2O)
        CHEMICAL_RECIPES.recipeBuilder("rich_nitro_mix_from_nitrogen").duration(60).EUt(120)
                .notConsumable(dust, NiAlOCatalyst)
                .inputFluids(Methane.getFluid(1000))
                .inputFluids(Steam.getFluid(960))
                .inputFluids(Nitrogen.getFluid(1000))
                .outputFluids(RichNitrogenMix.getFluid(5000))
                .save(provider);

        // Step 2
        // NH4C(H2O) + H2O -> NH4C(H2O)2
        MIXER_RECIPES.recipeBuilder("oxidised_nitro_mix").duration(60).EUt(120)
                .notConsumable(dust, FeCrOCatalyst)
                .notConsumable(rodLong, Titanium)
                .inputFluids(Water.getFluid(1000))
                .inputFluids(RichNitrogenMix.getFluid(1000))
                .outputFluids(OxidisedNitrogenMix.getFluid(2000))
                .save(provider);

        // Step 3
        // NH4C(H2O)2 + H2O + C2H7NO -> [C2H7NO + 0.5CO2 + 0.5H2O] + [0.5H2O + NH4 + H4]
        CHEMICAL_RECIPES.recipeBuilder("purified_nitro_mix").duration(120).EUt(120)
                .inputFluids(Water.getFluid(1000))
                .inputFluids(OxidisedNitrogenMix.getFluid(1000))
                .inputFluids(Ethanolamine.getFluid(1000))
                .outputFluids(PurifiedNitrogenMix.getFluid(1000))
                .outputFluids(CarbonatedEthanolamine.getFluid(2000))
                .save(provider);

        // Step 4
        // [NH4 + H4] -> [NH4]
        CHEMICAL_RECIPES.recipeBuilder("ammonia_rich").duration(240).EUt(120)
                .inputFluids(PurifiedNitrogenMix.getFluid(2000))
                .notConsumable(dust, Magnetite)
                .outputFluids(AmmoniaRichMix.getFluid(2000))
                .save(provider);

        // Step 5
        // 2[NH4] -> NH4 + [0.5H2O + NH4 + H4]
        CENTRIFUGE_RECIPES.recipeBuilder("ammonia_from_rich_mix").duration(120).EUt(120)
                .inputFluids(AmmoniaRichMix.getFluid(2000))
                .outputFluids(Ammonia.getFluid(1000))
                .outputFluids(PurifiedNitrogenMix.getFluid(1000))
                .save(provider);

        // CATALYSTS
        MIXER_RECIPES.recipeBuilder("nialo_catalyst").duration(100).EUt(30)
                .inputItems(dust, Garnierite, 2)
                .inputItems(dust, Alumina, 5)
                .outputItems(dust, NiAlOCatalyst, 7)
                .save(provider);

        MIXER_RECIPES.recipeBuilder("fecro_catalyst").duration(100).EUt(30)
                .inputItems(dust, Iron)
                .inputItems(dust, ChromiumTrioxide, 4)
                .outputItems(dust, FeCrOCatalyst, 5)
                .save(provider);

        // RECYCLING
        // [C2H7NO + 0.5CO2 + 0.5H2O] -> C2H7NO + 0.5CO2 + 0.5H2O
        DISTILLATION_RECIPES.recipeBuilder("ethanolamine_distillation").duration(100).EUt(120)
                .inputFluids(CarbonatedEthanolamine.getFluid(2000))
                .outputFluids(Ethanolamine.getFluid(1000))
                .outputFluids(CarbonDioxide.getFluid(500))
                .outputFluids(Water.getFluid(500))
                .save(provider);        
    }
}
