package sizzlingfern.extraenchantments.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.model.SimpleEnchantment;
import sizzlingfern.extraenchantments.enchantments.*;

import java.util.ArrayList;
import java.util.Objects;

public class ClickDropListener implements Listener {

	// Create a InventoryClickEvent to listen to all the events happening in the inventory
	@EventHandler
	public void onInventoryClick(final InventoryClickEvent event) {
		final ItemStack shard = event.getCursor();
		final ItemStack target = event.getCurrentItem();
		final Player player = (Player) event.getWhoClicked();

		// Checks if the item you are holding isn't a PRISMARINE_SHARD returns
		if (!shard.getType().equals(Material.PRISMARINE_SHARD)) {
			return;
		}

		// Checks if you are holding a item
		if (shard!=null && !shard.getType().equals(Material.AIR)) {

			// Checks if the item you are holding is a PRISMARINE_SHARD and if it has itemMeta
			if (shard.getType().equals(Material.PRISMARINE_SHARD) && shard.hasItemMeta()) {

				// Checks if there is another item you are clicking on
				if (!target.getType().equals(Material.AIR) && target != null) {
					final Material weapon = target.getType();

					final boolean bowMaterialType = (weapon.equals(Material.BOW));
					final boolean swordMaterialType = weapon.equals(Material.DIAMOND_SWORD) || weapon.equals(Material.GOLDEN_SWORD) || weapon.equals(Material.IRON_SWORD)
							|| weapon.equals(Material.WOODEN_SWORD) || weapon.equals(Material.STONE_SWORD);
					final boolean axeMaterialType = (weapon.equals(Material.WOODEN_AXE) || weapon.equals(Material.STONE_AXE) || weapon.equals(Material.IRON_AXE) ||
							weapon.equals(Material.GOLDEN_AXE) || weapon.equals(Material.DIAMOND_AXE) || weapon.equals(Material.DIAMOND_SWORD));
					final boolean chestplateMaterialType = (weapon.equals(Material.DIAMOND_CHESTPLATE) || weapon.equals(Material.GOLDEN_CHESTPLATE) || weapon.equals(Material.CHAINMAIL_CHESTPLATE)
							|| weapon.equals(Material.IRON_CHESTPLATE) || weapon.equals(Material.LEATHER_CHESTPLATE));
					final boolean bootsMaterialType = weapon.equals(Material.DIAMOND_BOOTS) || weapon.equals(Material.GOLDEN_BOOTS) || weapon.equals(Material.CHAINMAIL_BOOTS)
							|| weapon.equals(Material.IRON_BOOTS) || weapon.equals(Material.LEATHER_BOOTS);



					// Checks if the item you are holding has the enchantment
					if (shard.getItemMeta().getEnchants().containsKey(SimpleEnchantment.getByKey(Berserker.getInstance().getKey()))) {

						// Checks if the other item is a certian type, created a boolean above for easy use
						if (axeMaterialType) {

							if (!(target.getEnchantments().containsKey(SimpleEnchantment.getByKey(Berserker.getInstance().getKey())))) {

								//cancel the inventoryClickEvent
								event.setCancelled(true);
								event.setCursor(new ItemStack(event.getCursor().getType(), event.getCursor().getAmount() - 1));
								// Remove the Prismarine Shard you are holding

								final ItemMeta meta = target.getItemMeta();
								final ArrayList<String> lore = new ArrayList<>();

								lore.add(" ");
								meta.setLore(lore);

								// Add the enchantment from the PRISMARINE_SHARD to the other item
								target.addUnsafeEnchantment(Berserker.getInstance(), shard.getEnchantmentLevel(Objects.requireNonNull(SimpleEnchantment.getByKey(Berserker.getInstance().getKey()))));
							} else {
								Common.tell(player, "&4[&8ShadowRelics&4] &cThis item already has this enchantment!");
							}
						} else {
							// If the other item isn't not the same as stated above in the boolean send a message to the player it can't be aplied to the item
							Common.tell(player, "&4&l[&8&lShadowRelics&4&l] &c&lThis rune can only be aplied on a axe!");
						}
					}

					// Checks if the item you are holding has the enchantment
					if (shard.getItemMeta().getEnchants().containsKey(SimpleEnchantment.getByKey(BurstEnchantment.getInstance().getKey()))) {

						// Checks if the other item is a certian type, created a boolean above for easy use
						if (bowMaterialType) {

							if (!(target.getEnchantments().containsKey(SimpleEnchantment.getByKey(BurstEnchantment.getInstance().getKey())))) {
								//cancel the inventoryClickEvent
								event.setCancelled(true);
								event.setCursor(new ItemStack(event.getCursor().getType(), event.getCursor().getAmount() - 1));
								// Remove the Prismarine Shard you are holding

								final ItemMeta meta = target.getItemMeta();
								final ArrayList<String> lore = new ArrayList<>();

								lore.add(" ");
								meta.setLore(lore);

								// Add the enchantment from the PRISMARINE_SHARD to the other item
								target.addUnsafeEnchantment(BurstEnchantment.getInstance(), shard.getEnchantmentLevel(Objects.requireNonNull(SimpleEnchantment.getByKey(BurstEnchantment.getInstance().getKey()))));
							} else {
								Common.tell(player, "&4[&8ShadowRelics&4] &cThis item already has this enchantment!");
							}
						} else {
							// If the other item isn't not the same as stated above in the boolean send a message to the player it can't be aplied to the item
							Common.tell(player, "&4&l[&8&lShadowRelics&4&l] &c&lThis rune can only be aplied on a bow!");
						}
					}

					// Checks if the item you are holding has the enchantment
					if (shard.getItemMeta().getEnchants().containsKey(SimpleEnchantment.getByKey(GlowEnchantment.getInstance().getKey()))) {

						// Checks if the other item is a certian type, created a boolean above for easy use
						if (chestplateMaterialType) {

							if (!(target.getEnchantments().containsKey(SimpleEnchantment.getByKey(GlowEnchantment.getInstance().getKey())))) {
								//cancel the inventoryClickEvent
								event.setCancelled(true);
								event.setCursor(new ItemStack(event.getCursor().getType(), event.getCursor().getAmount() - 1));
								// Remove the Prismarine Shard you are holding

								final ItemMeta meta = target.getItemMeta();
								final ArrayList<String> lore = new ArrayList<>();

								lore.add(" ");
								meta.setLore(lore);

								// Add the enchantment from the PRISMARINE_SHARD to the other item
								target.addUnsafeEnchantment(GlowEnchantment.getInstance(), shard.getEnchantmentLevel(Objects.requireNonNull(SimpleEnchantment.getByKey(GlowEnchantment.getInstance().getKey()))));
							} else {
								Common.tell(player, "&4[&8ShadowRelics&4] &cThis item already has this enchantment!");
							}

						} else {
							// If the other item isn't not the same as stated above in the boolean send a message to the player it can't be aplied to the item
							Common.tell(player, "&4&l[&8&lShadowRelics&4&l] &c&lThis rune can only be aplied on a chestplate!");
						}
					}

					// Checks if the item you are holding has the enchantment
					if (shard.getItemMeta().getEnchants().containsKey(SimpleEnchantment.getByKey(HealEnchantment.getInstance().getKey()))) {

						// Checks if the other item is a certian type, created a boolean above for easy use
						if (swordMaterialType) {

							if (!(target.getEnchantments().containsKey(SimpleEnchantment.getByKey(HealEnchantment.getInstance().getKey())))) {
								//cancel the inventoryClickEvent
								event.setCancelled(true);
								event.setCursor(new ItemStack(event.getCursor().getType(), event.getCursor().getAmount() - 1));
								// Remove the Prismarine Shard you are holding

								final ItemMeta meta = target.getItemMeta();
								final ArrayList<String> lore = new ArrayList<>();

								lore.add(" ");
								meta.setLore(lore);

								// Add the enchantment from the PRISMARINE_SHARD to the other item
								target.addUnsafeEnchantment(HealEnchantment.getInstance(), shard.getEnchantmentLevel(Objects.requireNonNull(SimpleEnchantment.getByKey(HealEnchantment.getInstance().getKey()))));
							} else {
								Common.tell(player, "&4[&8ShadowRelics&4] &cThis item already has this enchantment!");
							}
						} else {
							// If the other item isn't not the same as stated above in the boolean send a message to the player it can't be aplied to the item
							Common.tell(player, "&4&l[&8&lShadowRelics&4&l] &c&lThis rune can only be aplied on a sword!");
						}
					}

					// Checks if the item you are holding has the enchantment
					if (shard.getItemMeta().getEnchants().containsKey(SimpleEnchantment.getByKey(NutrisionEnchantment.getInstance().getKey()))) {

						// Checks if the other item is a certian type, created a boolean above for easy use
						if (swordMaterialType) {

							if (!(target.getEnchantments().containsKey(SimpleEnchantment.getByKey(NutrisionEnchantment.getInstance().getKey())))) {
								//cancel the inventoryClickEvent
								event.setCancelled(true);
								event.setCursor(new ItemStack(event.getCursor().getType(), event.getCursor().getAmount() - 1));
								// Remove the Prismarine Shard you are holding

								final ItemMeta meta = target.getItemMeta();
								final ArrayList<String> lore = new ArrayList<>();

								lore.add(" ");
								meta.setLore(lore);

								// Add the enchantment from the PRISMARINE_SHARD to the other item
								target.addUnsafeEnchantment(NutrisionEnchantment.getInstance(), shard.getEnchantmentLevel(Objects.requireNonNull(SimpleEnchantment.getByKey(NutrisionEnchantment.getInstance().getKey()))));
							} else {
								Common.tell(player, "&4[&8ShadowRelics&4] &cThis item already has this enchantment!");
							}
						} else {
							// If the other item isn't not the same as stated above in the boolean send a message to the player it can't be aplied to the item
							Common.tell(player, "&4&l[&8&lShadowRelics&4&l] &c&lThis rune can only be aplied on a sword!");
						}
					}

					// Checks if the item you are holding has the enchantment
					if (shard.getItemMeta().getEnchants().containsKey(SimpleEnchantment.getByKey(SpeedEnchantment.getInstance().getKey()))) {

						// Checks if the other item is a certian type, created a boolean above for easy use
						if (bootsMaterialType) {

							if (!(target.getEnchantments().containsKey(SimpleEnchantment.getByKey(SpeedEnchantment.getInstance().getKey())))) {
								//cancel the inventoryClickEvent
								event.setCancelled(true);
								event.setCursor(new ItemStack(event.getCursor().getType(), event.getCursor().getAmount() - 1));
								// Remove the Prismarine Shard you are holding

								final ItemMeta meta = target.getItemMeta();
								final ArrayList<String> lore = new ArrayList<>();

								lore.add(" ");
								meta.setLore(lore);

								// Add the enchantment from the PRISMARINE_SHARD to the other item
								target.addUnsafeEnchantment(SpeedEnchantment.getInstance(), shard.getEnchantmentLevel(Objects.requireNonNull(SimpleEnchantment.getByKey(SpeedEnchantment.getInstance().getKey()))));
							} else {
								Common.tell(player, "&4[&8ShadowRelics&4] &cThis item already has this enchantment!");
							}
						} else {
							// If the other item isn't not the same as stated above in the boolean send a message to the player it can't be aplied to the item
							Common.tell(player, "&4&l[&8&lShadowRelics&4&l] &c&lThis rune can only be aplied on a sword!");
						}
					}

					// Checks if the item you are holding has the enchantment
					if (shard.getItemMeta().getEnchants().containsKey(SimpleEnchantment.getByKey(ViperEnchantment.getInstance().getKey()))) {

						// Checks if the other item is a certian type, created a boolean above for easy use
						if (swordMaterialType) {

							if (!(target.getEnchantments().containsKey(SimpleEnchantment.getByKey(ViperEnchantment.getInstance().getKey())))) {
								//cancel the inventoryClickEvent
								event.setCancelled(true);
								event.setCursor(new ItemStack(event.getCursor().getType(), event.getCursor().getAmount() - 1));
								// Remove the Prismarine Shard you are holding

								final ItemMeta meta = target.getItemMeta();
								final ArrayList<String> lore = new ArrayList<>();

								lore.add(" ");
								meta.setLore(lore);

								// Add the enchantment from the PRISMARINE_SHARD to the other item
								target.addUnsafeEnchantment(ViperEnchantment.getInstance(), shard.getEnchantmentLevel(Objects.requireNonNull(SimpleEnchantment.getByKey(ViperEnchantment.getInstance().getKey()))));
							} else {
								Common.tell(player, "&4[&8ShadowRelics&4] &cThis item already has this enchantment!");
							}
						} else {
							// If the other item isn't not the same as stated above in the boolean send a message to the player it can't be aplied to the item
							Common.tell(player, "&4&l[&8&lShadowRelics&4&l] &c&lThis rune can only be aplied on a sword!");
						}
					}
				}
			}
		}
	}
}
