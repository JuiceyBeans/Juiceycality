package com.juiceybeans.juiceycality.common.data;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;

import static com.juiceybeans.juiceycality.JCMain.JC_REGISTRATE;

public class JCItems {

    // Example Registrate item
    // public static ItemEntry<Item> POWER_WASHER = JC_REGISTRATE.item("power_washer", Item::new).lang("Power Washer").register();

    public static ItemEntry<Item> HotIronIngot = JC_REGISTRATE.item("hot_iron_ingot", Item::new).tab(JCTabs.JC_MATERIALS.getKey()).register();
    public static ItemEntry<Item> UltrasonicHomogenizer = JC_REGISTRATE.item("ultrasonic_homogenizer", Item::new).tab(JCTabs.JC_MATERIALS.getKey()).register();
    public static ItemEntry<Item> PiezoelectricCrystal = JC_REGISTRATE.item("piezoelectric_crystal", Item::new).tab(JCTabs.JC_MATERIALS.getKey()).register();
    public static ItemEntry<Item> ContaminatedPetriDish = JC_REGISTRATE.item("contaminated_petri_dish", Item::new).tab(JCTabs.JC_MATERIALS.getKey()).register();
    public static ItemEntry<Item> SterilizedPetriDish = JC_REGISTRATE.item("sterilized_petri_dish", Item::new).tab(JCTabs.JC_MATERIALS.getKey()).register();
    public static void init() {

    }
}
