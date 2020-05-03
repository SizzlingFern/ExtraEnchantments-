package sizzlingfern.extraenchantments.menus;

import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.menu.Menu;
import org.mineacademy.fo.menu.button.Button;
import org.mineacademy.fo.menu.button.ButtonMenu;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.remain.CompMaterial;

public class CmdMenu extends Menu {

	@Getter
	private static final CmdMenu instance = new CmdMenu();

	private final Button relicInfo;
	private final Button relicBuy;

	public CmdMenu() {
		setSize(9 * 4);
		setSlotNumbersVisible();

		setTitle("Relics");

		relicInfo = new ButtonMenu(RuneStoneInformationMenu.getInstance(), ItemCreator.of(CompMaterial.DIAMOND_CHESTPLATE, ChatColor.AQUA + "" + ChatColor.BOLD + "Relics",
				"",
				"Relic are overpowered items that have",
				"custom, cool and unique abilities.",
				"",
				"Can be found through:"
		).glow(true).build().make());

		relicBuy = new ButtonMenu(RunestoneBuyMenu.getInstance(), ItemCreator.of(CompMaterial.PRISMARINE_SHARD, ChatColor.AQUA +"" +ChatColor.BOLD + "Runestones",
				""
		).glow(true).build().make());

	}

	@Override
	public ItemStack getItemAt(final int slot) {
		if (slot == 9 * 1 + 2)
			return relicInfo.getItem();

		if (slot == 9 * 1 + 4)
			return relicBuy.getItem();

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
						"Welcome to the ",
						"ShadowRelics Menu"
				};
	}

//############################################################################################################################################################################



}
