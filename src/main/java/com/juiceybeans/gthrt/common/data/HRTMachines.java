package com.juiceybeans.gthrt.common.data;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.SimpleTieredMachine;
import com.gregtechceu.gtceu.api.recipe.OverclockingLogic;
import com.gregtechceu.gtceu.common.data.GTMachines;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.lowdragmc.lowdraglib.side.fluid.FluidHelper;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.common.data.GTMachines.defaultTankSizeFunction;
import static com.gregtechceu.gtceu.common.data.GTMachines.workableTiered;

public class HRTMachines {

    public static final MachineDefinition[] BIO_REACTOR = GTMachines.registerTieredMachines("bio_reactor", (holder, tier) -> new SimpleTieredMachine(holder, tier, defaultTankSizeFunction), (tier, builder) -> builder
            .langValue("%s Small Bio Reactor %s".formatted(VLVH[tier], VLVT[tier]))
            .editableUI(SimpleTieredMachine.EDITABLE_UI_CREATOR.apply(GTCEu.id("macerator"), GTRecipeTypes.MACERATOR_RECIPES))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(HRTRecipeTypes.BIO_REACTOR_RECIPES)
            .recipeModifier(GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.NON_PERFECT_OVERCLOCK))
            .workableTieredHullRenderer(GTCEu.id("block/machines/chemical_reactor"))
            .tooltips(workableTiered(tier, GTValues.V[tier], GTValues.V[tier] * 64, HRTRecipeTypes.BIO_REACTOR_RECIPES, defaultTankSizeFunction.apply(tier), false))
            .compassNode("bio_reactor")
            .register(), GTValues.tiersBetween(HV, IV));
    public static final MachineDefinition[] CHEMICAL_DEHYDRATOR = GTMachines.registerSimpleMachines("chemical_dehydrator", HRTRecipeTypes.CHEMICAL_DEHYDRATOR_RECIPES);
    public static void init() {

    }
}
