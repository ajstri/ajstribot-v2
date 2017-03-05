package ajstri.commands;

import ajstri.Category;
import net.dv8tion.jda.core.Permission;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.message.ExtendedMessageReceivedEvent;

public abstract class Command extends ICommand {
	
	public Command(String permission, boolean guildOnly, String name) {
		super(name, permission, guildOnly);
	}

	public Command(Permission permission, boolean guildOnly, String name) {
		super(name, permission, guildOnly);
	}
	
	public Command(String permission, boolean guildOnly, String... names) {
		super(permission, guildOnly, names);
	}

	public Command(Permission permission, boolean guildOnly, String... names) {
		super(permission, guildOnly, names);
	}
	
	@Override
	public abstract void execute(ExtendedMessageReceivedEvent e);
	
	public abstract String setCommandInfo();
	public abstract Category setCategory();
}
