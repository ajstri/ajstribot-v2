package ajstri.commands.fun;

import ajstri.Category;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

public class FishCommand extends ICommand {

	public FishCommand() {
		super("fish");
		setDescription("Fish, fish! :3");
		setPermissions("ajstri.fun.fish");
		setCategory(Category.FUN);
	}
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		e.sendMessage("Fish, fish! Everyone gets a fish! :fish:");
	}
	
}
