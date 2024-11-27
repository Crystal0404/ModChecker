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

package crystal0404.modchecker.mixins;

import crystal0404.modchecker.impl.ClientImpl;
import io.wispforest.owo.config.ConfigSynchronizer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Coerce;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ConfigSynchronizer.class)
public abstract class ConfigSynchronizerClientMixin {
    @Inject(
            method = "applyClient",
            at = @At("TAIL"),
            remap = false
    )
    private static void applyClientMixin(
            @Coerce Object payload,
            ClientPlayNetworking.Context context,
            CallbackInfo ci
    ) {
        ClientImpl.playerJoinGame(context);
    }
}
