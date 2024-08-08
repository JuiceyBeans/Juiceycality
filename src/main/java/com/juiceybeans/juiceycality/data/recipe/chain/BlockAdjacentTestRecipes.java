package com.juiceybeans.juiceycality.data.recipe.chain;

import com.juiceybeans.juiceycality.JCMain;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.ULV;
import static com.gregtechceu.gtceu.api.GTValues.VA;
import static com.juiceybeans.juiceycality.common.data.JCRecipeTypes.BLOCK_ADJACENT_RECIPES;

public class BlockAdjacentTestRecipes {
    public static void init(Consumer<FinishedRecipe> provider) {
        blockAdjacentTestRecipes(provider);
    }

    private static void blockAdjacentTestRecipes(Consumer<FinishedRecipe> provider) {
        BLOCK_ADJACENT_RECIPES.recipeBuilder(JCMain.id(("sculk")))
                .notConsumable(Blocks.SCULK.asItem())
                .outputItems(Blocks.SCULK.asItem())
                .duration(16)
                .EUt(VA[ULV])
                .addData("blockA", "minecraft:sculk_catalyst")
                .addData("blockB", "minecraft:stone")
                .save(provider);

    }
}
