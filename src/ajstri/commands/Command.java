package ajstri.commands;

import ajstri.Category;
import net.dv8tion.jda.core.Permission;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.message.ExtendedMessageReceivedEvent;

public abstract class Command extends ICommand {

	public Command(String[] names, String permission, boolean guildOnly) {
		super(names, permission, guildOnly);
	}
	
	public Command(String[] names, Permission permission, boolean guildOnly) {
		super(names, permission, guildOnly);
	}
	
	@Override
	public abstract void execute(ExtendedMessageReceivedEvent e);
	
	public abstract String setCommandInfo();
	public abstract Category setCategory();
	
}
