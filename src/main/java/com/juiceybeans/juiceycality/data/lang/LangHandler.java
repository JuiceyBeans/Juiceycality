package com.juiceybeans.juiceycality.data.lang;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.tterrag.registrate.providers.RegistrateLangProvider;

import java.util.Set;

public class LangHandler extends com.gregtechceu.gtceu.data.lang.LangHandler {
    private static final Set<Material> MATERIALS = Set.of(
    );

    public static void init(RegistrateLangProvider provider) {
        initItemTooltips(provider);

    }
    private static void initItemTooltips(RegistrateLangProvider provider) {

        // Materials
        for (Material material : MATERIALS) {
            provider.add(material.getUnlocalizedName(), FormattingUtil.toEnglishName(material.getName()));
        }

        // Example tooltip from GTEC
        // multilineLang(provider, "item.gtec.echo_processor_mainframe.tooltip", "§7What have i done?\n§3UEV-Tier Circuit");
    }
}
