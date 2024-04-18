package com.juiceybeans.gthrt.common.data;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.*;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.juiceybeans.gthrt.HRTMain;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class HRTMaterials {
    public static void init() {

    }
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
            .buildAndRegister()
            .setFormula("C19H28O2", true);

}
