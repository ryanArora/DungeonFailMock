package me.ryanarora.dungeonfailmock.utils;

import com.google.gson.*;

import javax.annotation.Nonnull;
import java.io.*;

public class JsonFile {
    private JsonObject obj;
    private final File container;
    private final Gson gson;

    public JsonFile(File container) {
        this.obj = new JsonObject();
        this.container = container;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        if (!this.container.exists()) {
            try {
                OutputStream stream = new FileOutputStream(this.container);
                Writer writer = new OutputStreamWriter(stream);
                writer.write(this.toString());
                writer.close();
                stream.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        } else {
            try {
                InputStream stream = new FileInputStream(this.container);
                Reader reader = new InputStreamReader(stream);
                this.obj = new JsonParser().parse(reader).getAsJsonObject();
                reader.close();
                stream.close();
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                try {
                    this.saveJson();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
    }

    public void loadJson() throws IOException {
        InputStream stream = new FileInputStream(this.container);
        Reader reader = new InputStreamReader(stream);
        this.obj = new JsonParser().parse(reader).getAsJsonObject();
        reader.close();
        stream.close();
    }

    public void saveJson() throws IOException {
        OutputStream stream = new FileOutputStream(this.container);
        Writer writer = new OutputStreamWriter(stream);
        writer.write(this.toString());
        writer.close();
        stream.close();
    }

    public void put(@Nonnull String key, JsonObject value) {
        this.obj.add(key, value);
    }

    public void put(@Nonnull String key, JsonArray value) {
        this.obj.add(key, value);
    }

    public void put(@Nonnull String key, int value) {
        this.obj.addProperty(key, value);
    }

    public void put(@Nonnull String key, long value) {
        this.obj.addProperty(key, value);
    }

    public void put(@Nonnull String key, float value) {
        this.obj.addProperty(key, value);
    }

    public void put(@Nonnull String key, double value) {
        this.obj.addProperty(key, value);
    }

    public void put(@Nonnull String key, byte value) {
        this.obj.addProperty(key, value);
    }

    public void put(@Nonnull String key, String value) {
        this.obj.addProperty(key, value);
    }

    public void put(@Nonnull String key, boolean value) {
        this.obj.addProperty(key, value);
    }

    public JsonObject get(@Nonnull String key, JsonObject defaultValue) {
        return this.obj.has(key) && !this.obj.get(key).isJsonNull() ? this.obj.get(key).getAsJsonObject() : defaultValue;
    }

    public JsonArray get(@Nonnull String key, JsonArray defaultValue) {
        return this.obj.has(key) && !this.obj.get(key).isJsonNull() ? this.obj.get(key).getAsJsonArray() : defaultValue;
    }

    public int get(@Nonnull String key, int defaultValue) {
        return this.obj.has(key) && !this.obj.get(key).isJsonNull() ? this.obj.get(key).getAsInt() : defaultValue;
    }

    public long get(@Nonnull String key, long defaultValue) {
        return this.obj.has(key) && !this.obj.get(key).isJsonNull() ? this.obj.get(key).getAsLong() : defaultValue;
    }

    public float get(@Nonnull String key, float defaultValue) {
        return this.obj.has(key) && !this.obj.get(key).isJsonNull() ? this.obj.get(key).getAsFloat() : defaultValue;
    }

    public double get(@Nonnull String key, double defaultValue) {
        return this.obj.has(key) && !this.obj.get(key).isJsonNull() ? this.obj.get(key).getAsDouble() : defaultValue;
    }

    public byte get(@Nonnull String key, byte defaultValue) {
        return this.obj.has(key) && !this.obj.get(key).isJsonNull() ? this.obj.get(key).getAsByte() : defaultValue;
    }

    public String get(@Nonnull String key, String defaultValue) {
        return this.obj.has(key) && !this.obj.get(key).isJsonNull() ? this.obj.get(key).getAsString() : defaultValue;
    }

    public boolean get(@Nonnull String key, boolean defaultValue) {
        return this.obj.has(key) && !this.obj.get(key).isJsonNull() ? this.obj.get(key).getAsBoolean() : defaultValue;
    }

    public Gson gson() {
        return this.gson;
    }

    @Override
    public String toString() {
        return this.gson.toJson(this.obj);
    }
}
