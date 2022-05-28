package com.uroria.minetrade.trade;

import com.uroria.minetrade.MineTrade;
import com.uroria.minetrade.config.FileManager;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;

public class Delete {

    private final FileManager fileManager;

    public Delete() {
        MineTrade mineTrade = MineTrade.inst();
        this.fileManager = mineTrade.getFileManager();
    }

    public void deleteShop(Player player, Villager shop) {
        if(!fileManager.existShop(shop.getName()))
            return;
        shop.remove();
        player.sendMessage("remove shop");
    }
}
