package com.juiceybeans.gthrt.common.data;

import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.common.data.GTMachines;

public class HRTMachines {

    public static final MachineDefinition[] BIO_REACTOR = GTMachines.registerSimpleMachines("bio_reactor", HRTRecipeTypes.BIO_REACTOR_RECIPES);
    public static void init() {

    }
}
