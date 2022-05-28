package com.uroria.minetrade.config;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class FileManager {

    private final File file = new File("plugins/mineTrade/shop.yml");
    private final YamlConfiguration yamlConfiguration;

    public FileManager() {
        yamlConfiguration = YamlConfiguration.loadConfiguration(file);
    }

    public void setShop(String path) {
        if(existShop(path)) {
            Bukkit.broadcastMessage("shop already exist");
            return;
        }
        yamlConfiguration.set(path, "");
        try {
            yamlConfiguration.save(file);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public String getShop(String path) {
        return yamlConfiguration.getString(path);
    }

    public boolean existShop(String name) {
        return getShop(name) != null;
    }

    public File getFile() {
        return file;
    }

    public YamlConfiguration getYamlConfiguration() {
        return yamlConfiguration;
    }
}
