package com.juiceybeans.gthrt;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialRegistryEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.PostMaterialEvent;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.juiceybeans.gthrt.common.data.*;
import com.juiceybeans.gthrt.data.HRTBlocks;
import com.juiceybeans.gthrt.data.lang.LangHandler;
import com.tterrag.registrate.providers.ProviderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(HRTMain.MOD_ID)
public class HRTMain {
    public static final String MOD_ID = "gthrt";
    public static final Logger LOGGER = LogManager.getLogger();
    public static GTRegistrate HRT_REGISTRATE = GTRegistrate.create(HRTMain.MOD_ID);

    public HRTMain() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        HRTMain.HRT_REGISTRATE.addDataGenerator(ProviderType.LANG, LangHandler::init);

        HRTItems.init();
        HRTBlocks.init();

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);
        modEventBus.addListener(this::addMaterialRegistries);
        modEventBus.addListener(this::addMaterials);
        modEventBus.addListener(this::modifyMaterials);
        modEventBus.addGenericListener(GTRecipeType.class, this::registerRecipeTypes);
        modEventBus.addGenericListener(MachineDefinition.class, this::registerMachines);

        // Most other events are fired on Forge's bus.
        // If we want to use annotations to register event listeners,
        // we need to register our object like this!
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
        });
    }

    private void clientSetup(final FMLClientSetupEvent event) {

    }

    // You MUST have this for custom materials.
    // Remember to register them not to GT's namespace, but your own.
    private void addMaterialRegistries(MaterialRegistryEvent event) {
        GTCEuAPI.materialManager.createRegistry(HRTMain.MOD_ID);
    }

    // As well as this.
    private void addMaterials(MaterialEvent event) {
        HRTMaterials.init();
    }

    // This is optional, though.
    private void modifyMaterials(PostMaterialEvent event) {
        //CustomMaterials.modify();
    }

    private void registerRecipeTypes(GTCEuAPI.RegisterEvent<ResourceLocation, GTRecipeType> event) {
        HRTRecipeTypes.init();
    }

    private void registerMachines(GTCEuAPI.RegisterEvent<ResourceLocation, MachineDefinition> event) {
        HRTMachines.init();
    }
}
