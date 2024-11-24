/*
 * This file is part of the ModChecker project, licensed under the
 * GNU Lesser General Public License v3.0
 *
 * Copyright (C) 2024  Crystal0404 and contributors
 *
 * ModChecker is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ModChecker is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with ModChecker.  If not, see <https://www.gnu.org/licenses/>.
 */

package crystal0404.modchecker.utils;

import crystal0404.modchecker.ModCheckerMod;
import org.spongepowered.asm.service.MixinService;

import java.io.IOException;

public abstract class Utils {
    public static boolean tryFindClass(String className) {
        try {
            MixinService.getService().getBytecodeProvider().getClassNode(className);
            return true;
        } catch (IOException e) {
            ModCheckerMod.LOGGER.error("An unknown exception occurred while trying to find the class");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
