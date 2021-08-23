package com.github.sirblobman.modlistmod;

import net.minecraft.command.ICommand;

import com.github.sirblobman.modlistmod.command.CommandMods;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod(modid = ModListMod.MODID, version = ModListMod.VERSION, acceptableRemoteVersions = "*")
public final class ModListMod {
    public static final String MODID = "modlistmod";
    public static final String VERSION = "1.0.0";
    
    @EventHandler
    public void onServerStarting(FMLServerStartingEvent event) {
        ICommand commandMods = new CommandMods(this);
        event.registerServerCommand(commandMods);
    }
}
