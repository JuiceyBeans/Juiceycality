package com.juiceybeans.gthrt.common.data;

import com.juiceybeans.gthrt.data.recipe.*;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class HRTRecipes {
    public static void init(Consumer<FinishedRecipe> provider) {
        EstrogenChainRecipes.init(provider);
        TestosteroneChainRecipes.init(provider);
        PolycaprolactamChainRecipes.init(provider);
        WetwareChainRecipes.init(provider);
        miscRecipes(provider);
    }

    private static void miscRecipes(Consumer<FinishedRecipe> provider) {
    }
}

