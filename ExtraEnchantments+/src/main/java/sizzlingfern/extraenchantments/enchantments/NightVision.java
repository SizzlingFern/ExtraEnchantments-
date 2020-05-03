package sizzlingfern.extraenchantments.enchantments;//package org.shadowrealm.enchants;
//
//import org.bukkit.entity.LivingEntity;
//import org.bukkit.event.Listener;
//import org.bukkit.event.entity.EntityDamageByEntityEvent;
//import org.mineacademy.fo.model.SimpleEnchantment;
//
//public class NightVision extends SimpleEnchantment implements Listener {
//
//	@Getter
//	private static final Enchantment instance = new NightVision();
//
//	private NightVision() {
//		super("Night Vision", 1);
//	}
//
//	@Override
//	public EnchantmentTarget getItemTarget() {
//		return EnchantmentTarget.ARMOR_FEET;
//	}
//
//
//
//	@Override
//	protected void onDamage(final int level, final LivingEntity damager, final EntityDamageByEntityEvent event) {
//
//	}
//
//
////			if (item != null) {
////				if (item.getItemMeta() != null) {
////					if (item.getEnchantments().containsKey(Enchantment.getByKey(NightVision.getInstance().getKey()))) {
////						player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 0));
////					}
////					if (!item.getEnchantments().containsKey(Enchantment.getByKey(NightVision.getInstance().getKey())) || item.getItemMeta() == null) {
////						for(final PotionEffect effect : player.getActivePotionEffects()) {
////							if (effect.getType().equals(PotionEffectType.NIGHT_VISION)) {
////								player.removePotionEffect(effect.getType());
////							}
////						}
////					}
////				}
////			}
////	}
//
//}
