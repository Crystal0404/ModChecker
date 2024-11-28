/*
 * This file is part of the ModChecker project, licensed under the
 * GNU General Public License v3.0
 *
 * Copyright (C) 2024  Crystal0404 and contributors
 *
 * ModChecker is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ModChecker is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with ModChecker.  If not, see <https://www.gnu.org/licenses/>.
 */

package crystal0404.modchecker.network;

import crystal0404.modchecker.ModCheckerMod;
import io.netty.buffer.ByteBuf;
import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public class S2C {
    private static final Identifier IDENTIFIER = Identifier.of(ModCheckerMod.MOD_ID, "hello");

    public static void init() {
        PayloadTypeRegistry.playS2C().register(modCheckerPayload.ID, modCheckerPayload.CODEC);
        if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
            ClientPlayNetworking.registerGlobalReceiver(modCheckerPayload.ID, (p, s) -> {

            });
        }
    }
    public record modCheckerPayload(String s) implements CustomPayload {
        public static final Id<modCheckerPayload> ID = new Id<>(IDENTIFIER);
        public static final PacketCodec<ByteBuf, modCheckerPayload> CODEC = PacketCodecs.STRING.xmap(modCheckerPayload::new, modCheckerPayload::s).cast();
        @Override
        public Id<? extends CustomPayload> getId() {
            return ID;
        }
    }
}
