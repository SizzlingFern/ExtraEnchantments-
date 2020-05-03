package sizzlingfern.extraenchantments.enchantments;

import lombok.Getter;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.mineacademy.fo.RandomUtil;
import org.mineacademy.fo.model.SimpleEnchantment;

public class NutrisionEnchantment extends SimpleEnchantment {

	@Getter
	private static final Enchantment instance = new NutrisionEnchantment();

	private NutrisionEnchantment() {
		super("Nutrision", 3);
	}

	@Override
	protected void onDamage(final int level, final LivingEntity damager, final EntityDamageByEntityEvent event) {
		if (!(event.getEntity() instanceof LivingEntity))
			return;

		if (damager instanceof Player) {
			final Player player = (Player) damager;

			if (level == 1) {
				if (RandomUtil.chance(10)) {
					if (player.getInventory().getItemInMainHand().getEnchantments().containsKey(Enchantment.getByKey(NutrisionEnchantment.getInstance().getKey()))) {
						if (player.getFoodLevel() < 20) {
							final int food = 2;
							player.setFoodLevel(player.getFoodLevel() + food);

						}
					}
				}
			}
			if (level == 2) {
				if (RandomUtil.chance(15)) {
					if (player.getInventory().getItemInMainHand().getEnchantments().containsKey(Enchantment.getByKey(NutrisionEnchantment.getInstance().getKey()))) {
						if (player.getFoodLevel() < 20) {
							player.setFoodLevel(player.getFoodLevel() + 2);
						}
					}
				}
			}
			if (level == 3) {
				if (RandomUtil.chance(20)) {
					if (player.getInventory().getItemInMainHand().getEnchantments().containsKey(Enchantment.getByKey(NutrisionEnchantment.getInstance().getKey()))) {
						if (player.getFoodLevel() < 20) {
							player.setFoodLevel(player.getFoodLevel() + 4);
						}
					}
				}
			}
		}
	}
}


