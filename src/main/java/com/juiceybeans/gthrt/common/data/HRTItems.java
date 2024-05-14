package com.juiceybeans.gthrt.common.data;

import com.juiceybeans.gthrt.HRTMain;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class HRTItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, HRTMain.MOD_ID);

    // Example Registrate item
    // public static ItemEntry<Item> POWER_WASHER_2 = HRTMain.HRT_REGISTRATE.item("power_washer", Item::new).lang("Power Washer").register();

    public static ItemEntry<Item> HOT_IRON_INGOT = HRTMain.HRT_REGISTRATE.item("hot_iron_ingot", Item::new).tab(HRTTabs.HRT_MATERIALS.getKey()).register();
    public static ItemEntry<Item> ULTRASONIC_HOMOGENIZER = HRTMain.HRT_REGISTRATE.item("ultrasonic_homogenizer", Item::new).tab(HRTTabs.HRT_MATERIALS.getKey()).register();
    public static ItemEntry<Item> PIEZOELECTRIC_CRYSTAL = HRTMain.HRT_REGISTRATE.item("piezoelectric_crystal", Item::new).tab(HRTTabs.HRT_MATERIALS.getKey()).register();
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
