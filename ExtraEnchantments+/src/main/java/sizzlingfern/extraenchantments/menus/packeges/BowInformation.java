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

public class BowInformation extends Menu {

	@Getter
	private final static BowInformation instance = new BowInformation();

	private BowInformation() {
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
		lore1.add(ChatColor.GRAY + "When equiped on a bow has a");
		lore1.add(ChatColor.GRAY + "chance to shoot multiple arrows");

		shard_meta1.setLore(lore1);
		shard_meta1.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Burst");

		Shard1.setItemMeta(shard_meta1);
//######################################################################################################################

		if (slot == 0)
			return Shard1;

		return null;
	}

	@Override
	protected boolean addReturnButton() {
		return super.addReturnButton();
	}
}
