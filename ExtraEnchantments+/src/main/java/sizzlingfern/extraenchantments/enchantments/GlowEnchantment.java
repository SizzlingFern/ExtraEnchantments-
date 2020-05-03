package sizzlingfern.extraenchantments.enchantments;

import lombok.Getter;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.model.SimpleEnchantment;
import org.mineacademy.fo.remain.CompSound;

public class GlowEnchantment extends SimpleEnchantment implements Listener {

	@Getter
	private static final Enchantment instance = new GlowEnchantment();

	private GlowEnchantment() {
		super("Glow" , 1);

	}

	@Override
	public EnchantmentTarget getItemTarget() {
		return EnchantmentTarget.ARMOR_TORSO;
	}

	@EventHandler
	public void onPlayerHit(final EntityDamageByEntityEvent event) {
		if (!(event.getEntity() instanceof LivingEntity))
			return;

		if (event.getDamager() instanceof Player && event.getEntity() instanceof LivingEntity) {
			final Player player = (Player) event.getDamager();
			final ItemStack item = (player.getEquipment()).getChestplate();
			final LivingEntity victim = (LivingEntity) event.getEntity();

			if (item != null) {
				if (item.getItemMeta() != null) {
					if (item.getEnchantments().containsKey(Enchantment.getByKey(GlowEnchantment.getInstance().getKey()))) {
						victim.setGlowing(true);
						CompSound.ANVIL_LAND.play(victim.getLocation());

					}
				}
			}
		}
	}

	@Override
	protected void onDamage(final int level, final LivingEntity damager, final EntityDamageByEntityEvent event) {
	}
}
