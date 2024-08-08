package com.juiceybeans.juiceycality.common.data;

import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.juiceybeans.juiceycality.common.recipe.BlockAdjacentCondition;

public class JCRecipeConditions {

    private JCRecipeConditions() {}

    public static void init() {
        GTRegistries.RECIPE_CONDITIONS.register(BlockAdjacentCondition.INSTANCE.getType(), BlockAdjacentCondition.class);
    }
}