package me.ryanarora.dungeonfailmock.config;

import me.ryanarora.dungeonfailmock.utils.JsonFile;

import java.io.File;
import java.io.IOException;

public class DungeonFailMockConfig extends JsonFile {
    public DungeonFailMockConfig(File container) {
        super(container);
    }

    private boolean enabled = true;
    private boolean spongebob = true;

    public void load() {
        try {
            this.loadJson();
        } catch(IOException e) {
            System.out.println(e);
        }

        enabled = this.get("enabled", enabled);
        spongebob = this.get("spongebob", spongebob);
    }

    public void save() {
        this.put("enabled", enabled);
        this.put("spongebob", spongebob);

        try {
            this.saveJson();
        } catch(IOException e) {
            System.out.println(e);
        }
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        save();
    }

    public boolean isSpongebob() {
        return spongebob;
    }

    public void setSpongebob(boolean spongebob) {
        this.spongebob = spongebob;
        save();
    }
}
