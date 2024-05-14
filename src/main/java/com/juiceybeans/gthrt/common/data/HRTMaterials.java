package com.juiceybeans.gthrt.common.data;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.juiceybeans.gthrt.HRTMain;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.DISABLE_DECOMPOSITION;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.GENERATE_PLATE;

public class HRTMaterials {
    public static void init() {

    }

    /*
    public static final Material name = new Material.Builder(HRTMain.id(""))
            .fluid()
            .color()
            .buildAndRegister()
            .setFormula("");
    */

    // GT-HRT
    public static final Material estradiol = new Material.Builder(HRTMain.id("estradiol"))
            .dust()
            .fluid()
            .color(0x94EEE1).iconSet(MaterialIconSet.BRIGHT)
            .buildAndRegister()
            .setFormula("C18H24O2", true);

    public static final Material testosterone = new Material.Builder(HRTMain.id("testosterone"))
            .dust()
            .fluid()
            .color(0xCB743E).iconSet(MaterialIconSet.BRIGHT)
            .ingot()
            .buildAndRegister()
            .setFormula("C19H28O2", true);

    // Stem cells
    public static final Material animal_cells = new Material.Builder(HRTMain.id("animal_cells"))
            .fluid()
            .color(0xc94996)
            .buildAndRegister()
            .setFormula("???");

    public static final Material gene_therapy_fluid = new Material.Builder(HRTMain.id("gene_therapy_fluid"))
            .fluid()
            .color(0x6b2f66)
            .buildAndRegister()
            .setFormula("?");

    public static final Material gene_plasmids = new Material.Builder(HRTMain.id("gene_plasmids"))
            .fluid()
            .color(0xabe053)
            .buildAndRegister()
            .setFormula("?");

    public static final Material chitin = new Material.Builder(HRTMain.id("chitin"))
            .fluid()
            .color(0xcbd479)
            .buildAndRegister()
            .setFormula("?");

    public static final Material chitosan = new Material.Builder(HRTMain.id("chitosan"))
            .fluid()
            .color(0xb1bd42)
            .buildAndRegister()
            .setFormula("?");

    // Other misc
    public static final Material lead_zirconate_titanate = new Material.Builder(HRTMain.id("lead_zirconate_titanate"))
            .gem()
            .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION)
            .color(0x359ade).iconSet(MaterialIconSet.OPAL)
            .buildAndRegister()
            .setFormula("PbZrTiO3", true);


}
