package com.mwk.createrocketry.config;

import net.createmod.catnip.config.ConfigBase;
import org.jetbrains.annotations.NotNull;

public class CRCServer extends ConfigBase {

    public final CRCItems items = nested(0, CRCItems::new, "Interactive items added by Create: Rocketry");

    @Override
    public @NotNull String getName() {
        return "server";
    }
}
