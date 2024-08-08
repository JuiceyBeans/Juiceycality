package com.juiceybeans.juiceycality.common.data;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.sound.ExistingSoundEntry;
import com.gregtechceu.gtceu.common.data.GTMachines;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.data.GTSoundEntries;
import com.juiceybeans.juiceycality.common.recipe.BlockAdjacentCondition;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;

import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;
import static com.lowdragmc.lowdraglib.gui.texture.ProgressTexture.FillDirection.LEFT_TO_RIGHT;

public class JCRecipeTypes {
    public static final GTRecipeType BIO_REACTOR_RECIPES = GTRecipeTypes.register("bio_reactor", ELECTRIC).setMaxIOSize(3, 3, 3, 2)
            .setSound(GTValues.FOOLS.get() ? GTSoundEntries.SCIENCE : GTSoundEntries.CHEMICAL)
            .setMaxTooltips(4);

    public static final GTRecipeType CHEMICAL_DEHYDRATOR_RECIPES = GTRecipeTypes.register("chemical_dehydrator", ELECTRIC).setMaxIOSize(2, 9, 2, 2)
            .setSound(new ExistingSoundEntry(SoundEvents.SAND_PLACE, SoundSource.BLOCKS))
            .setMaxTooltips(4);

    public static final GTRecipeType LARGE_MIXER_RECIPES = GTRecipeTypes.register("large_mixer", MULTIBLOCK).setMaxIOSize(9, 1, 6, 1).setEUIO(IO.IN)
            .prepareBuilder(recipeBuilder -> recipeBuilder.EUt(GTValues.VA[GTValues.LV]))
            .setSound(GTValues.FOOLS.get() ? GTSoundEntries.SCIENCE : GTSoundEntries.CHEMICAL)
            .setProgressBar(GuiTextures.PROGRESS_BAR_MIXER, LEFT_TO_RIGHT)
            .setSmallRecipeMap(MIXER_RECIPES);

    public final static GTRecipeType BLOCK_ADJACENT_RECIPES = GTRecipeTypes.register("block_adjacent", ELECTRIC).setMaxIOSize(1, 4, 0, 0)
            .setEUIO(IO.IN)
            .setSlotOverlay(false, false, GuiTextures.DUST_OVERLAY)
            .setSlotOverlay(true, false, GuiTextures.CRUSHED_ORE_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_MACERATE, LEFT_TO_RIGHT)
            .setIconSupplier(() -> GTMachines.ROCK_CRUSHER[GTValues.LV].asStack())
            .setSteamProgressBar(GuiTextures.PROGRESS_BAR_MACERATE_STEAM, LEFT_TO_RIGHT)
            .prepareBuilder(recipeBuilder -> recipeBuilder.addCondition(BlockAdjacentCondition.INSTANCE))
            /*.setUiBuilder((recipe, widgetGroup) -> {
                var blockA = BuiltInRegistries.BLOCK.get(new ResourceLocation(recipe.data.getString("blockA")));
                var blockB = BuiltInRegistries.BLOCK.get(new ResourceLocation(recipe.data.getString("blockB")));
                if (blockA != Blocks.AIR) {
                    widgetGroup.addWidget(new TankWidget(new FluidStorage(FluidStack.create(blockA, 1000)),
                            widgetGroup.getSize().width - 30, widgetGroup.getSize().height - 30, false, false)
                            .setBackground(GuiTextures.FLUID_SLOT).setShowAmount(false));
                }
                if (blockB != Blocks.AIR) {
                    widgetGroup.addWidget(new TankWidget(new FluidStorage(FluidStack.create(blockB, 1000)),
                            widgetGroup.getSize().width - 30 - 20, widgetGroup.getSize().height - 30, false, false)
                            .setBackground(GuiTextures.FLUID_SLOT).setShowAmount(false));
                }
            })*/
            .setMaxTooltips(4)
            .setSound(GTSoundEntries.FIRE);


    public static void init() {
    }
}
