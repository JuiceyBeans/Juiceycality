package com.juiceybeans.gthrt.common.data;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.data.GTSoundEntries;

public class HRTRecipeTypes {
    public static final GTRecipeType BIO_REACTOR_RECIPES = GTRecipeTypes.register("bio_reactor", GTRecipeTypes.ELECTRIC).setMaxIOSize(3, 3, 3, 2)
            .prepareBuilder(gtRecipeBuilder -> gtRecipeBuilder.EUt(GTValues.VA[GTValues.HV]))
            .setSound(GTValues.FOOLS.get() ? GTSoundEntries.SCIENCE : GTSoundEntries.CHEMICAL)
            .setMaxTooltips(4);

    public static void init() {
    }
}
