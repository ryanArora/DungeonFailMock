package me.ryanarora.dungeonfailmock.events;

import me.ryanarora.dungeonfailmock.DungeonFailMock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

public class ConnectedToServerEvent {
    @SubscribeEvent
    public void connected(FMLNetworkEvent.ClientConnectedToServerEvent event) {
        ServerData serverData = Minecraft.getMinecraft().getCurrentServerData();

        if (serverData != null) {
            if (serverData.serverIP.toLowerCase().contains("hypixel.net")) {
                DungeonFailMock.onHypixel = true;
            }
        }
    }
}
