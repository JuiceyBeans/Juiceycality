package com.juiceybeans.juiceycality.data.recipe;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.UnificationEntry;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import com.juiceybeans.juiceycality.common.data.JCBlocks;
import com.juiceybeans.juiceycality.common.data.JCItems;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTItems.*;
import static com.gregtechceu.gtceu.common.data.GTMachines.HULL;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.data.recipe.CraftingComponent.CIRCUIT;
import static com.juiceybeans.juiceycality.common.data.JCMachines.BIO_REACTOR;

public class CraftingRecipes {
    public static void init(Consumer<FinishedRecipe> provider) {
        VanillaRecipeHelper.addShapedRecipe(provider, true, "bio_reactor_hv", BIO_REACTOR[HV].asStack(),
                "ABA", "CDE", "FGH",
                'A', CIRCUIT.getIngredient(HV),
                'B', ELECTRIC_PUMP_HV,
                'C', SENSOR_HV,
                'D', HULL[HV].asStack(),
                'E', JCBlocks.BorosilicateGlass,
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
                'E', JCBlocks.NickelGlass,
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
                'E', JCBlocks.ChromeGlass,
                'F', new UnificationEntry(cableGtSingle, Platinum),
                'G', new UnificationEntry(plate, Polytetrafluoroethylene),
                'H', new UnificationEntry(plate, TungstenSteel)
        );
        VanillaRecipeHelper.addShapelessRecipe(provider, "wrought_iron_hammering", ChemicalHelper.get(ingot, WroughtIron),
                'h', JCItems.HotIronIngot
                );
        VanillaRecipeHelper.addSmeltingRecipe(provider, "smelt_iron_to_hot", ChemicalHelper.getTag(ingot, Iron), JCItems.HotIronIngot.asStack());
    }
}
