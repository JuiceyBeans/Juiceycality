package com.juiceybeans.gthrt.mixin;

import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.data.machines.GCyMMachines;
import com.juiceybeans.gthrt.common.data.HRTRecipeTypes;
import org.spongepowered.asm.mixin.Mixin;

import static com.gregtechceu.gtceu.common.data.machines.GCyMMachines.LARGE_MIXER;

@Mixin(GCyMMachines.class)
public class GCyMMixin {
    static {
        LARGE_MIXER.setRecipeTypes(new com.gregtechceu.gtceu.api.recipe.GTRecipeType[]{HRTRecipeTypes.LARGE_MIXER_RECIPES, GTRecipeTypes.MIXER_RECIPES});
    }
}
