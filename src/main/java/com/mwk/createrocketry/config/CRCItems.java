package com.mwk.createrocketry.config;

import net.createmod.catnip.config.ConfigBase;

public class CRCItems extends ConfigBase {

    public final ConfigInt timeslipBottleRandomTicks = i(20, 0, 200, "timeslipBottleRandomTicks",
            "Number of random ticks triggered for a block when a bottle of Timeslip Flux is used on it.",
            "This progresses 'random' events, such as plant growth, or farmland becoming dry");
    public final ConfigInt timeslipBottleBlockTicks = i(5, 0, 100, "timeslipBottleBlockTicks",
            "Number of block ticks triggered for a block when a bottle of Timeslip Flux is used on it.",
            "Block ticks are usually used for things like checking if a button should be pressed.");
    public final ConfigInt timeslipBottleBlockEntityTicks = i(100, 0, 1000, "timeslipBottleBlockEntityTicks",
            "Number of block entity ticks triggered for a block entity when a bottle of Timeslip Flux is used on it.",
            "This effectively makes most machines have their progress teleport forward by this many ticks.",
            "Can have consequences (game freezing temporarily on bottle use) if set too high.");
    public final ConfigInt timeslipBottleEntityTicks = i(100, 0, 1000, "timeslipBottleEntityTicks",
            "Number of entity ticks triggered for an entity when a bottle of Timeslip Flux is used on it.");

    @Override
    public String getName() {
        return "items";
    }
}
