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

package crystal0404.modchecker;

import crystal0404.modchecker.config.ModChecker;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModCheckerMod implements ModInitializer {
    public static final ModChecker CONFIG = ModChecker.createAndLoad();

    public static final String MOD_ID = "modchecker";

    public static final String MOD_NAME = "ModChecker";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    @Override
    public void onInitialize() {
    }
}
