package com.juiceybeans.juiceycality.mixin;

import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.data.machines.GCyMMachines;
import com.juiceybeans.juiceycality.common.data.JCRecipeTypes;
import org.spongepowered.asm.mixin.Mixin;

import static com.gregtechceu.gtceu.common.data.machines.GCyMMachines.LARGE_MIXER;

@Mixin(GCyMMachines.class)
public class GCyMMixin {
    static {
        LARGE_MIXER.setRecipeTypes(new com.gregtechceu.gtceu.api.recipe.GTRecipeType[]{JCRecipeTypes.LARGE_MIXER_RECIPES, GTRecipeTypes.MIXER_RECIPES});
    }
}
