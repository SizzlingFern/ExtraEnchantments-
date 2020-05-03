package sizzlingfern.extraenchantments.menus;

import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.menu.Menu;
import org.mineacademy.fo.menu.button.Button;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.model.SimpleEnchant;
import org.mineacademy.fo.remain.CompItemFlag;
import org.mineacademy.fo.remain.CompMaterial;
import org.mineacademy.fo.remain.CompSound;
import sizzlingfern.extraenchantments.enchantments.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RunestoneBuyMenu extends Menu {

	@Getter
	private static final RunestoneBuyMenu instance = new RunestoneBuyMenu();

	private final Button runeStoneInfoButton;
	private final Button commonBuyButton;
	private final Button rareBuyButton;
	private final Button legendaryBuyButton;

	private RunestoneBuyMenu() {
		super(CmdMenu.getInstance());
		setSize(9 * 5);
		setTitle("Relic Shop");
		setSlotNumbersVisible();

		// Button to get common runestones
		commonBuyButton = new Button() {
			@Override
			public void onClickedInMenu(final Player player, final Menu menu, final ClickType clickType) {
				final int integer = 35;

				// Checks if XP level is 35 or higher
				if (player.getLevel() >= 35) {
					player.setLevel(player.getLevel() - integer);	// remove XP levels from player

					//OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
					// Creates a list with items created lower in this class
					final List<ItemStack> commonItemList = new ArrayList<>();
					commonItemList.add(berserkerI);
					commonItemList.add(berserkerI);
					commonItemList.add(burstI);
					commonItemList.add(burstI);
					commonItemList.add(nutrisionI);
					commonItemList.add(nutrisionI);
					commonItemList.add(speedI);
					commonItemList.add(speedI);
					commonItemList.add(viperI);
					commonItemList.add(viperI);
					commonItemList.add(viperII);

					// create a random and add one item from the list above to the players inventory
					final int index = new Random().nextInt(commonItemList.size());
					final ItemStack commonItems = new ItemStack(commonItemList.get(index));
					player.getInventory().addItem(commonItems);
					//OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO

					CompSound.LEVEL_UP.play(player.getLocation());
					Common.tell(player, "&4&l[&8&lShadowRelics&4&l] &a You got a Common Rune!");

					player.closeInventory();
				} else if (player.getLevel() <= 34) {
					// Checks if XP level is lower than 35 if so then send message that they do not have enough XP levels
					Common.tell(player, "&4&l[&8&lShadowRelics&4&l] &c&lYou don't have enough XP levels!");
				}
			}

			// Creates the button in the menu
			@Override
			public ItemStack getItem() {
				return ItemCreator.of(CompMaterial.LIME_STAINED_GLASS_PANE, ChatColor.GREEN + "" + ChatColor.BOLD + "Common",
						ChatColor.AQUA + "Price " + ChatColor.BLUE + ">> " + ChatColor.YELLOW + "35XP Levels"
				).glow(true).build().make();
			}
		};

		// Button to get rare runstones
		rareBuyButton = new Button() {
			@Override
			public void onClickedInMenu(final Player player, final Menu menu, final ClickType clickType) {
				final int integer = 60;

				// Checks if XP level is 60 or higher
				if (player.getLevel() >= 60) {
					player.setLevel(player.getLevel() - integer);	// Removes XP levels from player

					//OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
					// Creates a list with items created lower in this class
					final List<ItemStack> rareItemList = new ArrayList<>();
					rareItemList.add(berserkerII);
					rareItemList.add(berserkerII);
					rareItemList.add(burstII);
					rareItemList.add(burstII);
					rareItemList.add(berserkerIII);
					rareItemList.add(nutrisionII);
					rareItemList.add(nutrisionII);
					rareItemList.add(viperIII);
					rareItemList.add(speedII);
					rareItemList.add(speedII);

					// create a random and add one item from the list above to the players inventory
					final int index = new Random().nextInt(rareItemList.size());
					final ItemStack rareItems = new ItemStack(rareItemList.get(index));
					player.getInventory().addItem(rareItems);
					//OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO

					CompSound.LEVEL_UP.play(player.getLocation());
					Common.tell(player, "&4&l[&8&lShadowRelics&4&l] &a You got a Rare Rune!");

					player.closeInventory();
				} else if (player.getLevel() <= 59) {
					// Checks if XP level is lower than 60 if so then send message that they do not have enough XP levels
					Common.tell(player, "&4&l[&8&lShadowRelics&4&l] &c&lYou don't have enough XP levels!");
				}
			}

			// Creates the button in the menu
			@Override
			public ItemStack getItem() {
				return ItemCreator.of(CompMaterial.BLUE_STAINED_GLASS_PANE, ChatColor.BLUE + "" + ChatColor.BOLD + "Rare",
						ChatColor.AQUA + "Price " + ChatColor.BLUE + ">> " + ChatColor.YELLOW + "60XP Levels"
				).glow(true).build().make();
			}
		};

		// Button to get legendary runstones
		legendaryBuyButton = new Button() {
			@Override
			public void onClickedInMenu(final Player player, final Menu menu, final ClickType clickType) {
				final int integer = 100;

				// Checks if XP level is 60 or higher
				if (player.getLevel() >= 100) {
					player.setLevel(player.getLevel() - integer);	// Removes the XP levels from player

					//OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
					// Creates a list with items created lower in this class
					final List<ItemStack> legendaryItemList = new ArrayList<>();
					legendaryItemList.add(berserkerIII);
					legendaryItemList.add(berserkerIII);	
					legendaryItemList.add(berserkerIV);
					legendaryItemList.add(burstIII);
					legendaryItemList.add(nutrisionIII);
					legendaryItemList.add(glowI);
					legendaryItemList.add(healI);
					legendaryItemList.add(speedIII);
					legendaryItemList.add(speedIV);

					// create a random and add one item from the list above to the players inventory
					final int index = new Random().nextInt(legendaryItemList.size());
					final ItemStack legendaryItems = new ItemStack(legendaryItemList.get(index));
					player.getInventory().addItem(legendaryItems);
					//OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO

					CompSound.LEVEL_UP.play(player.getLocation());
					Common.tell(player, "&4&l[&8&lShadowRelics&4&l] &a You got a Legendary Rune!");

					player.closeInventory();
				} else if (player.getLevel() <= 99) {
					// Checks if XP level is lower than 100 if so then send message that they do not have enough XP levels
					Common.tell(player, "&4&l[&8&lShadowRelics&4&l] &c&lYou don't have enough XP levels!");
				}
			}
			// Creates the button in the menu
			@Override
			public ItemStack getItem() {
				return ItemCreator.of(CompMaterial.ORANGE_STAINED_GLASS_PANE, ChatColor.GOLD + "" + ChatColor.BOLD + "Legendary",
						ChatColor.AQUA + "Price " + ChatColor.BLUE + ">> " + ChatColor.YELLOW + "100XP Levels"
				).glow(true).build().make();
			}
		};

		runeStoneInfoButton = new Button() {
			@Override
			public void onClickedInMenu(final Player player, final Menu menu, final ClickType clickType) {

			}

			@Override
			public ItemStack getItem() {
				return ItemCreator.of(CompMaterial.COMPASS, "&bRunestone buy menu",
						"Here you can buy",
						"runestone with xp levels.").glow(true).build().make();
			}
		};

	}

	// below you can add the items in to the menu and preferd slot
	@Override
	public ItemStack getItemAt(final int slot) {
		if (slot == 9 * 1 + 4)
			return runeStoneInfoButton.getItem();
		if (slot == 9 * 3 + 2)
			return commonBuyButton.getItem();
		if (slot == 9 * 3 + 4)
			return rareBuyButton.getItem();
		if (slot == 9 * 3 + 6)
			return legendaryBuyButton.getItem();


		//########################################
		// To fill all the other slots create a loop and return the item
		for (int i = 0; i < 100; i++) {
			if (slot < 100)
				return ItemCreator.of(CompMaterial.GRAY_STAINED_GLASS_PANE, " ").build().make();
		}

		return null;
	}

	// Creates a infobutton in the lower left corner
	@Override
	protected String[] getInfo() {
		return super.getInfo();
	}

//				##############################################################################################
//				##										  Runestones										##
//				##############################################################################################

	// All the runestones you can buy are created here in order from common --> legendary

		//########################################### Common ###########################################################

		final ItemStack berserkerI = ItemCreator.of(CompMaterial.PRISMARINE_SHARD, "&5&lBerserker I", "", "Drag and drop to aply to an item")
				.enchant(new SimpleEnchant(Berserker.getInstance(), 1))
				.flag(CompItemFlag.HIDE_ENCHANTS).build().make();

		final ItemStack glowI = ItemCreator.of(CompMaterial.PRISMARINE_SHARD, "&5&lGlow I", "", "Drag and drop to aply to an item")
				.enchant(new SimpleEnchant(GlowEnchantment.getInstance(), 1))
				.flag(CompItemFlag.HIDE_ENCHANTS).build().make();

		final ItemStack burstI = ItemCreator.of(CompMaterial.PRISMARINE_SHARD, "&5&lBurst I", "", "Drag and drop to aply to an item")
				.enchant(new SimpleEnchant(BurstEnchantment.getInstance(), 1))
				.flag(CompItemFlag.HIDE_ENCHANTS).build().make();

		final ItemStack nutrisionI = ItemCreator.of(CompMaterial.PRISMARINE_SHARD, "&5&lNutrision I", "", "Drag and drop to aply to an item")
				.enchant(new SimpleEnchant(NutrisionEnchantment.getInstance(), 1))
				.flag(CompItemFlag.HIDE_ENCHANTS).build().make();

		final ItemStack speedI = ItemCreator.of(CompMaterial.PRISMARINE_SHARD, "&5&lSpeed I", "", "Drag and drop to aply to an item")
				.enchant(new SimpleEnchant(SpeedEnchantment.getInstance(), 1))
				.flag(CompItemFlag.HIDE_ENCHANTS).build().make();

		final ItemStack viperI = ItemCreator.of(CompMaterial.PRISMARINE_SHARD, "&5&lViper I", "", "Drag and drop to aply to an item")
				.enchant(new SimpleEnchant(ViperEnchantment.getInstance(), 1))
				.flag(CompItemFlag.HIDE_ENCHANTS).build().make();

		final ItemStack viperII = ItemCreator.of(CompMaterial.PRISMARINE_SHARD, "&5&lViper II", "", "Drag and drop to aply to an item")
				.enchant(new SimpleEnchant(ViperEnchantment.getInstance(), 2))
				.flag(CompItemFlag.HIDE_ENCHANTS).build().make();
		//##############################################################################################################





		//############################################## Rare ##########################################################
		final ItemStack berserkerII = ItemCreator.of(CompMaterial.PRISMARINE_SHARD, "&5&lBerserker II", "", "Drag and drop to aply to an item")
				.enchant(new SimpleEnchant(Berserker.getInstance(), 2))
				.flag(CompItemFlag.HIDE_ENCHANTS).build().make();

		final ItemStack berserkerIII = ItemCreator.of(CompMaterial.PRISMARINE_SHARD, "&5&lBerserker III", "", "Drag and drop to aply to an item")
				.enchant(new SimpleEnchant(Berserker.getInstance(), 3))
				.flag(CompItemFlag.HIDE_ENCHANTS).build().make();

		final ItemStack burstII = ItemCreator.of(CompMaterial.PRISMARINE_SHARD, "&5&lBurst II", "", "Drag and drop to aply to an item")
				.enchant(new SimpleEnchant(BurstEnchantment.getInstance(), 2))
				.flag(CompItemFlag.HIDE_ENCHANTS).build().make();

		final ItemStack nutrisionII = ItemCreator.of(CompMaterial.PRISMARINE_SHARD, "&5&lNutrision II", "", "Drag and drop to aply to an item")
				.enchant(new SimpleEnchant(NutrisionEnchantment.getInstance(), 2))
				.flag(CompItemFlag.HIDE_ENCHANTS).build().make();

		final ItemStack speedII = ItemCreator.of(CompMaterial.PRISMARINE_SHARD, "&5&lSpeed II", "", "Drag and drop to aply to an item")
				.enchant(new SimpleEnchant(SpeedEnchantment.getInstance(), 2))
				.flag(CompItemFlag.HIDE_ENCHANTS).build().make();

		final ItemStack viperIII = ItemCreator.of(CompMaterial.PRISMARINE_SHARD, "&5&lViper III", "", "Drag and drop to aply to an item")
				.enchant(new SimpleEnchant(ViperEnchantment.getInstance(), 3))
				.flag(CompItemFlag.HIDE_ENCHANTS).build().make();
		//##############################################################################################################





		//############################################ Legendary #######################################################
		final ItemStack berserkerIV = ItemCreator.of(CompMaterial.PRISMARINE_SHARD, "&5&lBerserker IV", "", "Drag and drop to aply to an item")
			.enchant(new SimpleEnchant(Berserker.getInstance(), 4))
			.flag(CompItemFlag.HIDE_ENCHANTS).build().make();

		final ItemStack burstIII = ItemCreator.of(CompMaterial.PRISMARINE_SHARD, "&5&lBurst III", "", "Drag and drop to aply to an item")
			.enchant(new SimpleEnchant(BurstEnchantment.getInstance(), 3))
			.flag(CompItemFlag.HIDE_ENCHANTS).flag(CompItemFlag.HIDE_ATTRIBUTES).build().make();

		final ItemStack healI = ItemCreator.of(CompMaterial.PRISMARINE_SHARD, "&5&lHeal", "", "Drag and drop to aply to an item")
				.enchant(new SimpleEnchant(HealEnchantment.getInstance(), 1))
				.flag(CompItemFlag.HIDE_ENCHANTS).build().make();

		final ItemStack nutrisionIII = ItemCreator.of(CompMaterial.PRISMARINE_SHARD, "&5&lNutrision III", "", "Drag and drop to aply to an item")
				.enchant(new SimpleEnchant(NutrisionEnchantment.getInstance(), 3))
				.flag(CompItemFlag.HIDE_ENCHANTS).build().make();

		final ItemStack speedIII = ItemCreator.of(CompMaterial.PRISMARINE_SHARD, "&5&lSpeed III", "", "Drag and drop to aply to an item")
				.enchant(new SimpleEnchant(SpeedEnchantment.getInstance(), 3))
				.flag(CompItemFlag.HIDE_ENCHANTS).build().make();

		final ItemStack speedIV = ItemCreator.of(CompMaterial.PRISMARINE_SHARD, "&5&lSpeed IV", "", "Drag and drop to aply to an item")
				.enchant(new SimpleEnchant(SpeedEnchantment.getInstance(), 4))
				.flag(CompItemFlag.HIDE_ENCHANTS).build().make();
}
