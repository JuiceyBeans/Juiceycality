package com.juiceybeans.gthrt.common.data;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;

import static com.juiceybeans.gthrt.HRTMain.HRT_REGISTRATE;

public class HRTItems {

    // Example Registrate item
    // public static ItemEntry<Item> POWER_WASHER_2 = HRTMain.HRT_REGISTRATE.item("power_washer", Item::new).lang("Power Washer").register();

    public static ItemEntry<Item> HotIronIngot = HRT_REGISTRATE.item("hot_iron_ingot", Item::new).tab(HRTTabs.HRT_MATERIALS.getKey()).register();
    public static ItemEntry<Item> UltrasonicHomogenizer = HRT_REGISTRATE.item("ultrasonic_homogenizer", Item::new).tab(HRTTabs.HRT_MATERIALS.getKey()).register();
    public static ItemEntry<Item> PiezoelectricCrystal = HRT_REGISTRATE.item("piezoelectric_crystal", Item::new).tab(HRTTabs.HRT_MATERIALS.getKey()).register();
    public static ItemEntry<Item> ContaminatedPetriDish = HRT_REGISTRATE.item("contaminated_petri_dish", Item::new).tab(HRTTabs.HRT_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SterilizedPetriDish = HRT_REGISTRATE.item("sterilized_petri_dish", Item::new).tab(HRTTabs.HRT_MATERIALS.getKey()).register();
    public static void init() {

    }
}
