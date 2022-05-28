package com.uroria.minetrade.command;

import com.uroria.minetrade.MineTrade;
import com.uroria.minetrade.trade.Create;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.PacketPlayOutSpawnEntityLiving;
import net.minecraft.server.level.WorldServer;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.npc.EntityVillager;
import net.minecraft.world.entity.npc.VillagerType;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.craftbukkit.v1_18_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class Command_Trade implements TabExecutor {

    private final MineTrade mineTrade = MineTrade.inst();
    private final Create create = mineTrade.getCreate();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(sender instanceof ConsoleCommandSender) {
            sender.sendMessage("you must be a player");
            return false;
        }
        Player player = (Player) sender;
        spawnNPC(player);
        //create.spawn(player.getLocation()).visible(true).glowing(true).displayName("Test", true);
        player.sendMessage("success");
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(sender instanceof ConsoleCommandSender) {
            sender.sendMessage("you must be a player");
            return null;
        }
        return null;
    }

    private void spawnNPC(Player player) {
        Location location = player.getLocation();
        try {
            WorldServer world = ((CraftWorld) Objects.requireNonNull(location.getWorld())).getHandle();
            EntityVillager villager = new EntityVillager(EntityTypes.aV, world, VillagerType.e);
            villager.b(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
            sendPacket(new PacketPlayOutSpawnEntityLiving(villager));
            //sendPacket(new PacketPlayOutEntityHeadRotation(npcPlayer, this.getFixRotation(location.getYaw())), player);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    private void sendPacket(Packet<?> packet, Player player) {
        ((CraftPlayer) player).getHandle().b.a(packet);
    }

    private void sendPacket(Packet<?> packet) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            this.sendPacket(packet, player);
        }
    }
}
