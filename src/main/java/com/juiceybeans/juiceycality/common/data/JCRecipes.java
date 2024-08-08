package com.juiceybeans.juiceycality.common.data;

import com.juiceybeans.juiceycality.data.recipe.*;
import com.juiceybeans.juiceycality.data.recipe.chain.*;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class JCRecipes {
    public static void init(Consumer<FinishedRecipe> provider) {
        EstrogenChainRecipes.init(provider);
        TestosteroneChainRecipes.init(provider);
        PolycaprolactamChainRecipes.init(provider);
        WetwareChainRecipes.init(provider);
        GoldChainRecipes.init(provider);
        AmmoniaChainRecipes.init(provider);
        CraftingRecipes.init(provider);
        BlockAdjacentTestRecipes.init(provider);
        miscRecipes(provider);
    }

    private static void miscRecipes(Consumer<FinishedRecipe> provider) {
    }
}

