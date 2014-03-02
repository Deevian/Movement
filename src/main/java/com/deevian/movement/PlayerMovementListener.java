package com.deevian.movement;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.*;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.reflect.FieldAccessException;
import net.minecraft.server.v1_7_R1.PacketPlayInFlying;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerMovementListener
{
    private final Server server;
    private final Logger logger;

    private HashMap<String, HashMap<String, Array>> playerMovementStore;

    public PlayerMovementListener(Server server, Logger logger)
    {
        this.server = server;
        this.logger = logger;
    }

    public void addListener(ProtocolManager protocolManager, JavaPlugin plugin)
    {
        protocolManager.addPacketListener(new PacketAdapter(plugin, ListenerPriority.MONITOR, PacketType.Play.Client.POSITION, PacketType.Play.Client.POSITION_LOOK) {
            @Override
            public void onPacketReceiving(PacketEvent event) {
                Player player = event.getPlayer();
//                player.setWalkSpeed(0.4f);
//                player.setFlySpeed(0.4f);

//                player.setVelocity(player.getLocation().getDirection().setX(player.getLocation().getDirection().getX() + 1).setY(player.getLocation().getDirection().getX() + 0.5).setZ(player.getLocation().getDirection().getZ() + 1));

                PacketPlayInFlying packet = (PacketPlayInFlying) event.getPacket().getHandle();

//                boolean isFalling = !packet.i();
//                long timestamp = packet.timestamp;

                double toX = packet.c();
                double fromX = player.getLocation().getX();

                double toZ = packet.e();
                double fromZ = player.getLocation().getZ();

//                Double toY = packet.d();
//                Double fromY = player.getLocation().getY();

                float yaw = (event.getPacketType() == PacketType.Play.Client.POSITION)
                        ? Math.abs(player.getLocation().getYaw())
                        : Math.abs(packet.g()) % 360;
                yaw = (yaw + 90) % 360;

                double zDistance = toZ - fromZ;
                double xDistance = toX - fromX;

                double fbDistance = (zDistance * Math.cos(Math.toRadians(yaw))) + (xDistance * Math.sin(Math.toRadians(yaw)));
                double lrDistance = (-(zDistance * Math.sin(Math.toRadians(yaw)))) + (xDistance * Math.cos(Math.toRadians(yaw)));

                logger.info("yaw: " + String.valueOf(yaw));
                logger.info("fbDistance: " + String.valueOf(fbDistance));
                logger.info("lrDistance: " + String.valueOf(lrDistance));

//                logger.info("x: " + String.valueOf(x));
//                logger.info("xPlayer: " + String.valueOf(xPlayer));
//                logger.info("y: " + String.valueOf(y));
//                logger.info("yPlayer: " + String.valueOf(yPlayer));
//                logger.info("z: " + String.valueOf(z));
//                logger.info("yaw: " + String.valueOf(yaw));
//                logger.info("isFalling: " + String.valueOf(isFalling));
//                logger.info("timestamp: " + String.valueOf(timestamp));


                try {

                } catch (FieldAccessException e) {
                    logger.log(Level.SEVERE, "Couldn't access field.", e);
                }
            }
        });
    }

    public Server getServer()
    {
        return server;
    }

    public void removeListener(ProtocolManager protocolManager, JavaPlugin plugin)
    {
        protocolManager.removePacketListeners(plugin);
    }
}