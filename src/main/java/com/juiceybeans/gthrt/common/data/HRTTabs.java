package com.juiceybeans.gthrt.common.data;

import com.gregtechceu.gtceu.common.data.GTCreativeModeTabs;
import com.juiceybeans.gthrt.HRTMain;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.world.item.CreativeModeTab;

import static com.gregtechceu.gtceu.common.registry.GTRegistration.REGISTRATE;

public class HRTTabs {
    public static RegistryEntry<CreativeModeTab> HRT_MATERIALS = REGISTRATE.defaultCreativeTab("gthrt_materials",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("gthrt_materials", REGISTRATE))
                            .icon(() -> HRTItems.ULTRASONIC_HOMOGENIZER.asStack())
                            .title(REGISTRATE.addLang("itemGroup", HRTMain.id("gthrt_materials"),  "GTHRT Material Fluid Containers"))
                            .build())
            .register();
}
