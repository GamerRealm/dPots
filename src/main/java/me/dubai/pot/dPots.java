package me.dubai.pot;

import lombok.Getter;
import me.dubai.pot.commands.PotCommands;
import me.dubai.pot.listener.VelocityListener;
import me.vaperion.blade.Blade;
import me.vaperion.blade.command.bindings.impl.BukkitBindings;
import me.vaperion.blade.command.container.impl.BukkitCommandContainer;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class dPots extends JavaPlugin {

    @Getter
    private static dPots instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        Blade.of()
                .fallbackPrefix("dpots")
                .containerCreator(BukkitCommandContainer.CREATOR)
                .binding(new BukkitBindings())
                .build()
                .register(PotCommands.class);

        getServer().getPluginManager().registerEvents(new VelocityListener(), this);
        System.out.println("dPots " + getDescription().getVersion() + " has been enabled!");
    }

    @Override
    public void onDisable() {
        instance = null;

        System.out.println("dPots " + getDescription().getVersion() + " has been disabled!");
    }
}
