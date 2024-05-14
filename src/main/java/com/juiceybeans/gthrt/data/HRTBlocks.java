package com.juiceybeans.gthrt.data;

import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;

import static com.juiceybeans.gthrt.HRTMain.HRT_REGISTRATE;

public class HRTBlocks {
    public static BlockEntry<Block> BorosilicateGlass = HRT_REGISTRATE.block("borosilicate_glass", Block::new).simpleItem().lang("Borosilicate Reinforced Glass").register();
    public static BlockEntry<Block> NickelGlass = HRT_REGISTRATE.block("nickel_glass", Block::new).simpleItem().lang("Nickel Reinforced Glass").register();
    public static BlockEntry<Block> ChromeGlass = HRT_REGISTRATE.block("chrome_glass", Block::new).simpleItem().lang("Chrome Reinforced Glass").register();

    public static void init() {
    }
}
