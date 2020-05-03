package sizzlingfern.extraenchantments.menus;

import lombok.Getter;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.menu.Menu;
import org.mineacademy.fo.menu.button.Button;
import org.mineacademy.fo.menu.button.ButtonMenu;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.remain.CompMaterial;
import sizzlingfern.extraenchantments.menus.packeges.*;

public class RuneStoneInformationMenu extends Menu {

	@Getter
	private static final RuneStoneInformationMenu instance = new RuneStoneInformationMenu();

	private final Button goldenHelmet;
	private final Button goldenChestplate;
	private final Button goldenBoots;
	private final Button bow;
	private final Button goldenSword;
	private final Button goldenAxe;

	private final Button buyButton;

	private RuneStoneInformationMenu() {
		super(CmdMenu.getInstance());
		setSize(9*2);

		buyButton = new ButtonMenu(RunestoneBuyMenu.getInstance(), ItemCreator.of(CompMaterial.ENDER_EYE,
				"&b-> Buy menu").glow(true).build().make());

		goldenHelmet = new ButtonMenu(HelmetInformation.getInstance(), ItemCreator.of(CompMaterial.GOLDEN_HELMET, "&bHelmet Enchantments",
				" ",
				"&7Items:",
				" ",
				"&b>>&e&l Leather cap",
				"&b>>&e&l Chainmail Helmet",
				"&b>>&e&l Iron Helmet",
				"&b>>&e&l Gold Helmet",
				"&b>>&e&l Diamond Helmet"
		).build().makeSurvival());

		goldenChestplate = new ButtonMenu(ChestplateInformation.getInstance(), ItemCreator.of(CompMaterial.GOLDEN_CHESTPLATE, "&bChestplate Enchantments",
						" ",
				"&7Items:",
				" ",
				"&b>>&e&l Leather Chestplate",
				"&b>>&e&l Chainmale Chestplate",
				"&b>>&e&l Iron Chestplate",
				"&b>>&e&l Gold Chestplate",
				"&b>>&e&l Diamond Chestplate"
		).build().makeSurvival());

		goldenBoots = new ButtonMenu(BootsInformation.getInstance(), ItemCreator.of(CompMaterial.GOLDEN_BOOTS,  "&bBoots Enchantments",
						" ",
				"&7Items:",
				" ",
				"&b>>&e&l Leather Boots",
				"&b>>&e&l Chainmale Boots",
				"&b>>&e&l Iron Boots",
				"&b>>&e&l Gold Boots",
				"&b>>&e&l Diamond Boots"
		).build().makeSurvival());

		bow = new ButtonMenu(BowInformation.getInstance(), ItemCreator.of(CompMaterial.BOW,  "&BBow Enchantments," +
						" ",
				"&7Items:",
				" ",
				"&b>>&e&l Bow"
		).build().makeSurvival());

		goldenSword = new ButtonMenu(SwordInformation.getInstance(), ItemCreator.of(CompMaterial.GOLDEN_SWORD,  "&bSword Enchantments",
				" ",
				"&7Items:",
				" ",
				"&b>>&e&l Wooden Sword",
				"&b>>&e&l Stone Sword",
				"&b>>&e&l Iron Sword",
				"&b>>&e&l Gold Sword",
				"&b>>&e&l Diamond Sword"
		).build().makeSurvival());

		goldenAxe = new ButtonMenu(AxeInformation.getInstance(), ItemCreator.of(CompMaterial.GOLDEN_AXE,  "&bAxe Enchantments",
				" ",
				"&7Items:",
				" ",
				"&b>>&e&l Wooden Axe",
				"&b>>&e&l Stone Axe",
				"&b>>&e&l Iron Axe",
				"&b>>&e&l Gold Axe",
				"&b>>&e&l Diamond Axe"
		).build().makeSurvival());

	}

	@Override
	public ItemStack getItemAt(final int slot) {
		if (slot == 0)
			return goldenHelmet.getItem();

		if (slot == 1)
			return goldenChestplate.getItem();

		if (slot == 2)
			return goldenBoots.getItem();

		if (slot == 3)
			return bow.getItem();

		if (slot == 4)
			return goldenSword.getItem();

		if (slot == 5)
			return goldenAxe.getItem();

		if (slot == 13)
			return buyButton.getItem();

		//########################################
		for (int i = 0; i < 36; i++) {
			if (slot < 36)
				return ItemCreator.of(CompMaterial.GRAY_STAINED_GLASS_PANE, " ").build().make();
		}

		return null;
	}

	@Override
	protected String[] getInfo() {
		return new String[]
				{
						"Here you can see",
						"which relics belong",
						"to each items"
				};
	}

}

