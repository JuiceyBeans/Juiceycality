package com.juiceybeans.juiceycality.common.data;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.SimpleTieredMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.recipe.OverclockingLogic;
import com.gregtechceu.gtceu.api.registry.registrate.MachineBuilder;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import com.juiceybeans.juiceycality.JCMain;
import it.unimi.dsi.fastutil.ints.Int2LongFunction;
import net.minecraft.network.chat.Component;

import java.util.Locale;
import java.util.function.BiFunction;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.pattern.Predicates.blocks;
import static com.gregtechceu.gtceu.common.data.GTMachines.*;
import static com.gregtechceu.gtceu.common.registry.GTRegistration.REGISTRATE;
import static com.gregtechceu.gtceu.utils.FormattingUtil.toEnglishName;

public class JCMachines {

    // Singleblock Machines
    public static final MachineDefinition[] BIO_REACTOR = JCMachines.registerTieredMachines("bio_reactor", (holder, tier) -> new SimpleTieredMachine(holder, tier, defaultTankSizeFunction), (tier, builder) -> builder
            .langValue("%s Small Bio Reactor %s".formatted(VLVH[tier], VLVT[tier]))
            .editableUI(SimpleTieredMachine.EDITABLE_UI_CREATOR.apply(GTCEu.id("bio_reactor"), JCRecipeTypes.BIO_REACTOR_RECIPES))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(JCRecipeTypes.BIO_REACTOR_RECIPES)
            .recipeModifier(GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.NON_PERFECT_OVERCLOCK))
            .workableTieredHullRenderer(GTCEu.id("block/machines/chemical_reactor"))
            .tooltips(workableTiered(tier, GTValues.V[tier], GTValues.V[tier] * 64, JCRecipeTypes.BIO_REACTOR_RECIPES, defaultTankSizeFunction.apply(tier), false))
            .compassNode("bio_reactor")
            .register(), GTValues.tiersBetween(HV, IV));
    public static final MachineDefinition[] CHEMICAL_DEHYDRATOR = JCMachines.registerSimpleMachines("chemical_dehydrator", JCRecipeTypes.CHEMICAL_DEHYDRATOR_RECIPES);

    public static final MachineDefinition[] BLOCK_ADJACENT = JCMachines.registerTieredMachines("block_adjacent",
            (holder, tier) -> new SimpleTieredMachine(holder, tier, defaultTankSizeFunction), (tier, builder) -> builder
                    .langValue("%s Block Adjacent Tester %s".formatted(VLVH[tier], VLVT[tier]))
                    .editableUI(SimpleTieredMachine.EDITABLE_UI_CREATOR.apply(GTCEu.id("block_adjacent"),
                            JCRecipeTypes.BLOCK_ADJACENT_RECIPES))
                    .rotationState(RotationState.NON_Y_AXIS)
                    .recipeType(JCRecipeTypes.BLOCK_ADJACENT_RECIPES)
                    .recipeModifier(GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.NON_PERFECT_OVERCLOCK))
                    .workableTieredHullRenderer(GTCEu.id("block/machines/block_adjacent"))
                    .tooltips(workableTiered(tier, GTValues.V[tier], GTValues.V[tier] * 64,
                            JCRecipeTypes.BLOCK_ADJACENT_RECIPES, defaultTankSizeFunction.apply(tier), true))
                    .tooltips(explosion())
                    .register(),
            ELECTRIC_TIERS);

    // Multiblock Machines
    public static final MachineDefinition LARGE_BIO_REACTOR = REGISTRATE.multiblock("large_bio_reactor", WorkableElectricMultiblockMachine::new)
            .langValue("Large Bio Reactor")
            .tooltips(Component.translatable("gtceu.multiblock.parallelizable.tooltip"))
            .tooltips(Component.translatable("gtceu.machine.available_recipe_map_1.tooltip", Component.translatable("gtceu.bio_reactor")))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(JCRecipeTypes.BIO_REACTOR_RECIPES)
            .recipeModifiers(GTRecipeModifiers.PARALLEL_HATCH, GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.NON_PERFECT_OVERCLOCK))
            .appearanceBlock(JCBlocks.BiologicallySterileCasing)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("XXXXX", "XGGGX", "XGGGX", "XGGGX", "XXXXX")
                    .aisle("XXXXX", "G###G", "G#s#G", "G###G", "XXXXX")
                    .aisle("XXXXX", "G#P#G", "GEFEG", "G#P#G", "XXXXX")
                    .aisle("XXXXX", "G###G", "G#s#G", "G###G", "XXXXX")
                    .aisle("XXSXX", "XGGGX", "XGGGX", "XGGGX", "XXXXX")
                    .where('S', Predicates.controller(blocks(definition.getBlock())))
                    .where('F', Predicates.blocks(JCBlocks.FieldGeneratorCasingUV.get()))
                    .where('E', Predicates.blocks(JCBlocks.EmitterCasingUV.get()))
                    .where('s', Predicates.blocks(JCBlocks.SensorCasingUV.get()))
                    .where('P', Predicates.blocks(JCBlocks.PumpCasingUV.get()))
                    .where('G', Predicates.blocks(JCBlocks.OsmiridiumGlass.get()))
                    .where('#', Predicates.air())
                    .where('X', blocks(JCBlocks.BiologicallySterileCasing.get()).setMinGlobalLimited(34)
                            .or(Predicates.autoAbilities(definition.getRecipeTypes()))
                            .or(Predicates.autoAbilities(true, false, true)))
                    .build())
            .workableCasingRenderer(JCMain.id("block/casings/solid/biologically_sterile_machine_casing"),
                    GTCEu.id("block/machines/large_chemical_reactor"), false)
            .register();

    // Builder functions
    // Note: Machines need to be registered to your namespace instead of GTMachines
    public static void init() {}

    public static MachineDefinition[] registerSimpleMachines(String name,
                                                             GTRecipeType recipeType,
                                                             Int2LongFunction tankScalingFunction,
                                                             int... tiers) {
        return registerTieredMachines(name, (holder, tier) -> new SimpleTieredMachine(holder, tier, tankScalingFunction), (tier, builder) -> builder
                .langValue("%s %s %s".formatted(VLVH[tier], toEnglishName(name), VLVT[tier]))
                .editableUI(SimpleTieredMachine.EDITABLE_UI_CREATOR.apply(GTCEu.id(name), recipeType))
                .rotationState(RotationState.NON_Y_AXIS)
                .recipeType(recipeType)
                .recipeModifier(GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.NON_PERFECT_OVERCLOCK))
                .workableTieredHullRenderer(GTCEu.id("block/machines/" + name))
                .tooltips(workableTiered(tier, GTValues.V[tier], GTValues.V[tier] * 64, recipeType, tankScalingFunction.apply(tier), true))
                .compassNode(name)
                .register(), tiers);
    }

    public static MachineDefinition[] registerTieredMachines(String name,
                                                             BiFunction<IMachineBlockEntity, Integer, MetaMachine> factory,
                                                             BiFunction<Integer, MachineBuilder<MachineDefinition>, MachineDefinition> builder,
                                                             int... tiers) {
        MachineDefinition[] definitions = new MachineDefinition[GTValues.TIER_COUNT];
        for (int tier : tiers) {
            var register = REGISTRATE.machine(GTValues.VN[tier].toLowerCase(Locale.ROOT) + "_" + name, holder -> factory.apply(holder, tier))
                    .tier(tier);
            definitions[tier] = builder.apply(tier, register);
        }
        return definitions;
    }

    public static MachineDefinition[] registerSimpleMachines(String name, GTRecipeType recipeType, Int2LongFunction tankScalingFunction) {
        return registerSimpleMachines(name, recipeType, tankScalingFunction, ELECTRIC_TIERS);
    }

    public static MachineDefinition[] registerSimpleMachines(String name, GTRecipeType recipeType) {
        return registerSimpleMachines(name, recipeType, defaultTankSizeFunction);
    }
}
