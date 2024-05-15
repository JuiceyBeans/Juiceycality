package com.juiceybeans.gthrt.common.data;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.block.RendererBlock;
import com.gregtechceu.gtceu.api.block.RendererGlassBlock;
import com.gregtechceu.gtceu.api.data.tag.TagUtil;
import com.gregtechceu.gtceu.api.item.RendererBlockItem;
import com.gregtechceu.gtceu.client.renderer.block.TextureOverrideRenderer;
import com.juiceybeans.gthrt.HRTMain;
import com.lowdragmc.lowdraglib.Platform;
import com.lowdragmc.lowdraglib.client.renderer.IRenderer;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.Locale;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Supplier;

import static com.gregtechceu.gtceu.api.GTValues.UV;
import static com.juiceybeans.gthrt.HRTMain.HRT_REGISTRATE;

public class HRTBlocks {
    //Casings
    public static BlockEntry<Block> BiologicallySterileCasing = createCasingBlock("biologically_sterile_casing", HRTMain.id("block/casings/solid/biologically_sterile_machine_casing"));
    public static BlockEntry<Block> FieldGeneratorCasingUV = createMachineCasingBlock("uv_field_generator_casing", UV);
    public static BlockEntry<Block> EmitterCasingUV = createMachineCasingBlock("uv_emitter_casing", UV);
    public static BlockEntry<Block> SensorCasingUV = createMachineCasingBlock("uv_sensor_casing", UV);
    public static BlockEntry<Block> PumpCasingUV = createMachineCasingBlock("uv_pump_casing", UV);

    // Glass casings
    public static BlockEntry<Block> BorosilicateGlass = createGlassCasingBlock("borosilicate_tempered_glass", HRTMain.id("block/casings/transparent/borosilicate_tempered_glass"), () -> RenderType::translucent);
    public static BlockEntry<Block> NickelGlass = createGlassCasingBlock("nickel_tempered_glass", HRTMain.id("block/casings/transparent/nickel_tempered_glass"), () -> RenderType::translucent);
    public static BlockEntry<Block> ChromeGlass = createGlassCasingBlock("chrome_tempered_glass", HRTMain.id("block/casings/transparent/chrome_tempered_glass"), () -> RenderType::translucent);
    public static BlockEntry<Block> OsmiridiumGlass = createGlassCasingBlock("osmiridium_tempered_glass", HRTMain.id("block/casings/transparent/osmiridium_tempered_glass"), () -> RenderType::translucent);

    public static void init() {
    }

    // Builder functions
    public static BlockEntry<Block> createCasingBlock(String name, BiFunction<BlockBehaviour.Properties, IRenderer, ? extends RendererBlock> blockSupplier, ResourceLocation texture, NonNullSupplier<? extends Block> properties, Supplier<Supplier<RenderType>> type) {
        //noinspection removal
        return HRT_REGISTRATE.block(name, p -> (Block) blockSupplier.apply(p,
                        Platform.isClient() ? new TextureOverrideRenderer(new ResourceLocation("block/cube_all"),
                                Map.of("all", texture)) : null))
                .initialProperties(properties)
                .properties(p -> p.isValidSpawn((state, level, pos, ent) -> false))
                .addLayer(type)
                .blockstate(NonNullBiConsumer.noop())
                .tag(TagUtil.createBlockTag("mineable/wrench"), BlockTags.MINEABLE_WITH_PICKAXE) // Note: Can't access GT registries at this point, so just create a new tag, it'll get added anyway
                .item(RendererBlockItem::new)
                .model(NonNullBiConsumer.noop())
                .build()
                .register();
    }
    public static BlockEntry<Block> createCasingBlock(String name, ResourceLocation texture) {
        return createCasingBlock(name, RendererBlock::new, texture, () -> Blocks.IRON_BLOCK, () -> RenderType::cutoutMipped);
    }

    private static BlockEntry<Block> createMachineCasingBlock(String name, int tier) {
        String tierName = GTValues.VN[tier].toLowerCase(Locale.ROOT);
        BlockEntry<Block> entry = HRT_REGISTRATE.block(name, p -> (Block) new RendererBlock(p,
                        Platform.isClient() ? new TextureOverrideRenderer( GTCEu.id("block/cube_bottom_top_tintindex"),
                                Map.of("bottom",  GTCEu.id("block/casings/voltage/%s/bottom".formatted(tierName)),
                                        "top",  GTCEu.id("block/casings/voltage/%s/top".formatted(tierName)),
                                        "side",  GTCEu.id("block/casings/voltage/%s/side".formatted(tierName)))) : null))
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .properties(p -> p.isValidSpawn((state, level, pos, ent) -> false))
                .addLayer(() -> RenderType::cutoutMipped)
                .blockstate(NonNullBiConsumer.noop())
                .tag(TagUtil.createBlockTag("mineable/wrench"), BlockTags.MINEABLE_WITH_PICKAXE)
                .item(RendererBlockItem::new)
                .model(NonNullBiConsumer.noop())
                .build()
                .register();
        return entry;
    }

    private static BlockEntry<Block> createGlassCasingBlock(String name, ResourceLocation texture, Supplier<Supplier<RenderType>> type) {
        return createCasingBlock(name, RendererGlassBlock::new, texture, () -> Blocks.GLASS, type);
    }
}
