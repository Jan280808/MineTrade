package com.uroria.minetrade.data;

import de.fruxz.sus.ShopDataBaseController;
import de.fruxz.sus.shop.Rarity;
import de.fruxz.sus.shop.ShopEntry;
import de.fruxz.sus.util.ItemUtil;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class Data {

    private ShopEntry shopEntry;

    public Data() {}

    public ShopEntry getEntry(String shopName, ItemStack itemStack, Rarity rarity) {
        for(ShopEntry shopEntry : ShopDataBaseController.getEntries(null, shopName, null, null, null, ItemUtil.toBase64(List.of(itemStack)), rarity, null)) {
            return shopEntry;
        }
        return null;
    }


}
