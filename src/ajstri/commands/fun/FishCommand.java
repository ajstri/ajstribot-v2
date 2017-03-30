package ajstri.commands.fun;

import ajstri.Category;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

@Command(aliases={"fish"}, category=Category.FUN, permissions={"ajstri.fun.fish"}, description="Fish Command")
public class FishCommand implements ICommand {

	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		e.sendMessage("Fish, fish! Everyone gets a fish! :fish:");
	}
	
}
