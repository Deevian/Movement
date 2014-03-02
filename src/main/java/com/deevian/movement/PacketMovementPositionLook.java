package com.deevian.movement;

import net.minecraft.server.v1_7_R1.PacketListener;
import net.minecraft.server.v1_7_R1.PacketPlayInListener;
import net.minecraft.server.v1_7_R1.PacketPlayInPositionLook;

public class PacketMovementPositionLook extends PacketPlayInPositionLook
{
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

    public void handle(PacketListener packetlistener) {
        super.a((PacketPlayInListener) packetlistener);
    }
}