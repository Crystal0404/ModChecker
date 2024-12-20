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

package crystal0404.modchecker.utils;

import net.minecraft.text.Style;
import net.minecraft.text.Text;

public class MessagePresets {
    public static final Text INSTALLATION = Text.literal(
            "\nPlease install ModChecker!\n"
    ).setStyle(Style.EMPTY.withColor(0x55FFFF)
    ).append(Text.literal(
                    "https://github.com/Crystal0404/ModChecker"
            ).setStyle(Style.EMPTY.withColor(0x55FF55).withUnderline(true))
    );

    public static final Text CCATITLE = Text.literal("ModChecker")
            .setStyle(Style.EMPTY.withColor(0x55FFFF).withBold(true));

    public static Text blackModResson(String modName) {
        return Text.literal("You can't use ").setStyle(Style.EMPTY.withColor(0x55FF55))
                .append(Text.literal(modName).setStyle(Style.EMPTY.withColor(0xFF5555).withUnderline(true)))
                .append(Text.literal(" in this server!").setStyle(Style.EMPTY.withColor(0x55FF55)));
    }
}
