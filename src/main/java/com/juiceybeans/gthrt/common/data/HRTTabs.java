package com.juiceybeans.gthrt.common.data;

import com.gregtechceu.gtceu.common.data.GTCreativeModeTabs;
import com.juiceybeans.gthrt.HRTMain;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.world.item.CreativeModeTab;

import static com.juiceybeans.gthrt.HRTMain.HRT_REGISTRATE;

public class HRTTabs {
    public static RegistryEntry<CreativeModeTab> HRT_MATERIALS = HRT_REGISTRATE.defaultCreativeTab("juiceycality_items",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("juiceycality_items", HRT_REGISTRATE))
                            .icon(() -> HRTItems.ULTRASONIC_HOMOGENIZER.asStack())
                            .title(HRT_REGISTRATE.addLang("itemGroup", HRTMain.id("juiceycality_items"),  "Juiceycality Materials"))
                            .build())
            .register();

    static {
        HRT_REGISTRATE.creativeModeTab(() -> HRTTabs.HRT_MATERIALS);
    }

    public static void init() {

    }
}
