package sizzlingfern.extraenchantments.enchantments;

import lombok.Getter;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.mineacademy.fo.RandomUtil;
import org.mineacademy.fo.model.SimpleEnchantment;


public class Berserker extends SimpleEnchantment implements Listener {

	// Create a instane to acces this class in other classes
	@Getter
	private static final Enchantment instance = new Berserker();

	// Create a name and set the max level
	private Berserker() {
		super("Berserker", 4);
	}

	// Set the target for the enchantment
	@Override
	public EnchantmentTarget getItemTarget() {
		return EnchantmentTarget.WEAPON;
	}

	// Create a EntityDamageEvent to listen when a player hits another entity
	@EventHandler
	public  void onPlayerDamage(final EntityDamageEvent event) {
		if (event.getEntity() instanceof Player && event.getCause().equals(EntityDamageEvent.DamageCause.BLOCK_EXPLOSION)) {
			event.setCancelled(true);
		}
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
				if(RandomUtil.chance(5)) {
					if (player.getInventory().getItemInMainHand().getEnchantments().containsKey(Enchantment.getByKey(Berserker.getInstance().getKey()))) {
						victim.getLocation().getWorld().createExplosion(event.getEntity().getLocation(), 1, false, false);

					}
				}
			}
			if (level == 2) {
				if(RandomUtil.chance(15)) {
					if (player.getInventory().getItemInMainHand().getEnchantments().containsKey(Enchantment.getByKey(Berserker.getInstance().getKey()))) {
						victim.getLocation().getWorld().createExplosion(event.getEntity().getLocation(), 1, false, false);

					}
				}
			}
			if (level == 3) {
				if(RandomUtil.chance(10)) {
					if (player.getInventory().getItemInMainHand().getEnchantments().containsKey(Enchantment.getByKey(Berserker.getInstance().getKey()))) {
						victim.getLocation().getWorld().createExplosion(event.getEntity().getLocation(), 1, false, false);
						victim.setVelocity(victim.getEyeLocation().getDirection().setY(- 2));
					}
				}
			}
			if (level == 4) {
				if(RandomUtil.chance(15)) {
					if (player.getInventory().getItemInMainHand().getEnchantments().containsKey(Enchantment.getByKey(Berserker.getInstance().getKey()))) {
						victim.getLocation().getWorld().createExplosion(event.getEntity().getLocation(), 1, false, false);
						victim.setVelocity(victim.getEyeLocation().getDirection().setY(- 4));
					}
				}
			}
 		}
	}

//######################################################################################################################
//
//	@EventHandler
//	public void onInventoryClick(final InventoryClickEvent event) {
//		final ItemStack shard = event.getCursor();
//		final ItemStack target = event.getCurrentItem();
//		final Material weapon = target.getType();
//		final Player player = (Player) event.getWhoClicked();
//
//
//		if (shard.getType().equals(Material.PRISMARINE_SHARD)) {
//			Bukkit.broadcastMessage("You are holding a shard with Berserker enchantment");
//			if (shard.getItemMeta().getEnchants().containsKey(SimpleEnchantment.getByKey(Berserker.getInstance().getKey()))) {
//				Bukkit.broadcastMessage("You are holding a shard with Berserker");
//				if (!target.getType().equals(Material.AIR) && target != null) {
//					Bukkit.broadcastMessage("There is a other item");
//					if (weapon.equals(Material.WOODEN_AXE) || weapon.equals(Material.STONE_AXE) || weapon.equals(Material.IRON_AXE) ||
//							weapon.equals(Material.GOLDEN_AXE) || weapon.equals(Material.DIAMOND_AXE) || weapon.equals(Material.DIAMOND_SWORD)) {
//
//						Bukkit.broadcastMessage("the other item is a axe");
//
//						event.setCancelled(true);
//						event.setCursor(new ItemStack(event.getCursor().getType(), event.getCursor().getAmount() - 1));
//						Bukkit.broadcastMessage("##############################");
//
//
//						final ItemMeta meta = target.getItemMeta();
// 						final ArrayList<String> lore = new ArrayList<>();
//
// 						lore.add(" ");
//						meta.setLore(lore);
//
//						target.addUnsafeEnchantment(Berserker.getInstance(), shard.getEnchantmentLevel(Objects.requireNonNull(SimpleEnchantment.getByKey(Berserker.getInstance().getKey()))));
//					}
//				}
//			}
//		}
//	}

}
