package com.deevian.movement;

import net.minecraft.server.v1_7_R1.PacketListener;
import net.minecraft.server.v1_7_R1.PacketPlayInFlying;
import net.minecraft.server.v1_7_R1.PacketPlayInListener;

public class PacketMovement
{
    protected double x;
    protected double y;
    protected double z;
    protected double stance;
    protected float yaw;
    protected float pitch;
    protected boolean g;
    protected boolean hasPos;
    protected boolean hasLook;
    protected long timestamp;

    public long getTimestamp() {return this.timestamp;}
    public double getX() {return this.x;}
    public double getY() {return this.y;}
    public double getZ() {return this.z;}
    public double getStance() {return this.stance;}
    public double getYaw() {return this.yaw;}
    public double getPitch() {return this.pitch;}
    public boolean getG() {return this.g;}
    public boolean getHasLook() {return this.hasLook;}
    public boolean getHasPos() {return this.hasPos;}
}