package com.juiceybeans.gthrt.data.recipe;

import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.juiceybeans.gthrt.HRTMain;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.dust;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.CHEMICAL_RECIPES;

public class PolycaprolactamChainRecipes {
    public static void init(Consumer<FinishedRecipe> provider) {
        polycaprolactamChainProcesses(provider);
    }

    private static void polycaprolactamChainProcesses(Consumer<FinishedRecipe> provider) {
        CHEMICAL_RECIPES.recipeBuilder(HRTMain.id(("polycaprolactam_from_naphta")))
                .inputItems(dust, GTMaterials.Saltpeter)
                .inputFluids(GTMaterials.Naphtha.getFluid(576))
                .outputFluids(GTMaterials.Polycaprolactam.getFluid(1296))
                .duration(640).EUt(30).save(provider);

        // Remove Nylon 6 recipes from GTM
        // Maybe a config?

        //ASSEMBLER_RECIPES.recipeBuilder(HRTMain.id(("copper_cable_from_polycaprolactam")))
    }
}
