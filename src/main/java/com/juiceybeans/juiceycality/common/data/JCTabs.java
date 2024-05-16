package com.juiceybeans.juiceycality.common.data;

import com.gregtechceu.gtceu.common.data.GTCreativeModeTabs;
import com.juiceybeans.juiceycality.JCMain;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.world.item.CreativeModeTab;

import static com.juiceybeans.juiceycality.JCMain.JC_REGISTRATE;

public class JCTabs {
    public static RegistryEntry<CreativeModeTab> JC_MATERIALS = JC_REGISTRATE.defaultCreativeTab("juiceycality_items",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("juiceycality_items", JC_REGISTRATE))
                            .icon(() -> JCItems.UltrasonicHomogenizer.asStack())
                            .title(JC_REGISTRATE.addLang("itemGroup", JCMain.id("juiceycality_items"),  "Juiceycality Materials"))
                            .build())
            .register();

    static {
        JC_REGISTRATE.creativeModeTab(() -> JCTabs.JC_MATERIALS);
    }

    public static void init() {

    }
}
