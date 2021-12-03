package me.dubai.pot.commands;

import me.dubai.pot.dPots;
import me.dubai.pot.utils.DataFile;
import me.dubai.pot.utils.Utils;
import me.vaperion.blade.command.annotation.Command;
import me.vaperion.blade.command.annotation.Name;
import me.vaperion.blade.command.annotation.Permission;
import me.vaperion.blade.command.annotation.Sender;
import org.apache.commons.lang.StringUtils;
import org.bukkit.entity.Player;

public class PotCommands {
    private static final dPots plugin = dPots.getInstance();

    @Command(value = {"potion", "pot", "pots"}, async = true, quoted = false, description = "Potion Help Command.")
    @Permission(value = "dpots.admin", message = "No Permission!")
    public static void helpCommand(@Sender Player player) {

        plugin.getConfig().getStringList("MESSAGES.HELP-MESSAGES.POTION")
                .stream()
                .map(message -> Utils.translate(message.replace("<line>", StringUtils.repeat("-", 35))))
                .forEach(player::sendMessage);
    }

    @Command(value = {"potion values", "pot values", "pots values"}, async = true, quoted = false, description = "Potion Values Command.")
    @Permission(value = "dpots.admin", message = "No Permission!")
    public static void valuesCommand(@Sender Player player) {

        plugin.getConfig().getStringList("MESSAGES.POTION.VALUES-MESSAGE").stream().map(message -> Utils.translate(message)
                        .replace("<speed>", String.valueOf(DataFile.getConfig().getDouble("SETTINGS.POTION.SPEED")))
                        .replace("<offset>", String.valueOf(DataFile.getConfig().getDouble("SETTINGS.POTION.OFFSET"))))
                .forEach(player::sendMessage);
    }

    @Command(value = {"potion setspeed", "pot setspeed", "pots setspeed", "potion speed", "pot speed", "pots speed"}, async = true, quoted = false, description = "Potion Speed Command.")
    @Permission(value = "dpots.admin", message = "No Permission!")
    public static void speedCommand(@Sender Player player, @Name("speed") double speed) {

        DataFile.getConfig().set("SETTINGS.POTION.SPEED", speed);
        DataFile.getConfig().fullSave();
        player.sendMessage(Utils.translate(plugin.getConfig().getString("MESSAGES.POTION.SPEED-UPDATED")
                .replace("<value>", String.valueOf(speed))));
    }

    @Command(value = {"potion setoffset", "pot setoffset", "pots setoffset", "potion offset", "pot offset", "pots offset"}, async = true, quoted = false, description = "Potion Offset Command.")
    @Permission(value = "dpots.admin", message = "No Permission!")
    public static void offsetCommand(@Sender Player player, double offset) {

        DataFile.getConfig().set("SETTINGS.POTION.OFFSET", offset);
        DataFile.getConfig().fullSave();
        player.sendMessage(Utils.translate(plugin.getConfig().getString("MESSAGES.POTION.OFFSET-UPDATED")
                .replace("<value>", String.valueOf(offset))));
    }
}