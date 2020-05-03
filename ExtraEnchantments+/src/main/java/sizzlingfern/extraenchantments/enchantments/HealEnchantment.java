package sizzlingfern.extraenchantments.enchantments;

import lombok.Getter;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.mineacademy.fo.MathUtil;
import org.mineacademy.fo.model.SimpleEnchantment;
import org.mineacademy.fo.remain.CompParticle;

public class HealEnchantment extends SimpleEnchantment {

	@Getter
	private static final Enchantment instance = new HealEnchantment();

	private HealEnchantment() {
		super("Heal", 1);
	}

	@Override
	public EnchantmentTarget getItemTarget() {
		return EnchantmentTarget.WEAPON;
	}

	@Override
	protected void onInteract(final int level, final PlayerInteractEvent event) {
		final Player player = event.getPlayer();

		if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			return;
		}
		if (player.getInventory().getItemInMainHand().getEnchantments().containsKey(SimpleEnchantment.getByKey(HealEnchantment.getInstance().getKey()))) {

			if (event.getAction().equals(Action.RIGHT_CLICK_AIR) && player.isSneaking()) {
				if (player.getHealth() < 20) {
					final int health = 2;

					player.setHealth(MathUtil.range(player.getHealth() + health, 0 , 20));
					player.setLevel(MathUtil.range(player.getLevel() - 1 , 0 , Integer.MAX_VALUE));
					CompParticle.HEART.spawn(player.getLocation());
					CompParticle.HEART.spawn(player.getLocation().add(0, 0.8 , 0.3));
					CompParticle.HEART.spawn(player.getLocation().add(0, 0.5 , -0.2));

				} else if (player.getHealth() >= 20) {
					player.setHealth(20);
				}
			}
		}
	}
}
