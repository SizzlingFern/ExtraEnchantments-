package sizzlingfern.extraenchantments.commands;

import org.mineacademy.fo.command.SimpleCommand;
import sizzlingfern.extraenchantments.menus.CmdMenu;

public class RelicCommand extends SimpleCommand {

	public RelicCommand() {
		super("relic");
		setPermission(null);
	}

	@Override
	protected void onCommand() {
		checkConsole();

		new CmdMenu().displayTo(getPlayer());
	}
}
