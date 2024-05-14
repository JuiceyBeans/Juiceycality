package com.juiceybeans.gthrt.data.recipe;

import com.juiceybeans.gthrt.HRTMain;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTItems.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;
import static com.juiceybeans.gthrt.common.data.HRTItems.*;
import static com.juiceybeans.gthrt.common.data.HRTMaterials.*;
import static com.juiceybeans.gthrt.common.data.HRTRecipeTypes.*;

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
                .inputItems(gemExquisite, LeadZirconateTitanate, 2)
                .inputItems(wireFine, Gold)
                .inputFluids(SolderingAlloy.getFluid(288))
                .outputItems(PIEZOELECTRIC_CRYSTAL.asStack())
                .EUt(30720)
                .duration(430)
                .save(provider);

        // GROWTH MEDIUM ===============================================================================================

        // 2CaO + 5C -> CO2 + 2CaCl2
        BLAST_RECIPES.recipeBuilder(HRTMain.id("cacl2_from_cao"))
                .inputItems(dust, Quicklime, 4)
                .inputItems(dust, Carbon, 5)
                .outputFluids(CarbonMonoxide.getFluid(1000))
                .outputItems(dust, CalciumChloride, 6)
                .blastFurnaceTemp(2500)
                .EUt(120)
                .duration(300)
                .build();

        // CaC2 + 2H2O -> Ca(OH)2 + C2H2
        BLAST_RECIPES.recipeBuilder(HRTMain.id("acetylene"))
                .inputItems(dust, CalciumChloride)
                .inputFluids(Steam.getFluid(2000))
                .outputItems(dust, CalciumHydroxide, 5)
                .outputFluids(Acetylene.getFluid(1000))
                .blastFurnaceTemp(2300)
                .EUt(120)
                .duration(200)
                .build();

        // Ca(OH)2 + 2HCl -> 2H2O + CaCl2
        CHEMICAL_RECIPES.recipeBuilder(HRTMain.id("cacl2_from_caoh2"))
                .inputItems(dust, CalciumHydroxide, 5)
                .inputFluids(HydrochloricAcid.getFluid(2000))
                .outputFluids(Water.getFluid(2000))
                .outputItems(dust, CalciumChloride, 3)
                .EUt(120)
                .duration(60)
                .build();

        // O + CH3OH -> CH2O + H2O
        CHEMICAL_RECIPES.recipeBuilder(HRTMain.id("formaldehyde_from_methanol"))
                .notConsumable(dust, Silver)
                .inputFluids(Oxygen.getFluid(1000))
                .inputFluids(Methanol.getFluid(1000))
                .outputFluids(Formaldehyde.getFluid(1000))
                .outputFluids(Water.getFluid(1000))
                .EUt(30720)
                .duration(200)
                .build();

        // CH2O + C2H2 -> C3H4O
        CHEMICAL_RECIPES.recipeBuilder(HRTMain.id("propargyl_alc_from_formaldehyde"))
                .notConsumable(dust, Copper)
                .inputFluids(Formaldehyde.getFluid(1000))
                .inputFluids(Acetylene.getFluid(1000))
                .outputFluids(PropargylAlcohol.getFluid(1000))
                .EUt(120)
                .duration(120)
                .build();

        // C3H4O + HCl -> C3H3Cl + H2O
        CHEMICAL_RECIPES.recipeBuilder(HRTMain.id("propargyl_chl_from_alc"))
                .inputFluids(PropargylAlcohol.getFluid(1000))
                .inputFluids(HydrochloricAcid.getFluid(1000))
                .outputFluids(PropargylChloride.getFluid(1000))
                .outputFluids(Water.getFluid(1000))
                .EUt(120)
                .duration(100)
                .build();

//        EXTRACTOR_RECIPES.recipeBuilder(HRTMain.id("resin"))
//                .inputItems(STICKY_RESIN)
//                .outputFluids(Resin.getFluid(100))
//                .EUt(24)
//                .duration(100)
//                .build();

        DISTILLATION_RECIPES.recipeBuilder(HRTMain.id("turpentine_from_resin"))
                .chancedOutput(dust, RawRubber, 1, 5000, 0)
                .inputFluids(Resin.getFluid(1000))
                .outputFluids(Turpentine.getFluid(200))
                .outputFluids(Isoprene.getFluid(20))
                .EUt(480)
                .duration(500)
                .build();

        // C10H16 + H2SO4 -> C10H16 + H2SO4
        CHEMICAL_RECIPES.recipeBuilder(HRTMain.id("betapinene_from_turpentine"))
                .inputFluids(Turpentine.getFluid(1000))
                .inputFluids(SulfuricAcid.getFluid(1000))
                .outputItems(dust, BetaPinene, 26)
                .outputFluids(SulfuricAcid.getFluid(1000))
                .EUt(480)
                .duration(110)
                .build();

        // C10H16 + 2C5H8 + 2O -> 2C10H16O
        CHEMICAL_RECIPES.recipeBuilder(HRTMain.id("citral_from_b-pinene"))
                .inputItems(dust, BetaPinene, 26)
                .inputFluids(Isoprene.getFluid(2000))
                .inputFluids(Oxygen.getFluid(2000))
                .outputFluids(Citral.getFluid(2000))
                .EUt(480)
                .duration(100)
                .build();

        // C10H16O + C3H6O -> C13H20O + H2O
        CHEMICAL_RECIPES.recipeBuilder(HRTMain.id("betaionone_from_citral"))
                .inputFluids(Citral.getFluid(1000))
                .inputFluids(Acetone.getFluid(1000))
                .outputFluids(BetaIonone.getFluid(1000))
                .outputFluids(Water.getFluid(1000))
                .EUt(120)
                .duration(250)
                .build();

        // 25C13H20O + 5C3H3Cl -> 17C20H30O + 8O + 5HCl
        LARGE_CHEMICAL_RECIPES.recipeBuilder(HRTMain.id("vit_a_from_b-ionone"))
                .inputFluids(BetaIonone.getFluid(25000))
                .inputFluids(PropargylChloride.getFluid(5000))
                .outputFluids(VitaminA.getFluid(17000))
                .outputFluids(Oxygen.getFluid(8000))
                .outputFluids(HydrochloricAcid.getFluid(5000))
                .EUt(480)
                .duration(150)
                .build();

        MACERATOR_RECIPES.recipeBuilder(HRTMain.id("yeast_from_apple"))
                .inputItems(Items.APPLE)
                .chancedOutput(dust, Yeast, 500, 500)
                .EUt(30)
                .duration(50)
                .build();

        BIO_REACTOR_RECIPES.recipeBuilder(HRTMain.id("linoleic_acid_from_yeast"))
                .inputFluids(Biomass.getFluid(1000))
                .inputItems(dust, Yeast)
                .notConsumable(ULTRASONIC_HOMOGENIZER)
                .outputFluids(LinoleicAcid.getFluid(1000))
                .EUt(1920)
                .duration(200)
                .build();

        // C2H4 + O -> C2H4O
        CHEMICAL_RECIPES.recipeBuilder(HRTMain.id("ethylene_oxide_from_ethylene"))
                .circuitMeta(10)
                .inputFluids(Ethylene.getFluid(1000))
                .inputFluids(Oxygen.getFluid(1000))
                .outputFluids(EthyleneOxide.getFluid(1000))
                .EUt(480)
                .duration(100)
                .build();

        // NH3 + C2H4O -> C2H7NO
        CHEMICAL_RECIPES.recipeBuilder(HRTMain.id("ethanolamine_from_ammonia"))
                .inputFluids(Ammonia.getFluid(1000))
                .inputFluids(EthyleneOxide.getFluid(1000))
                .outputFluids(Ethanolamine.getFluid(1000))
                .EUt(7680)
                .duration(60)
                .build();

        BIO_REACTOR_RECIPES.recipeBuilder(HRTMain.id("biotin_from_cupravidus"))
                .inputItems(dust, CupriavidusNecator)
                .inputItems(dust, Sugar)
                .inputFluids(Nitrogen.getFluid(1000))
                .inputFluids(Hydrogen.getFluid(1000))
                .outputFluids(Biotin.getFluid(2000))
                .EUt(7680)
                .duration(40)
                .build();

        LARGE_CHEMICAL_RECIPES.recipeBuilder(HRTMain.id("b27_from_biotin"))
                .inputFluids(Biotin.getFluid(1000))
                .inputFluids(LinoleicAcid.getFluid(1000))
                .inputFluids(Catalase.getFluid(1000))
                .inputFluids(VitaminA.getFluid(1000))
                .inputFluids(Ethanolamine.getFluid(1000))
                .outputFluids(B27Supplement.getFluid(5000))
                .EUt(7680)
                .duration(150)
                .build();

        MIXER_RECIPES.recipeBuilder(HRTMain.id("clean_ammonia_from_water"))
                .inputFluids(Ammonia.getFluid(1000))
                .inputFluids(DistilledWater.getFluid(1000))
                .outputFluids(CleanAmmoniaSolution.getFluid(2000))
                .EUt(480)
                .duration(100)
                .build();

        BIO_REACTOR_RECIPES.recipeBuilder(HRTMain.id("glutamine_from_ammonia"))
                .inputFluids(CleanAmmoniaSolution.getFluid(1000))
                .inputItems(dust, BrevibacteriumFlavium)
                .inputItems(dust, Sugar)
                .outputItems(dust, Glutamine, 40)
                .EUt(30720)
                .duration(500)
                .build();

        CENTRIFUGE_RECIPES.recipeBuilder(HRTMain.id("blood_from_meat"))
                .inputItems(dust, Meat)
                .outputFluids(Blood.getFluid(1000))
                .EUt(30)
                .duration(50)
                .build();

        CENTRIFUGE_RECIPES.recipeBuilder(HRTMain.id("blood_centrifuge"))
                .inputFluids(Blood.getFluid(1000))
                .outputFluids(BloodCells.getFluid(500))
                .outputFluids(BloodPlasma.getFluid(500))
                .EUt(480)
                .duration(200)
                .build();

        CENTRIFUGE_RECIPES.recipeBuilder(HRTMain.id("blood_plasma_centrifuge"))
                .inputFluids(BloodPlasma.getFluid(1000))
                .outputFluids(Catalase.getFluid(200))
                .outputFluids(BFGF.getFluid(200))
                .outputFluids(EGF.getFluid(200))
                .EUt(480)
                .duration(50)
                .build();

        LARGE_MIXER_RECIPES.recipeBuilder(HRTMain.id("raw_medium_from_b27"))
                .inputFluids(B27Supplement.getFluid(1000))
                .inputFluids(AmmoniumNitrate.getFluid(1000))
                .inputItems(dust, Glutamine, 20)
                .inputFluids(BFGF.getFluid(1000))
                .inputFluids(EGF.getFluid(1000))
                .outputFluids(RawGrowthMedium.getFluid(4000))
                .EUt(480)
                .duration(500)
                .build();

        MIXER_RECIPES.recipeBuilder(HRTMain.id("growth_med_from_cells"))
                .inputFluids(BloodCells.getFluid(1000))
                .notConsumable(ULTRASONIC_HOMOGENIZER)
                .inputFluids(DistilledWater.getFluid(1000))
                .outputFluids(BacterialGrowthMedium.getFluid(2000))
                .EUt(120)
                .duration(100)
                .build();

        /////////////////////////////
        // Sterlized Growth Medium //
        /////////////////////////////

        MIXER_RECIPES.recipeBuilder(HRTMain.id("silica_base_from_sio2"))
                .inputItems(dust, SiliconDioxide, 3)
                .inputFluids(HydrochloricAcid.getFluid(1000))
                .inputItems(dust, SodiumHydroxide, 3)
                .inputFluids(Steam.getFluid(1000))
                .outputFluids(SilicaGelBase.getFluid(1000))
                .EUt(120)
                .duration(120)
                .build();

        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder(HRTMain.id("silica_gel_from_base"))
                .inputFluids(SilicaGelBase.getFluid(1000))
                .outputItems(dust, SilicaGel, 3)
                .outputItems(dust, Salt, 2)
                .EUt(480)
                .duration(125)
                .build();

        MIXER_RECIPES.recipeBuilder(HRTMain.id("silica_alumina_from_alumina"))
                .inputItems(dust, SilicaGel, 3)
                .inputItems(dust, Alumina, 5)
                .outputItems(dust, SilicaAluminaGel, 8)
                .EUt(30)
                .duration(60)
                .build();

        BLAST_RECIPES.recipeBuilder(HRTMain.id("zeolite_pellets_from_silica_alumina"))
                .inputItems(dust, SilicaAluminaGel)
                .outputItems(dust, ZeoliteSievingPellets)
                .blastFurnaceTemp(4500)
                .EUt(120)
                .duration(400)
                .build();

        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder(HRTMain.id("dehydrate_zeolite_pellets"))
                .inputItems(dust, WetZeoliteSievingPellets)
                .outputItems(dust, ZeoliteSievingPellets)
                .EUt(120)
                .duration(50)
                .build();

        MIXER_RECIPES.recipeBuilder(HRTMain.id("ethanol_from_zeolite"))
                .inputItems(dust, ZeoliteSievingPellets)
                .inputFluids(Ethanol.getFluid(1000))
                .outputFluids(Ethanol_100.getFluid(1000))
                .outputItems(dust, WetZeoliteSievingPellets)
                .EUt(120)
                .duration(100)
                .build();

        AUTOCLAVE_RECIPES.recipeBuilder(HRTMain.id("sterilized_dish"))
                .inputItems(PETRI_DISH)
                .inputFluids(Ethanol_100.getFluid(100))
                .outputItems(STERILIZED_PETRI_DISH)
                .EUt(7680)
                .duration(25)
                .build();

        MIXER_RECIPES.recipeBuilder(HRTMain.id("piranha_from_sulfuric"))
                .inputFluids(HydrogenPeroxide.getFluid(1000))
                .inputFluids(SulfuricAcid.getFluid(1000))
                .outputFluids(PiranhaSolution.getFluid(2000))
                .EUt(30)
                .duration(50)
                .build();

        CHEMICAL_BATH_RECIPES.recipeBuilder(HRTMain.id("dish_cleaning"))
                .inputFluids(PiranhaSolution.getFluid(100))
                .inputItems(CONTAMINATED_PETRI_DISH)
                .outputItems(PETRI_DISH)
                .EUt(30)
                .duration(25)
                .build();

        // [H2SO4 + HNO3] + C6H6 -> C6H5NO2 + H2O + H2SO4
        CHEMICAL_RECIPES.recipeBuilder(HRTMain.id("nitrobenzene_from_benzene"))
                .inputFluids(NitrationMixture.getFluid(2000))
                .inputFluids(Benzene.getFluid(1000))
                .outputFluids(NitroBenzene.getFluid(1000))
                .outputFluids(DilutedSulfuricAcid.getFluid(2000))
                .EUt(30)
                .duration(100)
                .build();

        // 6H + C6H5NO2 -> C6H5NH2 + 2H2O
        CHEMICAL_RECIPES.recipeBuilder(HRTMain.id("aniline_from_nitrobenzene"))
                .inputFluids(Hydrogen.getFluid(6000))
                .inputFluids(NitroBenzene.getFluid(1000))
                .notConsumable(dust, Zinc)
                .outputFluids(Aniline.getFluid(1000))
                .outputFluids(Water.getFluid(2000))
                .EUt(30)
                .duration(100)
                .build();

        // HCl + 2H2SO4 + O -> HSO3Cl + 2H2O + SO3
        LARGE_CHEMICAL_RECIPES.recipeBuilder(HRTMain.id("chlorosulfonic_from_sulfuric"))
                .inputFluids(HydrochloricAcid.getFluid(1000))
                .inputFluids(SulfuricAcid.getFluid(2000))
                .inputFluids(Oxygen.getFluid(1000))
                .outputFluids(ChlorosulfonicAcid.getFluid(2000))
                .outputFluids(Water.getFluid(2000))
                .outputFluids(SulfurTrioxide.getFluid(1000))
                .EUt(480)
                .duration(200)
                .build();

        // C6H5NH2 + (CH3CO)2O + HSO3Cl -> C8H8ClNO3S + H2O + CH3COOH
        LARGE_CHEMICAL_RECIPES.recipeBuilder(HRTMain.id("acetylsulfanilyl_from_aniline"))
                .inputFluids(Aniline.getFluid(1000))
                .inputFluids(AceticAnhydride.getFluid(1000))
                .inputFluids(ChlorosulfonicAcid.getFluid(1000))
                .outputFluids(AcetylsulfanilylChloride.getFluid(1000))
                .outputFluids(Water.getFluid(1000))
                .outputFluids(AceticAcid.getFluid(1000))
                .EUt(1920)
                .duration(100)
                .build();

        // H2O + Na2CO3 -> NaHCO3 + NaOH
        LARGE_CHEMICAL_RECIPES.recipeBuilder(HRTMain.id("sodium_bicar_from_soda_ash")).duration(140).EUt(30)
                .inputFluids(Water.getFluid(1000))
                .inputItems(dust, SodaAsh, 6)
                .outputItems(dust, SodiumBicarbonate, 6)
                .outputItems(dust, SodiumHydroxide, 3)
                .build();

        // NaHCO3 -> NaOH + CO2
        ELECTROLYZER_RECIPES.recipeBuilder(HRTMain.id("sodium_hydrox_from_bicarbonate")).duration(145).EUt(120)
                .inputItems(dust, SodiumBicarbonate, 6)
                .outputItems(dust, SodiumHydroxide, 3)
                .outputFluids(CarbonDioxide.getFluid(1000))
                .build();

        // NaHCO3 + C8H8ClNO3S + NH3 -> NaCl + C6H8N2O2S + CO2 + CH3COOH
        LARGE_CHEMICAL_RECIPES.recipeBuilder(HRTMain.id("sulfanilamide_from_na_bicar"))
                .inputItems(dust, SodiumBicarbonate, 6)
                .inputFluids(AcetylsulfanilylChloride.getFluid(1000))
                .inputFluids(Ammonia.getFluid(1000))
                .outputItems(dust, Salt, 2)
                .outputFluids(Sulfanilamide.getFluid(1000))
                .outputFluids(CarbonDioxide.getFluid(1000))
                .outputFluids(AceticAcid.getFluid(1000))
                .EUt(30720)
                .duration(50)
                .build();

        MIXER_RECIPES.recipeBuilder(HRTMain.id("sterile_medium_from_sulfanilamide"))
                .inputFluids(RawGrowthMedium.getFluid(1000))
                .inputFluids(Sulfanilamide.getFluid(250))
                .outputFluids(SterileGrowthMedium.getFluid(1250))
                .EUt(7680)
                .duration(100)
                .build();




        ////////////////
        // Stem Cells //
        ////////////////
        MIXER_RECIPES.recipeBuilder(HRTMain.id(("animcells")))
                .inputItems(dust, Meat)
                .inputFluids(DistilledWater.getFluid(1000))
                .outputFluids(AnimalCells.getFluid(1000))
                .EUt(480)
                .duration(100)
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder(HRTMain.id(("rrac_from_animcells")))
                .notConsumable(dust, Naquadria)
                .inputFluids(AnimalCells.getFluid(1000))
                .outputFluids(RapidlyReplicatingAnimalCells.getFluid(1000))
                .EUt(7680)
                .duration(500)
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder(HRTMain.id(("mycgene_from_rrac")))
                .inputFluids(RapidlyReplicatingAnimalCells.getFluid(1000))
                .circuitMeta(1)
                .EUt(480)
                .duration(100)
                .outputFluids(Myc.getFluid(1000))
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder(HRTMain.id(("oct4_from_rrac")))
                .inputFluids(RapidlyReplicatingAnimalCells.getFluid(1000))
                .circuitMeta(2)
                .EUt(480)
                .duration(100)
                .outputFluids(Oct_4.getFluid(1000))
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder(HRTMain.id(("sox2_from_rrac")))
                .inputFluids(RapidlyReplicatingAnimalCells.getFluid(1000))
                .circuitMeta(3)
                .EUt(480)
                .duration(100)
                .outputFluids(SOX_2.getFluid(1000))
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder(HRTMain.id(("kfl4_from_rrac")))
                .inputFluids(RapidlyReplicatingAnimalCells.getFluid(1000))
                .circuitMeta(4)
                .EUt(480)
                .duration(100)
                .outputFluids(KFL_4.getFluid(1000))
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder(HRTMain.id(("stemcells")))
                .inputFluids(SterileGrowthMedium.getFluid(1000))
                .inputFluids(AnimalCells.getFluid(1000))
                .inputFluids(GeneTherapyFluid.getFluid(1000))
                .EUt(30720)
                .duration(1000)
                .outputItems(STEM_CELLS.asStack())
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder(HRTMain.id(("depleted_growth_medium")))
                .inputItems(STEM_CELLS)
                .inputFluids(SterileGrowthMedium.getFluid(1000))
                .outputItems(STEM_CELLS, 2)
                .outputFluids(DepletedGrowthMedium.getFluid(500))
                .EUt(480)
                .duration(100)
                .save(provider);

        FERMENTING_RECIPES.recipeBuilder(HRTMain.id(("fermented_biomass")))
                .inputFluids(DepletedGrowthMedium.getFluid(1000))
                .outputFluids(FermentedBiomass.getFluid(1000))
                .EUt(30)
                .duration(100)
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder(HRTMain.id(("cas9")))
                .notConsumable(ULTRASONIC_HOMOGENIZER.asStack())
                .inputItems(dust, StreptococcusPyogenes)
                .inputFluids(DistilledWater.getFluid(1000))
                .outputFluids(Cas_9.getFluid(1000))
                .EUt(480)
                .duration(100)
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder(HRTMain.id(("gene_plasmids")))
                .inputFluids(Cas_9.getFluid(1000))
                .inputFluids(Myc.getFluid(1000))
                .inputFluids(Oct_4.getFluid(1000))
                .inputFluids(SOX_2.getFluid(1000))
                .inputFluids(KFL_4.getFluid(1000))
                .inputItems(dust, EschericiaColi)
                .outputFluids(GenePlasmids.getFluid(5000))
                .EUt(1920)
                .duration(50)
                .save(provider);

        MIXER_RECIPES.recipeBuilder(HRTMain.id(("chitin_from_red_shroom")))
                .notConsumable(ULTRASONIC_HOMOGENIZER.asStack())
                .inputItems(new ItemStack(Blocks.RED_MUSHROOM, 1))
                .outputFluids(Chitin.getFluid(100))
                .EUt(30)
                .duration(100)
                .save(provider);

        MIXER_RECIPES.recipeBuilder(HRTMain.id(("chitin_from_brown_shroom")))
                .notConsumable(ULTRASONIC_HOMOGENIZER.asStack())
                .inputItems(new ItemStack(Blocks.BROWN_MUSHROOM, 1))
                .outputFluids(Chitin.getFluid(100))
                .EUt(30)
                .duration(100)
                .save(provider);

        BIO_REACTOR_RECIPES.recipeBuilder(HRTMain.id(("chitosan")))
                .inputFluids(Chitin.getFluid(1000))
                .inputItems(dust, BifidobacteriumBreve)
                .outputFluids(Chitosan.getFluid(1000))
                .EUt(120)
                .duration(100)
                .save(provider);

        MIXER_RECIPES.recipeBuilder(HRTMain.id(("gtf")))
                .inputFluids(GenePlasmids.getFluid(1000))
                .inputFluids(Chitosan.getFluid(1000))
                .outputFluids(GeneTherapyFluid.getFluid(2000))
                .EUt(7680)
                .duration(25)
                .save(provider);
    }
}
