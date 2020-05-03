package sizzlingfern.extraenchantments.menus.packeges;

import lombok.Getter;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.fo.menu.Menu;
import sizzlingfern.extraenchantments.menus.RuneStoneInformationMenu;


public class HelmetInformation extends Menu {

	@Getter
	private static final HelmetInformation instance = new HelmetInformation();

	private HelmetInformation() {
		super(RuneStoneInformationMenu.getInstance());
		setSize(9 * 1);

	}

	@Override
	public ItemStack getItemAt(final int slot) {
//		if (slot == 0)
//			return ItemCreator.of(CompMaterial.PRISMARINE_SHARD).build().make();


		return null;

	}
}
