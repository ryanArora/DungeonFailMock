package me.ryanarora.dungeonfailmock.events;

import me.ryanarora.dungeonfailmock.DungeonFailMock;
import me.ryanarora.dungeonfailmock.config.DungeonFailMockConfig;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

public class ChatReceivedEvent {
    private String removePrefix(String str, String prefix) {
        if (str != null && prefix != null && str.startsWith(prefix)){
            return str.substring(prefix.length());
        }
        return str;
    }

    private String spongebobify(String str) {
        Random rand = new Random();
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            int randNum = rand.nextInt(3) + 1;
            if (i % randNum == 0) {
                chars[i] = Character.toUpperCase(str.charAt(i));
            } else {
                chars[i] = Character.toLowerCase(str.charAt(i));
            }
        }
        str = String.valueOf(chars);
        return str;
    }

    @SubscribeEvent
    public void chatReceived(ClientChatReceivedEvent event) {
        DungeonFailMockConfig config = DungeonFailMock.config;

        if (!config.isEnabled()) return;
        if (!DungeonFailMock.onHypixel) return;

        String formatted = event.message.getFormattedText();
        String unformatted = event.message.getUnformattedText();

        if (formatted.startsWith("§r§c ☠") && unformatted.endsWith("and became a ghost.")) {
            String msg = removePrefix(unformatted, " ☠ ");

            if (config.isSpongebob()) {
                int i = msg.indexOf(' ');
                String name = msg.substring(0, i);
                String rest = msg.substring(i);

                msg = name + spongebobify(rest);
            }

            Minecraft.getMinecraft().thePlayer.sendChatMessage("/pc " + msg);
        }
    }
}
