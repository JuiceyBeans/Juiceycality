package com.juiceybeans.gthrt.data.recipe;

import com.juiceybeans.gthrt.HRTMain;
import com.juiceybeans.gthrt.common.data.HRTMaterials;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.ASSEMBLER_RECIPES;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.MIXER_RECIPES;
import static com.juiceybeans.gthrt.common.data.HRTItems.PIEZOELECTRIC_CRYSTAL;
import static com.juiceybeans.gthrt.common.data.HRTItems.ULTRASONIC_HOMOGENIZER;

public class WetwareChainRecipes {
    public static void init(Consumer<FinishedRecipe> provider) {
        wetwareChainRecipes(provider);
    }
    private static void wetwareChainRecipes(Consumer<FinishedRecipe> provider) {
        ASSEMBLER_RECIPES.recipeBuilder(HRTMain.id("ultrasonic_homogenizer"))
                .inputItems(PIEZOELECTRIC_CRYSTAL.asStack())
                .inputItems(rodLong, RhodiumPlatedPalladium)
                .outputItems(ULTRASONIC_HOMOGENIZER.asStack())
                .EUt(30720)
                .duration(500)
                .save(provider);

        ASSEMBLER_RECIPES.recipeBuilder(HRTMain.id("piezoelectric_crystal"))
                .inputItems(gemExquisite, HRTMaterials.lead_zirconate_titanate, 2)
                .inputItems(wireFine, Gold)
                .inputFluids(SolderingAlloy.getFluid(288))
                .outputItems(PIEZOELECTRIC_CRYSTAL.asStack())
                .EUt(30720)
                .duration(430)
                .save(provider);

        // Stem Cells
        MIXER_RECIPES.recipeBuilder(HRTMain.id(("animcells")))
                .inputItems(dust, Meat)
                .inputFluids(DistilledWater.getFluid(1000))
                .outputFluids(HRTMaterials.animal_cells.getFluid(1000))
                .EUt(480)
                .duration(100)
                .save(provider);

//        BIO_REACTOR_RECIPES.recipeBuilder(HRTMain.id(("polycaprolactam_from_naphta")))
//                .notConsumable(dust, Naquadria)
//                .inputFluids(HRTMaterials.animal_cells.getFluid(1000))
//                .outputFluids(RapidlyReplicatingAnimalCells.getFluid(1000))
//                .EUt(7680)
//                .duration(500)
//                .save(provider);
//
//        BIO_REACTOR_RECIPES.recipeBuilder(HRTMain.id(("polycaprolactam_from_naphta")))
//                .inputFluids(RapidlyReplicatingAnimalCells.getFluid(1000))
//                .notConsumable(new IntCircuitIngredient(1))
//                .EUt(480)
//                .duration(100)
//                .outputFluids(MycGene.getFluid(1000))
//                .save(provider);
//
//        BIO_REACTOR_RECIPES.recipeBuilder(HRTMain.id(("polycaprolactam_from_naphta")))
//                .inputFluids(RapidlyReplicatingAnimalCells.getFluid(1000))
//                .notConsumable(new IntCircuitIngredient(2))
//                .EUt(480)
//                .duration(100)
//                .outputFluids(Oct4Gene.getFluid(1000))
//                .save(provider);
//
//        BIO_REACTOR_RECIPES.recipeBuilder(HRTMain.id(("polycaprolactam_from_naphta")))
//                .inputFluids(RapidlyReplicatingAnimalCells.getFluid(1000))
//                .notConsumable(new IntCircuitIngredient(3))
//                .EUt(480)
//                .duration(100)
//                .outputFluids(SOX2Gene.getFluid(1000))
//                .save(provider);
//
//        BIO_REACTOR_RECIPES.recipeBuilder(HRTMain.id(("polycaprolactam_from_naphta")))
//                .inputFluids(RapidlyReplicatingAnimalCells.getFluid(1000))
//                .notConsumable(new IntCircuitIngredient(4))
//                .EUt(480)
//                .duration(100)
//                .outputFluids(KFL4Gene.getFluid(1000))
//                .save(provider);
//
//        BIO_REACTOR_RECIPES.recipeBuilder(HRTMain.id(("polycaprolactam_from_naphta")))
//                .inputFluids(SterileGrowthMedium.getFluid(1000))
//                .inputFluids(HRTMaterials.animal_cells.getFluid(1000))
//                .inputFluids(HRTMaterials.gene_therapy_fluid.getFluid(1000))
//                .EUt(30720)
//                .duration(1000)
//                .outputs(STEM_CELLS.asStack())
//                .save(provider);
//
//        BIO_REACTOR_RECIPES.recipeBuilder(HRTMain.id(("polycaprolactam_from_naphta")))
//                .inputs(STEM_CELLS.asStack())
//                .inputFluids(SterileGrowthMedium.getFluid(1000))
//                .outputs(STEM_CELLS.asStack(2))
//                .outputFluids(DepletedGrowthMedium.getFluid(500))
//                .EUt(480)
//                .duration(100)
//                .save(provider);
//
//        FERMENTING_RECIPES.recipeBuilder(HRTMain.id(("polycaprolactam_from_naphta")))
//                .inputFluids(DepletedGrowthMedium.getFluid(1000))
//                .outputFluids(FermentedBiomass.getFluid(1000))
//                .EUt(30)
//                .duration(100)
//                .save(provider);
//
//        BIO_REACTOR_RECIPES.recipeBuilder(HRTMain.id(("polycaprolactam_from_naphta")))
//                .notConsumable(ULTRASONIC_HOMOGENIZER.asStack())
//                .inputs(StreptococcusPyogenes.getItemStack())
//                .inputFluids(DistilledWater.getFluid(1000))
//                .outputFluids(Cas9.getFluid(1000))
//                .EUt(480)
//                .duration(100)
//                .save(provider);
//
//        BIO_REACTOR_RECIPES.recipeBuilder(HRTMain.id(("polycaprolactam_from_naphta")))
//                .inputFluids(Cas9.getFluid(1000))
//                .inputFluids(MycGene.getFluid(1000))
//                .inputFluids(Oct4Gene.getFluid(1000))
//                .inputFluids(SOX2Gene.getFluid(1000))
//                .inputFluids(KFL4Gene.getFluid(1000))
//                .inputs(EschericiaColi.getItemStack())
//                .outputFluids(HRTMaterials.gene_plasmids.getFluid(5000))
//                .EUt(1920)
//                .duration(50)
//                .save(provider);

        MIXER_RECIPES.recipeBuilder(HRTMain.id(("chitin_from_red_shroom")))
                .notConsumable(ULTRASONIC_HOMOGENIZER.asStack())
                .inputItems(new ItemStack(Blocks.RED_MUSHROOM, 1))
                .outputFluids(HRTMaterials.chitin.getFluid(100))
                .EUt(30)
                .duration(100)
                .save(provider);

        MIXER_RECIPES.recipeBuilder(HRTMain.id(("chitin_from_brown_shroom")))
                .notConsumable(ULTRASONIC_HOMOGENIZER.asStack())
                .inputItems(new ItemStack(Blocks.BROWN_MUSHROOM, 1))
                .outputFluids(HRTMaterials.chitin.getFluid(100))
                .EUt(30)
                .duration(100)
                .save(provider);

//        BIO_REACTOR_RECIPES.recipeBuilder(HRTMain.id(("polycaprolactam_from_naphta")))
//                .inputFluids(HRTMaterials.chitin.getFluid(1000))
//                .inputItems(BifidobacteriumBreve.getItemStack())
//                .outputFluids(HRTMaterials.chitosan.getFluid(1000))
//                .EUt(120)
//                .duration(100)
//                .save(provider);

        MIXER_RECIPES.recipeBuilder(HRTMain.id(("gtf")))
                .inputFluids(HRTMaterials.gene_plasmids.getFluid(1000))
                .inputFluids(HRTMaterials.chitosan.getFluid(1000))
                .outputFluids(HRTMaterials.gene_therapy_fluid.getFluid(2000))
                .EUt(7680)
                .duration(25)
                .save(provider);
    }
}
