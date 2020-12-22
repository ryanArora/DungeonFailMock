package me.ryanarora.dungeonfailmock;

import me.ryanarora.dungeonfailmock.commands.DungeonFailMockCommand;
import me.ryanarora.dungeonfailmock.config.DungeonFailMockConfig;
import me.ryanarora.dungeonfailmock.events.ChatReceivedEvent;
import me.ryanarora.dungeonfailmock.events.ConnectedToServerEvent;
import me.ryanarora.dungeonfailmock.events.DisconnectionFromServerEvent;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.IOException;

@Mod(name = DungeonFailMock.NAME, modid = DungeonFailMock.MODID, version = DungeonFailMock.VERSION, clientSideOnly = true)
public class DungeonFailMock {
    public static final String NAME = "DungeonFailMock";
    public static final String MODID = "dungeonfailmock";
    public static final String VERSION = "1.0";

    public static boolean onHypixel = false;

    public static DungeonFailMockConfig config;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) throws IOException {
        config = new DungeonFailMockConfig(event.getSuggestedConfigurationFile());
        config.load();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new ChatReceivedEvent());
        MinecraftForge.EVENT_BUS.register(new ConnectedToServerEvent());
        MinecraftForge.EVENT_BUS.register(new DisconnectionFromServerEvent());

        ClientCommandHandler.instance.registerCommand(new DungeonFailMockCommand());
    }
}
