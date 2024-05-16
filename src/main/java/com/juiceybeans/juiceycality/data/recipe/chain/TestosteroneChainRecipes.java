package com.juiceybeans.juiceycality.data.recipe.chain;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class TestosteroneChainRecipes {
    public static void init(Consumer<FinishedRecipe> provider) {
        testosteroneChainRecipes(provider);
    }

    private static void testosteroneChainRecipes(Consumer<FinishedRecipe> provider) {
        /*CHEMICAL_RECIPES.recipeBuilder(HRTMain.id(("dissolve_platinum_metallic_powder")))
                .inputItems(dust, HRTMaterials.PlatinumMetallicPowder)
                .circuitMeta(1)
                .inputFluids(AquaRegia.getFluid(1000))
                .outputItems(dustSmall, HRTMaterials.PlatinumResidue)
                .outputFluids(HRTMaterials.PlatinumConcentrate.getFluid(1000))
                .duration(250).EUt(VA[LV]).save(provider);*/
    }
}
