package me.ryanarora.dungeonfailmock.commands;

import me.ryanarora.dungeonfailmock.DungeonFailMock;
import me.ryanarora.dungeonfailmock.config.DungeonFailMockConfig;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

public class DungeonFailMockCommand extends CommandBase {
    @Override
    public String getCommandName() {
        return DungeonFailMock.MODID;
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/" + getCommandName();
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
        String[] subcommands = {"toggle", "spongebob"};

        if (args.length == 1) {
            return getListOfStringsMatchingLastWord(args, subcommands);
        }

        return null;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        final String prefix = EnumChatFormatting.GRAY + "[" + EnumChatFormatting.LIGHT_PURPLE + DungeonFailMock.NAME + EnumChatFormatting.GRAY + "]" + EnumChatFormatting.RESET + " ";
        DungeonFailMockConfig config = DungeonFailMock.config;

        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("toggle")) {
                config.setEnabled(!config.isEnabled());
                sender.addChatMessage(new ChatComponentText(prefix + "Mod toggled " + (config.isEnabled() ? "on" : "off")));
                return;
            } else if (args[0].equalsIgnoreCase("spongebob")) {
                config.setSpongebob(!config.isSpongebob());
                sender.addChatMessage(new ChatComponentText(prefix + "Spongebob mocking toggled " + (config.isSpongebob() ? "on" : "off")));
                return;
            }
        }

        sender.addChatMessage(new ChatComponentText(prefix + "\n" + "/dungeonfailmock toggle\n" + "/dungeonfailmock spongebob"));
    }
}
