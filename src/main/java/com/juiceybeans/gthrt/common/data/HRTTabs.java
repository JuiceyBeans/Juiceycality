package com.juiceybeans.gthrt.common.data;

import com.gregtechceu.gtceu.common.data.GTCreativeModeTabs;
import com.juiceybeans.gthrt.HRTMain;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.world.item.CreativeModeTab;

import static com.gregtechceu.gtceu.common.registry.GTRegistration.REGISTRATE;

public class HRTTabs {
    public static RegistryEntry<CreativeModeTab> HRT_MATERIALS = REGISTRATE.defaultCreativeTab("juiceycality_items",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("juiceycality_items", REGISTRATE))
                            .icon(() -> HRTItems.ULTRASONIC_HOMOGENIZER.asStack())
                            .title(REGISTRATE.addLang("itemGroup", HRTMain.id("juiceycality_items"),  "Juiceycality Materials"))
                            .build())
            .register();
}
