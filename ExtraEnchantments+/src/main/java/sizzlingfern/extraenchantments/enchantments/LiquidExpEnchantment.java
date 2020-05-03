package sizzlingfern.extraenchantments.enchantments;

import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.mineacademy.fo.model.SimpleEnchantment;

public class LiquidExpEnchantment extends SimpleEnchantment {

	@Getter
	private static final Enchantment instance = new LiquidExpEnchantment();

	private LiquidExpEnchantment() {
		super("Liquid EXP", 1);

	}

	@Override
	protected void onBreakBlock(final int level, final BlockBreakEvent event) {
		if (event.getBlock().getType().equals(Material.COAL_ORE)) {
			final Player player = event.getPlayer();
			final int integer = 2;

			player.setExp(player.getExp() + integer);
		}
		if (event.getBlock().getType().equals(Material.DIAMOND_ORE)) {
			final Player player = event.getPlayer();
			final int integer = 5;

			player.setExp(player.getExp() + integer);
		}
		if (event.getBlock().getType().equals(Material.REDSTONE_ORE)) {
			final Player player = event.getPlayer();
			final int integer = 3;

			player.setExp(player.getExp() + integer);
		}
	}
}
