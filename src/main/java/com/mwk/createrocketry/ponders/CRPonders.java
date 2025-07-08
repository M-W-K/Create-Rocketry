package com.mwk.createrocketry.ponders;

import com.mwk.createrocketry.CreateRocketry;
import net.createmod.ponder.api.registration.PonderPlugin;
import org.jetbrains.annotations.NotNull;

public class CRPonders implements PonderPlugin {
    @Override
    public @NotNull String getModId() {
        return CreateRocketry.MODID;
    }
}
