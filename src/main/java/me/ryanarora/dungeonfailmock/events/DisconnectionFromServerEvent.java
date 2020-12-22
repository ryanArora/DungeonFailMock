package me.ryanarora.dungeonfailmock.events;

import me.ryanarora.dungeonfailmock.DungeonFailMock;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

public class DisconnectionFromServerEvent {
    @SubscribeEvent
    public void disconnected(FMLNetworkEvent.ClientDisconnectionFromServerEvent event) {
        DungeonFailMock.onHypixel = false;
    }
}
