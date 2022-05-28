package com.uroria.minetrade.trade;

import com.uroria.minetrade.MineTrade;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Villager;

public class Create {

    private LivingEntity shop;
    private final MineTrade mineTrade = MineTrade.inst();

    public Create() {}

    public Create spawn(Location location) {
        this.shop = (Villager)location.getWorld().spawnEntity(location, EntityType.VILLAGER);
        return this;
    }

    public Create visible(boolean visible) {
        shop.setInvisible(visible);
        return this;
    }

    public LivingEntity displayName(String name, boolean visibleName) {
        shop.setCustomName(name);
        shop.setCustomNameVisible(visibleName);
        mineTrade.getFileManager().setShop(name);
        return shop;
    }

    public Create glowing(boolean glowing) {
        shop.setGlowing(glowing);
        return this;
    }

    public LivingEntity getShop() {
        return shop;
    }
}
