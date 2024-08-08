package com.juiceybeans.juiceycality.common.data;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.juiceybeans.juiceycality.JCMain;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.DISABLE_DECOMPOSITION;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.GENERATE_PLATE;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class JCMaterials {


    public static void init() {

    }

    ////////////
    // GT-HRT //
    ////////////
    public static final Material Estradiol = new Material.Builder(JCMain.id("estradiol"))
            .dust()
            .fluid()
            .color(0x94EEE1).iconSet(MaterialIconSet.BRIGHT)
            .buildAndRegister()
            .setFormula("C18H24O2");

    public static final Material Testosterone = new Material.Builder(JCMain.id("testosterone"))
            .dust()
            .fluid()
            .color(0xCB743E).iconSet(MaterialIconSet.BRIGHT)
            .ingot()
            .buildAndRegister()
            .setFormula("C19H28O2");




    /////////////
    // Fluids //
    ////////////
    public static final Material HydrogenPeroxide = new Material.Builder(JCMain.id("hydrogen_peroxide"))
            .fluid()
            .color(0xD1FFFF).iconSet(MaterialIconSet.FLUID)
            .flags(DISABLE_DECOMPOSITION)
            .buildAndRegister()
            .setFormula("H2O2");




    ///////////////////
    // Simple Fluids //
    ///////////////////
    public static final Material AmmoniumNitrate = new Material.Builder(JCMain.id("ammonium_nitrate"))
            .fluid()
            .color(Ammonia.getMaterialRGB())
            .buildAndRegister()
            .setFormula("NH4NO3");
    public static final Material Turpentine = new Material.Builder(JCMain.id("turpentine"))
            .fluid()
            .color(0x93bd46)
            .buildAndRegister()
            .setFormula("C10H16");
    public static final Material Acetylene = new Material.Builder(JCMain.id("acetylene"))
            .fluid()
            .color(0x959c60)
            .buildAndRegister()
            .setFormula("C2H2");
    public static final Material PropargylAlcohol = new Material.Builder(JCMain.id("propargyl_alcohol"))
            .fluid()
            .color(0xbfb32a)
            .buildAndRegister()
            .setFormula("CHCCH2OH");
    public static final Material PropargylChloride = new Material.Builder(JCMain.id("propargyl_chloride"))
            .fluid()
            .color(0x918924)
            .buildAndRegister()
            .setFormula("HC2CH2Cl");
    public static final Material Citral = new Material.Builder(JCMain.id("citral"))
            .fluid()
            .color(0xf2e541)
            .buildAndRegister()
            .setFormula("C10H16O");
    public static final Material BetaIonone = new Material.Builder(JCMain.id("beta_ionone"))
            .fluid()
            .color(0xdc5ce6)
            .buildAndRegister()
            .setFormula("C13H20O");
    public static final Material VitaminA = new Material.Builder(JCMain.id("vitamin_a"))
            .fluid()
            .color(0x8d5c91)
            .buildAndRegister()
            .setFormula("C20H30O");
    public static final Material LinoleicAcid = new Material.Builder(JCMain.id("linoleic_acid"))
            .fluid()
            .color(0xD5D257)
            .buildAndRegister()
            .setFormula("C18H32O2");
    public static final Material EthyleneOxide = new Material.Builder(JCMain.id("ethylene_oxide"))
            .fluid()
            .color(0xa0c3de)
            .buildAndRegister()
            .setFormula("C2H4O");
    public static final Material Ethanolamine = new Material.Builder(JCMain.id("ethanolamine"))
            .fluid()
            .color(0x6f7d87)
            .buildAndRegister()
            .setFormula("HOCH2CH2NH2");
    public static final Material Biotin = new Material.Builder(JCMain.id("biotin"))
            .fluid()
            .color(0x68cc6a)
            .buildAndRegister()
            .setFormula("C10H16N2O3S");
    public static final Material B27Supplement = new Material.Builder(JCMain.id("b_27"))
            .fluid()
            .color(0x386939)
            .buildAndRegister()
            .setFormula("C142H230N36O44S");
    public static final Material CleanAmmoniaSolution = new Material.Builder(JCMain.id("clean_ammonia_solution"))
            .fluid()
            .color(0x53c9a0)
            .buildAndRegister()
            .setFormula("NH3(H2O)");
    public static final Material Catalase = new Material.Builder(JCMain.id("catalase"))
            .fluid()
            .color(0xdb6596)
            .buildAndRegister()
            .setFormula("?");
    public static final Material Blood = new Material.Builder(JCMain.id("blood"))
            .fluid()
            .color(0x5c0606)
            .buildAndRegister()
            .setFormula("Blood");
    public static final Material BloodCells = new Material.Builder(JCMain.id("blood_cells"))
            .fluid()
            .color(0xad2424)
            .buildAndRegister()
            .setFormula("???");
    public static final Material BloodPlasma = new Material.Builder(JCMain.id("blood_plasma"))
            .fluid()
            .color(0xe37171)
            .buildAndRegister()
            .setFormula("???");
    public static final Material BFGF = new Material.Builder(JCMain.id("bfgf"))
            .fluid()
            .color(0xb365e0)
            .buildAndRegister()
            .setFormula("bFGF");
    public static final Material EGF = new Material.Builder(JCMain.id("egf"))
            .fluid()
            .color(0xb365e0)
            .buildAndRegister()
            .setFormula("C257H381N73O83S7");
    public static final Material Aniline = new Material.Builder(JCMain.id("aniline"))
            .fluid()
            .color(0x4c911d)
            .buildAndRegister()
            .setFormula("C6H5NH2");
    public static final Material ChlorosulfonicAcid = new Material.Builder(JCMain.id("chlorosulfonic_acid"))
            .fluid()
            .color(0x916c1d)
            .buildAndRegister()
            .setFormula("HSO3Cl");
    public static final Material Sulfanilamide = new Material.Builder(JCMain.id("sulfanilamide"))
            .fluid()
            .color(0x523b0a)
            .buildAndRegister()
            .setFormula("C6H8N2O2S");
    public static final Material SilicaGelBase = new Material.Builder(JCMain.id("silica_gel_base"))
            .fluid()
            .color(0xb365e0)
            .buildAndRegister()
            .setFormula("C257H381N73O83S7");
    public static final Material Ethanol_100 = new Material.Builder(JCMain.id("ethanol_100"))
            .fluid()
            .color(Ethanol.getMaterialRGB())
            .buildAndRegister()
            .setFormula("C2H5OH");
    public static final Material PiranhaSolution = new Material.Builder(JCMain.id("piranha_solution"))
            .fluid()
            .color(0x4820ab)
            .buildAndRegister()
            .setFormula("(H2SO4)H2O2");
    public static final Material BacterialGrowthMedium = new Material.Builder(JCMain.id("bacterial_growth_medium"))
            .fluid()
            .color(0x0b2e12)
            .buildAndRegister()
            .setFormula("For Bacteria");
    public static final Material DepletedGrowthMedium = new Material.Builder(JCMain.id("depleted_growth_medium"))
            .fluid()
            .color(0x071209)
            .buildAndRegister()
            .setFormula("Depleted");
    public static final Material AnimalCells = new Material.Builder(JCMain.id("animal_cells"))
            .fluid()
            .color(0xc94996)
            .buildAndRegister()
            .setFormula("???");
    public static final Material GenePlasmids = new Material.Builder(JCMain.id("gene_plasmids"))
            .fluid()
            .color(0xabe053)
            .buildAndRegister()
            .setFormula("?");
    public static final Material Chitin = new Material.Builder(JCMain.id("chitin"))
            .fluid()
            .color(0xcbd479)
            .buildAndRegister()
            .setFormula("?");
    public static final Material Chitosan = new Material.Builder(JCMain.id("chitosan"))
            .fluid()
            .color(0xb1bd42)
            .buildAndRegister()
            .setFormula("?");
    public static final Material GeneTherapyFluid = new Material.Builder(JCMain.id("gene_therapy_fluid"))
            .fluid()
            .color(0x6b2f66)
            .buildAndRegister()
            .setFormula("?");
    public static final Material Resin = new Material.Builder(JCMain.id("resin"))
            .fluid()
            .color(0x3d2f11)
            .buildAndRegister()
            .setFormula("?");
    public static final Material RapidlyReplicatingAnimalCells = new Material.Builder(JCMain.id("rapidly_replicating_animal_cells"))
            .fluid()
            .color(0x7a335e)
            .buildAndRegister()
            .setFormula("????");
    public static final Material Myc = new Material.Builder(JCMain.id("myc"))
            .fluid()
            .color(0x445724)
            .buildAndRegister()
            .setFormula("?");
    public static final Material Oct_4 = new Material.Builder(JCMain.id("oct_4"))
            .fluid()
            .color(0x374f0d)
            .buildAndRegister()
            .setFormula("?");
    public static final Material SOX_2 = new Material.Builder(JCMain.id("sox_2"))
            .fluid()
            .color(0x5d8714)
            .buildAndRegister()
            .setFormula("?");
    public static final Material KFL_4 = new Material.Builder(JCMain.id("kfl_4"))
            .fluid()
            .color(0x759143)
            .buildAndRegister()
            .setFormula("?");
    public static final Material Cas_9 = new Material.Builder(JCMain.id("cas_9"))
            .fluid()
            .color(0x5f6e46)
            .buildAndRegister()
            .setFormula("?");
    public static final Material RichNitrogenMix = new Material.Builder(JCMain.id("rich_nitrogen_mix"))
            .fluid()
            .color(0x6891d8)
            .buildAndRegister()
            .setFormula("H2O(CH4)?");
    public static final Material OxidisedNitrogenMix = new Material.Builder(JCMain.id("oxidised_nitrogen_mix"))
            .fluid()
            .color(0x708ACD)
            .buildAndRegister()
            .setFormula("(H2O)2(CH4)??");
    public static final Material PurifiedNitrogenMix = new Material.Builder(JCMain.id("purified_nitrogen_mix"))
            .fluid()
            .color(0x6891d8)
            .buildAndRegister()
            .setFormula("(H2O)2(CH4)?");
        public static final Material CarbonatedEthanolamine = new Material.Builder(JCMain.id("carbonated_ethanolamine"))
            .fluid()
            .color(0x6f7d87)
            .buildAndRegister()
            .setFormula("H2NCH2CH2OHC");
    public static final Material AmmoniaRichMix = new Material.Builder(JCMain.id("ammonia_rich_mix"))
            .fluid()
            .color(0x2f5d99)
            .buildAndRegister()
            .setFormula("NH3((H2O)2(CH4)?");
    public static final Material AcetylsulfanilylChloride = new Material.Builder(JCMain.id("acetylsulfanilyl_chloride"))
            .fluid()
            .color((Aniline.getMaterialRGB() + AceticAnhydride.getMaterialRGB() + ChlorosulfonicAcid.getMaterialRGB())/3)
            .buildAndRegister()
            .setFormula("(CH3CO)2O");
    public static final Material ChloroauricAcid = new Material.Builder(JCMain.id("chloroauric_acid"))
            .fluid()
            .color(0xDFD11F)
            .buildAndRegister()
            .setFormula("HAuCl?");




    //////////////////
    // Simple dusts //
    //////////////////
    public static final Material BetaPinene = new Material.Builder(JCMain.id("beta_pinene"))
            .dust()
            .color(0x61ad6b).iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("C10H16");
    public static final Material Yeast = new Material.Builder(JCMain.id("yeast"))
            .dust()
            .color(0xf0e660).iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("???");
    public static final Material Glutamine = new Material.Builder(JCMain.id("glutamine"))
            .dust()
            .color(0xede9b4).iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("C5H10N2O3");
    public static final Material SilicaGel = new Material.Builder(JCMain.id("silica_gel"))
            .dust()
            .color(0x61daff).iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("SiO2");
    public static final Material SilicaAluminaGel = new Material.Builder(JCMain.id("silica_alumina_gel"))
            .dust()
            .color(0x558d9e).iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("Al2O3SiO2");
    public static final Material ZeoliteSievingPellets = new Material.Builder(JCMain.id("zeolite_sieving_pellets"))
            .dust()
            .color(0xa17bd1).iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("Al2O3SiO2");
    public static final Material WetZeoliteSievingPellets = new Material.Builder(JCMain.id("wet_zeolite_sieving_pellets"))
            .dust()
            .color(0x392f45).iconSet(MaterialIconSet.METALLIC)
            .buildAndRegister()
            .setFormula("Al2O3SiO2?");
    public static final Material Alumina = new Material.Builder(JCMain.id("alumina"))
            .dust()
            .color(0x0b585c).iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("Al2O3");
    public static final Material CupriavidusNecator = new Material.Builder(JCMain.id("cupriavidus_necator"))
            .dust()
            .color(0x22704f).iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("Bacteria");
    public static final Material BrevibacteriumFlavium = new Material.Builder(JCMain.id("brevibacterium_flavium"))
            .dust()
            .color(0x2c4d24).iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("Bacteria");
    public static final Material StreptococcusPyogenes = new Material.Builder(JCMain.id("streptococcus_pyogenes"))
            .dust()
            .color(0x1c3b15).iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("Bacteria");
    public static final Material EschericiaColi = new Material.Builder(JCMain.id("eschericia_coli"))
            .dust()
            .color(0x2d4228).iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("Bacteria");
    public static final Material BifidobacteriumBreve = new Material.Builder(JCMain.id("bifidobacterium_breve"))
            .dust()
            .color(0x377528).iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("Bacteria");
    public static final Material NiAlOCatalyst = new Material.Builder(JCMain.id("nialo_catalyst"))
            .dust()
            .color(0x0af0af).iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("NiAl2O4");
    public static final Material FeCrOCatalyst = new Material.Builder(JCMain.id("fecro_catalyst"))
            .dust()
            .color(0x8C4517).iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("FeCrO3");
    public static final Material CopperLeach = new Material.Builder(JCMain.id("copper_leach"))
            .dust()
            .color(0x765A30).iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("Cu3?");
    public static final Material GoldLeach = new Material.Builder(JCMain.id("gold_leach"))
            .dust()
            .color(0xBBA52B).iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister()
            .setFormula("Cu3Au?");
    public static final Material PotassiumMetabisulfite = new Material.Builder(JCMain.id("potassium_metabisulfite"))
            .dust()
            .color(0xFFFFFF).iconSet(MaterialIconSet.DULL)
            .buildAndRegister()
            .setFormula("K2S2O5");





    ///////////////////
    // Gem materials //
    ///////////////////
    public static final Material LeadZirconateTitanate = new Material.Builder(JCMain.id("lead_zirconate_titanate"))
            .gem()
            .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION)
            .color(0x359ade).iconSet(MaterialIconSet.OPAL)
            .buildAndRegister()
            .setFormula("PbZrTiO3");





    /////////////////////
    // Ingot materials //
    /////////////////////
    public static final Material GoldAlloy = new Material.Builder(JCMain.id("gold_alloy"))
            .ingot().ore()
            .flags(DISABLE_DECOMPOSITION)
            .color(0xBBA52B).iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("Cu3Au?");
    public static final Material PreciousMetal = new Material.Builder(JCMain.id("precious_metal"))
            .ingot().ore()
            .flags(DISABLE_DECOMPOSITION)
            .color((Ruthenium.getMaterialRGB() + Rhodium.getMaterialRGB() + Palladium.getMaterialRGB() + Silver.getMaterialRGB() + Rhenium.getMaterialRGB() + Osmium.getMaterialRGB() + Iridium.getMaterialRGB() + Platinum.getMaterialRGB() + Gold.getMaterialRGB())/9).iconSet(MaterialIconSet.SHINY)
            .buildAndRegister()
            .setFormula("RuRhPdAgReOsIrPtAu");
}