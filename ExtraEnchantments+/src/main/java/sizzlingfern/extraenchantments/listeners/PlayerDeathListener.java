package sizzlingfern.extraenchantments.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerDeathListener implements Listener {

	@EventHandler
	public void onPlayerDeath(final PlayerDeathEvent event) {
		if (event.getEntity().isGlowing()) {
			event.getEntity().setGlowing(false);
		}

	}

	@EventHandler
	public void onPlayerRespawn(final PlayerRespawnEvent event) {
		final Player player = event.getPlayer();

		if (player.isGlowing()) {
			player.setGlowing(false);
		}
	}

}
