package sizzlingfern.extraenchantments;

import org.mineacademy.fo.Common;
import org.mineacademy.fo.plugin.SimplePlugin;
import sizzlingfern.extraenchantments.commands.RelicCommand;
import sizzlingfern.extraenchantments.listeners.ClickDropListener;
import sizzlingfern.extraenchantments.listeners.JoinListener;
import sizzlingfern.extraenchantments.listeners.PlayerDeathListener;

public class ExtraEnchantmentsPlugin extends SimplePlugin {

	@Override
	protected void onPluginStart() {
		Common.log("		 ___   ___									");
		Common.log("		|__	  |__		&2ExtraEnchantments+ v1.0.1	");
		Common.log("		|___  |___   	&2Start Successful!			");
		Common.log("													");

//		runnableAdd();

		registerEvents(new JoinListener());
		registerEvents(new ClickDropListener());
		registerEvents(new PlayerDeathListener());

		registerCommand(new RelicCommand());
	}

	@Override
	protected void onPluginStop() {
		cleanBeforeReload();
	}

	@Override
	protected void onPluginReload() {
		cleanBeforeReload();
	}

	private void cleanBeforeReload() {

	}

//########################################## NightVision Runnable ######################################################
//
//	public void runnableAdd() {
//		new BukkitRunnable() {
//			@Override
//			public void run() {
//				for (final Player player : Bukkit.getOnlinePlayers()) {
//					final ItemStack item = player.getEquipment().getHelmet();
//
//					if (item != null) {
//						if (item.getItemMeta() != null) {
//							if (item.getEnchantments().containsKey(Enchantment.getByKey(NightVision.getInstance().getKey()))) {
//								player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 30 * 20, 0), true);
//								//runnableAdd();
//							}
//						}
//					}
//				}
//			}
//		}.runTaskLater(this, 5 * 20);
//	}
//	@EventHandler
//	public void onInventory(final PlayerMoveEvent event) {
//		final Player player = event.getPlayer();
//		final ItemStack item = player.getEquipment().getHelmet();
//
//		if (item != null) {
//			if (item.getItemMeta() != null) {
//				runnableAdd();
//			}
//		}
//	}

//######################################################################################################################

}
