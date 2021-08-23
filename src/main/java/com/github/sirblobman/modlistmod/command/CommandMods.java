package com.github.sirblobman.modlistmod.command;

import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentStyle;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;

import com.github.sirblobman.modlistmod.ModListMod;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;

public class CommandMods extends CommandBase {
    public CommandMods(ModListMod modListMod) {
        super();
    }
    
    @Override
    public String getCommandName() {
        return "mods";
    }
    
    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/mods";
    }
    
    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        Loader loader = Loader.instance();
        List<ModContainer> activeModList = loader.getActiveModList();
    
        ChatStyle boldSilver = new ChatStyle().setColor(EnumChatFormatting.GRAY).setBold(true);
        ChatStyle justWhite = new ChatStyle().setColor(EnumChatFormatting.WHITE).setBold(false);
        
        IChatComponent title = new ChatComponentText("Active Mod List:").setChatStyle(boldSilver);
        sender.addChatMessage(title);
        
        for(ModContainer activeMod : activeModList) {
            String modId = activeMod.getModId();
            String displayName = activeMod.getName();
            
            IChatComponent displayNameComponent = new ChatComponentText(displayName).setChatStyle(justWhite);
            IChatComponent modIdComponent = new ChatComponentText(modId + ": ").setChatStyle(boldSilver);
            modIdComponent.appendSibling(displayNameComponent);
            
            sender.addChatMessage(modIdComponent);
        }
        
        IChatComponent empty = new ChatComponentText("");
        sender.addChatMessage(empty);
    }
}
