package com.juiceybeans.juiceycality.mixin;

import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.juiceybeans.juiceycality.common.data.JCRecipeTypes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(GTRecipeTypes.class)
public class RecipeTypesMixin {
    @Shadow @Final public static GTRecipeType MIXER_RECIPES;
    static  {
        MIXER_RECIPES.onRecipeBuild((recipeBuilder, provider) -> JCRecipeTypes.LARGE_MIXER_RECIPES.copyFrom(recipeBuilder));
    }

    /* Unused, leaving this here for future reference
    @ModifyArg(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(value = "CONSTANT", args = "stringValue=mixer")
            ),
            at = @At(value = "INVOKE",
                    target = "Lcom/gregtechceu/gtceu/api/recipe/GTRecipeType;setMaxIOSize(IIII)Lcom/gregtechceu/gtceu/api/recipe/GTRecipeType;"),
                    index = 0)
    private static int adjustItemsIn(int maxInputs) {
        return 9;
    }

    @ModifyArg(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(value = "CONSTANT", args = "stringValue=mixer")
            ),
            at = @At(value = "INVOKE",
                    target = "Lcom/gregtechceu/gtceu/api/recipe/GTRecipeType;setMaxIOSize(IIII)Lcom/gregtechceu/gtceu/api/recipe/GTRecipeType;"),
            index = 2)
    private static int adjustFluidIn(int maxFluidInputs) {
        return 6;
    }*/
}