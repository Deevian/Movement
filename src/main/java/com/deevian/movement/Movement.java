package com.deevian.movement;

import org.bukkit.plugin.java.JavaPlugin;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.ProtocolLibrary;

public final class Movement extends JavaPlugin {
    private ProtocolManager protocolManager;

    private PlayerMovementListener playerMovementListener;

    @Override
    public void onEnable()
    {
        protocolManager = ProtocolLibrary.getProtocolManager();

        playerMovementListener = new PlayerMovementListener(getServer(), getLogger());
        playerMovementListener.addListener(protocolManager, this);
    }

    @Override
    public void onDisable()
    {
        getLogger().info("onDisable has been invoked!");
    }
}
