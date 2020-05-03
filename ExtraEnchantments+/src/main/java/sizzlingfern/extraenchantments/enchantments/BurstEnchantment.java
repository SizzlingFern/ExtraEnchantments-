package sizzlingfern.extraenchantments.enchantments;

import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.RandomUtil;
import org.mineacademy.fo.model.SimpleEnchantment;
import org.mineacademy.fo.remain.Remain;

public class BurstEnchantment extends SimpleEnchantment implements Listener {

	@Getter
	private final static Enchantment instance = new BurstEnchantment();

	private BurstEnchantment() {
		super("Burst", 4);
	}

	@Override
	public EnchantmentTarget getItemTarget() {
		return EnchantmentTarget.BOW;
	}

	@Override
	public boolean conflictsWith(final Enchantment other) {
		return super.conflictsWith(SimpleEnchantment.getByKey(Berserker.getInstance().getKey()));
	}


	@Override
	protected void onShoot(final int level, final LivingEntity shooter, final ProjectileLaunchEvent event) {
		if (!(event.getEntity().getShooter() instanceof Player)) {
			return;
		}

		if (shooter instanceof Player) {
			final Player player = (Player) shooter;
			final int cooldown = Remain.getCooldown(player, Material.BOW);

			// if statement for if multi_arrow is enabled in config

			if (level == 1) {
				if (RandomUtil.chance(10)) {
					if (((Player) shooter).getInventory().getItemInMainHand().getEnchantments().containsKey(Enchantment.getByKey(BurstEnchantment.getInstance().getKey()))) {

						Common.runLater(5, () -> player.launchProjectile(Arrow.class));
						Common.runLater(8, () -> player.launchProjectile(Arrow.class));
						Common.runLater(11, () -> player.launchProjectile(Arrow.class));
					}
				}

			} else if (level == 2) {
				if (RandomUtil.chance(15)) {
					if (((Player) shooter).getInventory().getItemInMainHand().getEnchantments().containsKey(Enchantment.getByKey(BurstEnchantment.getInstance().getKey()))) {

						Common.runLater(5, () -> player.launchProjectile(Arrow.class));
						Common.runLater(8, () -> player.launchProjectile(Arrow.class));
						Common.runLater(11, () -> player.launchProjectile(Arrow.class));
						Common.runLater(13, () -> player.launchProjectile(Arrow.class));
						Common.runLater(16, () -> player.launchProjectile(Arrow.class));
					}
				}

			} else if (level == 3) {
				if (RandomUtil.chance(20)) {
					if (((Player) shooter).getInventory().getItemInMainHand().getEnchantments().containsKey(Enchantment.getByKey(BurstEnchantment.getInstance().getKey()))) {

						Common.runLater(5, () -> player.launchProjectile(Arrow.class));
						Common.runLater(8, () -> player.launchProjectile(Arrow.class));
						Common.runLater(11, () -> player.launchProjectile(Arrow.class));
						Common.runLater(13, () -> player.launchProjectile(Arrow.class));
						Common.runLater(16, () -> player.launchProjectile(Arrow.class));
					}
				}
			}
		}
	}
}
