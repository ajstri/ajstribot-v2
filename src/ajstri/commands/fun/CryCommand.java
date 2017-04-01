package ajstri.commands.fun;

import ajstri.Category;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

public class CryCommand extends ICommand {
	
	public CryCommand() {
		super("cry");
		setDescription("I cry every time");
		setCategory(Category.FUN);
		setPermissions("ajstri.fun.cry");
	}
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		e.sendMessage("*cries*");
	}
	
}
