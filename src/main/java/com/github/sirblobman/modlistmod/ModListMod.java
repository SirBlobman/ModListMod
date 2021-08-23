package com.github.sirblobman.modlistmod;

import net.minecraft.init.Blocks;

import com.github.sirblobman.modlistmod.command.CommandMods;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod(modid = ModListMod.MODID, version = ModListMod.VERSION, acceptableRemoteVersions = "*")
public final class ModListMod {
    public static final String MODID = "modlistmod";
    public static final String VERSION = "1.0.0";
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
		// some example code
        System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
    }
    
    @EventHandler
    public void serverStart(FMLServerStartingEvent event) {
        event.registerServerCommand(new CommandMods(this));
    }
}
