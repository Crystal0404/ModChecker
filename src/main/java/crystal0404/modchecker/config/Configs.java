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

package crystal0404.modchecker.config;

import io.wispforest.owo.config.Option;
import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Sync;

import java.util.ArrayList;
import java.util.List;

@Config(name = "ModCheckerConfig", wrapperName = "ModChecker")
public class Configs {
    @Sync(value = Option.SyncMode.OVERRIDE_CLIENT)
    public List<String> BlackPackages = new ArrayList<>();
}
