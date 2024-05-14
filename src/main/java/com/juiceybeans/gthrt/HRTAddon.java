package com.juiceybeans.gthrt;

import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.juiceybeans.gthrt.common.data.HRTRecipes;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

@SuppressWarnings("unused")
@com.gregtechceu.gtceu.api.addon.GTAddon
public class HRTAddon implements IGTAddon {
    @Override
    public GTRegistrate getRegistrate() {
        return HRTMain.HRT_REGISTRATE;
    }

    @Override
    public void initializeAddon() {

    }

    @Override
    public String addonModId() {
        return HRTMain.MOD_ID;
    }

    @Override
    public void registerTagPrefixes() {
        //CustomTagPrefixes.init();
    }

    @Override
    public void addRecipes(Consumer<FinishedRecipe> provider) {
        HRTRecipes.init(provider);
    }

    // If you have custom ingredient types, uncomment this & change to match your capability.
    // KubeJS WILL REMOVE YOUR RECIPES IF THESE ARE NOT REGISTERED.
    /*
    public static final ContentJS<Double> PRESSURE_IN = new ContentJS<>(NumberComponent.ANY_DOUBLE, GregitasRecipeCapabilities.PRESSURE, false);
    public static final ContentJS<Double> PRESSURE_OUT = new ContentJS<>(NumberComponent.ANY_DOUBLE, GregitasRecipeCapabilities.PRESSURE, true);

    @Override
    public void registerRecipeKeys(KJSRecipeKeyEvent event) {
        event.registerKey(CustomRecipeCapabilities.PRESSURE, Pair.of(PRESSURE_IN, PRESSURE_OUT));
    }
    */
}
