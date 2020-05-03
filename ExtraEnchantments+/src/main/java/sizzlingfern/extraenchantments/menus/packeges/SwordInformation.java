package sizzlingfern.extraenchantments.menus.packeges;

import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.mineacademy.fo.menu.Menu;
import sizzlingfern.extraenchantments.menus.RuneStoneInformationMenu;

import java.util.ArrayList;

public class SwordInformation extends Menu {

	@Getter
	private static final SwordInformation instance = new SwordInformation();

	private SwordInformation() {
		super(RuneStoneInformationMenu.getInstance());
		setSize(9 * 1);

	}

	@Override
	public ItemStack getItemAt(final int slot) {

//######################################################################################################################
		final ItemStack Shard1 = new ItemStack(Material.PRISMARINE_SHARD, 1);

		final ItemMeta shard_meta1 = Shard1.getItemMeta();
		final ArrayList<String> lore1 = new ArrayList<String>();

		shard_meta1.addEnchant(Enchantment.MENDING, 1, true);
		shard_meta1.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		// shard_meta1.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

		Shard1.setItemMeta(shard_meta1);

		lore1.add("");
		lore1.add(ChatColor.GRAY + "When equiped on a sword it can");
		lore1.add(ChatColor.GRAY + "heal by " + ChatColor.YELLOW + "" + ChatColor.UNDERLINE + "right clicking" + ChatColor.GRAY + " and");
		lore1.add(ChatColor.YELLOW + "" + ChatColor.UNDERLINE  + "sneaking" + ChatColor.GRAY + " at the same time.");

		shard_meta1.setLore(lore1);
		shard_meta1.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Heal");

		Shard1.setItemMeta(shard_meta1);
//######################################################################################################################
		if (slot == 0)
			return Shard1;
//######################################################################################################################
		final ItemStack Shard2 = new ItemStack(Material.PRISMARINE_SHARD, 1);

		final ItemMeta shard_meta2 = Shard1.getItemMeta();
		final ArrayList<String> lore2 = new ArrayList<String>();

		shard_meta2.addEnchant(Enchantment.MENDING, 1, true);
		shard_meta2.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		// shard_meta1.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

		Shard2.setItemMeta(shard_meta2);

		lore2.add("");
		lore2.add(ChatColor.GRAY + "When equiped on a sword it");
		lore2.add(ChatColor.GRAY + "has a chance to give poison");
		lore2.add(ChatColor.GRAY + "to the player or entity.");

		shard_meta2.setLore(lore2);
		shard_meta2.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Viper");

		Shard2.setItemMeta(shard_meta2);
//######################################################################################################################
		if (slot == 1)
			return Shard2;

		return null;
	}

	@Override
	protected boolean addReturnButton() {
		return super.addReturnButton();
	}
}
