package com.juiceybeans.gthrt.data;

import com.juiceybeans.gthrt.HRTMain;
import com.juiceybeans.gthrt.data.lang.LangHandler;
import com.tterrag.registrate.providers.ProviderType;

public class HRTDatagen {
    public static void init() {
        HRTMain.HRT_REGISTRATE.addDataGenerator(ProviderType.LANG, LangHandler::init);
    }
}
