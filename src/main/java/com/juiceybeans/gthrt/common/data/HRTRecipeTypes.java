package com.juiceybeans.gthrt.common.data;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.sound.ExistingSoundEntry;
import com.gregtechceu.gtceu.api.sound.SoundEntry;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.data.GTSoundEntries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;

public class HRTRecipeTypes {
    public static final GTRecipeType BIO_REACTOR_RECIPES = GTRecipeTypes.register("bio_reactor", GTRecipeTypes.ELECTRIC).setMaxIOSize(3, 3, 3, 2)
            .setSound(GTValues.FOOLS.get() ? GTSoundEntries.SCIENCE : GTSoundEntries.CHEMICAL)
            .setMaxTooltips(4);

    public static final GTRecipeType CHEMICAL_DEHYDRATOR_RECIPES = GTRecipeTypes.register("chemical_dehydrator", GTRecipeTypes.ELECTRIC).setMaxIOSize(2, 9, 2, 2)
            .setSound(new ExistingSoundEntry(SoundEvents.SAND_PLACE, SoundSource.BLOCKS))
            .setMaxTooltips(4);

    public static final GTRecipeType LARGE_MIXER_RECIPES = GTRecipeTypes.register("large_mixer", GTRecipeTypes.ELECTRIC).setMaxIOSize(9, 1, 6, 1)
            .setSound(GTSoundEntries.MIXER)
            .setMaxTooltips(4);

    public static void init() {
    }
}
