package me.dubai.pot.listener;

import me.dubai.pot.utils.DataFile;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.util.Vector;

public class VelocityListener implements Listener {

    @EventHandler
    private void onPotionThrow(ProjectileLaunchEvent event) {
        Player player = (Player) event.getEntity().getShooter();
        ThrownPotion thrown = (event.getEntity().getType() == EntityType.SPLASH_POTION) ? (ThrownPotion) event.getEntity() : null;
        if (thrown == null) return;

        Vector velocity = thrown.getVelocity();
        if (thrown.getType() == EntityType.SPLASH_POTION) {
            if (event.getEntity().getShooter() instanceof Player && player != null) {
                velocity.setY(velocity.getY() - (float) DataFile.getConfig().getDouble("SETTINGS.POTION.SPEED"));
            }
        }
    }

    @EventHandler
    private void onPotionSplash(PotionSplashEvent event) {
        Player player = (Player) event.getEntity().getShooter();
        ThrownPotion thrown = (event.getEntity().getType() == EntityType.SPLASH_POTION) ? event.getEntity() : null;
        if (thrown == null) return;

        if (thrown.getType() == EntityType.SPLASH_POTION) {
            if (event.getEntity().getShooter() instanceof Player && player != null) {
                event.setIntensity(player, (float) DataFile.getConfig().getDouble("SETTINGS.POTION.OFFSET"));
            }
        }
    }
}
