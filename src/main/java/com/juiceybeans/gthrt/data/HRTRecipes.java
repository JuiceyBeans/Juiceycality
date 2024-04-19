package com.juiceybeans.gthrt.data;

import com.juiceybeans.gthrt.data.recipe.EstrogenChainRecipes;
import com.juiceybeans.gthrt.data.recipe.TestosteroneChainRecipes;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class HRTRecipes {
    public static void init(Consumer<FinishedRecipe> provider) {
        EstrogenChainRecipes.init(provider);
        TestosteroneChainRecipes.init(provider);
    }
}
