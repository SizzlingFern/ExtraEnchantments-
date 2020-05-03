package sizzlingfern.extraenchantments.enchantments;

import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.mineacademy.fo.model.SimpleEnchantment;

public class SpeedEnchantment extends SimpleEnchantment implements Listener {

	@Getter
	private static final Enchantment instance = new SpeedEnchantment();

	private SpeedEnchantment() {
		super("Speed", 4);

	}

	@EventHandler
	public void inventoryCloseEvent( final InventoryCloseEvent event) {
		final Player player = (Player) event.getPlayer();
		final ItemStack item = player.getEquipment().getBoots();
		final PotionEffect potion = player.getPotionEffect(PotionEffectType.NIGHT_VISION);

		if (item == null || item.equals(Material.AIR)) {
			player.setWalkSpeed(0.2f);
			player.setFlySpeed(0.2f);
			return;
		}

		if (item != null  && potion == null) {

			if (item.getItemMeta() != null && (potion == null)) {

				if (item.getEnchantments().containsKey(SimpleEnchantment.getByKey(SpeedEnchantment.getInstance().getKey()))) {
					final int level = item.getItemMeta().getEnchantLevel(SimpleEnchantment.getByKey(SpeedEnchantment.getInstance().getKey()));

					if (level == 1) {
						player.setWalkSpeed(Math.min((.05f * level) + .2f, 1));
						player.setFlySpeed(Math.min((.05f * level) + .2f, 1));


					} else if (level == 2) {
						player.setWalkSpeed(Math.min((.05f * level) + .2f, 1));
						player.setFlySpeed(Math.min((.05f * level) + .2f, 1));

					} else if (level == 3) {
						player.setWalkSpeed(Math.min((.05f * level) + .2f, 1));
						player.setFlySpeed(Math.min((.05f * level) + .2f, 1));

					} else if (level == 4) {
						player.setWalkSpeed(Math.min((.05f * level) + .2f, 1));
						player.setFlySpeed(Math.min((.05f * level) + .2f, 1));

					} else {
						player.setWalkSpeed(0.2f);
						player.setFlySpeed(0.2f);
					}
				} else {
					player.setWalkSpeed(0.2f);
					player.setFlySpeed(0.2f);
				}
			} else {
				player.setWalkSpeed(0.2f);
				player.setFlySpeed(0.2f);
			}
		} else {
			player.setWalkSpeed(0.2f);
			player.setFlySpeed(0.2f);
		}
	}
}
