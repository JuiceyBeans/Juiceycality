package com.juiceybeans.juiceycality.data.recipe;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.dust;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.nugget;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;
import static com.juiceybeans.juiceycality.common.data.JCMaterials.*;
import static com.juiceybeans.juiceycality.common.data.JCRecipeTypes.CHEMICAL_DEHYDRATOR_RECIPES;

public class GoldChainRecipes {
    public static void init(Consumer<FinishedRecipe> provider) {
        VanillaRecipeHelper.addSmeltingRecipe(provider, "gold_from_nugget", ChemicalHelper.get(dust, PreciousMetal), ChemicalHelper.get(nugget, Gold));

        goldChainRecipes(provider);
    }

    private static void goldChainRecipes(Consumer<FinishedRecipe> provider) {
        // Step 1 recovery (8 nuggets per PM)
        CENTRIFUGE_RECIPES.recipeBuilder("copper_from_gold_alloy")
                .inputItems(dust, GoldAlloy, 4)
                .outputItems(dust, Copper, 3)
                .chancedOutput(ChemicalHelper.get(dust, Gold, 1), 4444, 0)
                .duration(500)
                .EUt(30)
                .save(provider);

        // Step 2 recovery (16 nuggets per PM)
        ELECTROLYZER_RECIPES.recipeBuilder("copper_from_gold_leach")
                .inputItems(dust, GoldLeach, 4)
                .inputFluids(Hydrogen.getFluid(1000))
                .outputFluids(Water.getFluid(1000))
                .outputItems(dust, Copper, 3)
                .chancedOutput(ChemicalHelper.get(dust, Gold, 1), 8888, 0)
                .duration(300)
                .EUt(30)
                .save(provider);

        // Step 3 recovery
        // This step does not directly process Chloroauric Acid, and instead is processing
        // other byproducts from the chain, which are compacted from the older versions of the chain.
        // Cu3? -> 3Cu + Fe + Ni + Ag + Pb
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder("copper_leach_dehydration").EUt(30).duration(80)
                .inputItems(dust, CopperLeach, 4)
                .outputItems(dust, Copper, 3)
                .chancedOutput(ChemicalHelper.get(dust, Lead), 1500, 500)
                .chancedOutput(ChemicalHelper.get(dust, Iron), 1200, 400)
                .chancedOutput(ChemicalHelper.get(dust, Nickel), 1000, 300)
                .chancedOutput(ChemicalHelper.get(dust, Silver), 800, 200)
                .save(provider);


        // MAIN CHAIN ==================================================================================================

        // STEP 1
        // Au? + 3Cu -> Cu3Au?
        ALLOY_SMELTER_RECIPES.recipeBuilder("gold_alloy_from_precious_metal").EUt(30).duration(100)
                .inputItems(dust, PreciousMetal)
                .inputItems(dust, Copper, 3)
                .outputItems(dust, GoldAlloy, 4)
                .save(provider);

        // STEP 2
        // Cu3Au? + HNO3 -> Cu3Au?(OH) + NO2
        CHEMICAL_RECIPES.recipeBuilder("gold_leach_from_alloy").duration(80)
                .inputItems(dust, GoldAlloy, 4)
                .inputFluids(NitricAcid.getFluid(1000))
                .outputItems(dust, GoldLeach, 4)
                .outputFluids(NitrogenDioxide.getFluid(1000))
                .save(provider);

        // STEP 3
        // Cu3Au?(OH) + HCl -> HAuCl(OH) + Cu3?
        CHEMICAL_RECIPES.recipeBuilder("copper_leach_from_gold_leach").duration(80)
                .inputItems(dust, GoldLeach, 4)
                .inputFluids(HydrochloricAcid.getFluid(1000))
                .outputItems(dust, CopperLeach, 4)
                .outputFluids(ChloroauricAcid.getFluid(1000))
                .save(provider);

        // STEP 4
        // HAuCl(OH) -> Au + H2O + Cl
        CHEMICAL_RECIPES.recipeBuilder("gold_from_chloroauric_acid").duration(100)
                .inputFluids(ChloroauricAcid.getFluid(1000))
                .notConsumable(dust, PotassiumMetabisulfite)
                .outputItems(dust, Gold, 2)
                .outputFluids(Water.getFluid(1000))
                .outputFluids(Chlorine.getFluid(1000))
                .save(provider);

        // SIDE INGREDIENTS ============================================================================================

        // NOT CONSUMED INGREDIENT
        MIXER_RECIPES.recipeBuilder("potassium_metabisulfite").duration(100).EUt(30)
                .circuitMeta(1)
                .inputItems(dust, Potassium, 2)
                .inputItems(dust, Sulfur, 2)
                .inputFluids(Oxygen.getFluid(5000))
                .outputItems(dust, PotassiumMetabisulfite, 9)
                .save(provider);
    }
}
