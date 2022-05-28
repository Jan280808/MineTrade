package com.uroria.minetrade;

import com.uroria.minetrade.command.Command_Trade;
import com.uroria.minetrade.config.FileManager;
import com.uroria.minetrade.trade.Create;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class MineTrade extends JavaPlugin {

    public static MineTrade inst;
    private FileManager fileManager;
    private Create create;

    @Override
    public void onEnable() {
        inst = this;
        this.fileManager = new FileManager();
        this.create = new Create();
        registerListener(Bukkit.getPluginManager());
        registerCommand();
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    private void registerListener(PluginManager pluginManager) {

    }

    private void registerCommand() {
        Objects.requireNonNull(getCommand("minetrade")).setExecutor(new Command_Trade());
        Objects.requireNonNull(getCommand("mt")).setExecutor(new Command_Trade());
    }


    public static MineTrade inst() {
        return inst;
    }

    public FileManager getFileManager() {
        return fileManager;
    }

    public Create getCreate() {
        return create;
    }
}
