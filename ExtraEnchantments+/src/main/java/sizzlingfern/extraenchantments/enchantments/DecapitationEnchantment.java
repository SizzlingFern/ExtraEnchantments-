package sizzlingfern.extraenchantments.enchantments;

import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.mineacademy.fo.model.SimpleEnchantment;

public class DecapitationEnchantment extends SimpleEnchantment {

	@Getter
	private static final Enchantment instance = new DecapitationEnchantment();

	private DecapitationEnchantment() {
		super("Beheader", 4);
	}

	@Override
	public EnchantmentTarget getItemTarget() {
		return super.getItemTarget();
	}

	@Override
	protected void onDamage(final int level, final LivingEntity damager, final EntityDamageByEntityEvent event) {
		if (!(event.getEntity() instanceof LivingEntity)) {
			return;
		}

		if (damager instanceof Player) {
			final Player player = (Player) damager;
			final LivingEntity victim = (LivingEntity) event.getEntity();

			if (level == 1) {
				if (player.getInventory().getItemInMainHand().getEnchantments().containsKey(SimpleEnchantment.getByKey(DecapitationEnchantment.getInstance().getKey()))) {
					if (victim.getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK && victim.getKiller() != null) {
						final Location location = victim.getLocation();
						final EntityType type = victim.getType();

						if (victim.getKiller() == player) {

						}
					}
				}
			}
		}
	}


}
