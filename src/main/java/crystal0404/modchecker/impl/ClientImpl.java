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

package crystal0404.modchecker.impl;

import crystal0404.modchecker.ModCheckerMod;
import crystal0404.modchecker.utils.MessagePresets;
import crystal0404.modchecker.utils.Utils;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.DisconnectedScreen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.NoSuchElementException;

public class ClientImpl {
    public static void playerJoinGame(ClientPlayNetworking.Context context) {
        blackPackageChecker(context.client(), ModCheckerMod.CONFIG.BlackPackages());
    }

    private static void blackPackageChecker(MinecraftClient client , List<String> blackPackages) {
        for (String blackPackage : blackPackages) {
            // example: cca$crystal0404.crystalcarpetaddition.CrystalCarpetAdditionMod -> crystal0404.crystalcarpetaddition.CrystalCarpetAdditionMod
            String className = blackPackage.replaceAll("^(.{1,63}\\$)", "");

            if (Utils.tryFindClass(className)) {
                // example: cca$crystal0404.crystalcarpetaddition.CrystalCarpetAdditionMod -> cca
                String modId = blackPackage.replaceAll("\\$.+", "");

                String modName;
                try {
                    modName = FabricLoader.getInstance().getModContainer(modId).orElseThrow().getMetadata().getName();
                } catch (NoSuchElementException e) {
                    modName = "(Unknown mod)";
                }
                disconnect(client, MessagePresets.blackModResson(modName));
                return;
            }
        }
    }

    private static void disconnect(@NotNull MinecraftClient client, Text reason) {
        client.execute(() -> {
            if (client.world != null) {
                client.world.disconnect();
            }
            client.disconnect();
            client.setScreen(new DisconnectedScreen(new MultiplayerScreen(new TitleScreen()), MessagePresets.CCATITLE, reason));
        });
    }
}
