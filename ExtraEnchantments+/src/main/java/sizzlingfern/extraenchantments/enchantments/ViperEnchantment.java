package sizzlingfern.extraenchantments.enchantments;

import lombok.Getter;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.mineacademy.fo.RandomUtil;
import org.mineacademy.fo.model.SimpleEnchantment;
import org.mineacademy.fo.remain.CompParticle;

public class ViperEnchantment extends SimpleEnchantment {

	@Getter
	private static final Enchantment instance = new ViperEnchantment();

	private ViperEnchantment() {
		super(  "Viper", 3);

	}

	@Override
	protected void onDamage(final int level, final LivingEntity damager, final EntityDamageByEntityEvent event) {
		if (!(event.getEntity() instanceof LivingEntity))
			return;

		if (damager instanceof Player) {
			final Player player = (Player) damager;
			final LivingEntity victim = (LivingEntity) event.getEntity();

			if (level == 1) {
				if (RandomUtil.chance(100)) {
					if (player.getInventory().getItemInMainHand().getEnchantments().containsKey(Enchantment.getByKey(ViperEnchantment.getInstance().getKey()))) {
						victim.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 5 * 20, 0));
						CompParticle.DAMAGE_INDICATOR.spawn(victim.getLocation());
					}
				}
			}
			if (level == 2) {
				if (RandomUtil.chance(100)) {
					if (player.getInventory().getItemInMainHand().getEnchantments().containsKey(Enchantment.getByKey(ViperEnchantment.getInstance().getKey()))) {
						victim.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 7 * 20, 1));
					}
				}
			}
			if (level == 3) {
				if (RandomUtil.chance(100)) {
					if (player.getInventory().getItemInMainHand().getEnchantments().containsKey(Enchantment.getByKey(ViperEnchantment.getInstance().getKey()))) {
						victim.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 10 * 20, 1));
					}
				}
			}
		}

	}
}
