package com.juiceybeans.gthrt.data.recipe;

import com.gregtechceu.gtceu.api.data.chemical.material.stack.UnificationEntry;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import com.juiceybeans.gthrt.data.HRTBlocks;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.cableGtSingle;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.plate;
import static com.gregtechceu.gtceu.common.data.GTItems.*;
import static com.gregtechceu.gtceu.common.data.GTMachines.HULL;
import static com.gregtechceu.gtceu.common.data.GTMachines.PUMP;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.data.recipe.CraftingComponent.CIRCUIT;
import static com.juiceybeans.gthrt.common.data.HRTMachines.BIO_REACTOR;

public class CraftingRecipes {
    public static void init(Consumer<FinishedRecipe> provider) {
        VanillaRecipeHelper.addShapedRecipe(provider, true, "bio_reactor_hv", BIO_REACTOR[HV].asStack(),
                "ABA", "CDE", "FGH",
                'A', CIRCUIT.getIngredient(HV),
                'B', ELECTRIC_PUMP_HV,
                'C', SENSOR_HV,
                'D', HULL[HV].asStack(),
                'E', GTBlocks.CASING_TEMPERED_GLASS,
                'F', new UnificationEntry(cableGtSingle, Gold),
                'G', new UnificationEntry(plate, Polytetrafluoroethylene),
                'H', new UnificationEntry(plate, StainlessSteel)
        );
        VanillaRecipeHelper.addShapedRecipe(provider, true, "bio_reactor_ev", BIO_REACTOR[EV].asStack(),
                "ABA", "CDE", "FGH",
                'A', CIRCUIT.getIngredient(EV),
                'B', ELECTRIC_PUMP_EV,
                'C', SENSOR_EV,
                'D', HULL[EV].asStack(),
                'E', HRTBlocks.NickelGlass,
                'F', new UnificationEntry(cableGtSingle, Aluminium),
                'G', new UnificationEntry(plate, Polytetrafluoroethylene),
                'H', new UnificationEntry(plate, Titanium)
        );
        VanillaRecipeHelper.addShapedRecipe(provider, true, "bio_reactor_iv", BIO_REACTOR[IV].asStack(),
                "ABA", "CDE", "FGH",
                'A', CIRCUIT.getIngredient(IV),
                'B', ELECTRIC_PUMP_IV,
                'C', SENSOR_IV,
                'D', HULL[IV].asStack(),
                'E', HRTBlocks.ChromeGlass,
                'F', new UnificationEntry(cableGtSingle, Platinum),
                'G', new UnificationEntry(plate, Polytetrafluoroethylene),
                'H', new UnificationEntry(plate, TungstenSteel)
        );


    }
}
