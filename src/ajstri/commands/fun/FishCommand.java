package ajstri.commands.fun;

import ajstri.Category;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

@Command(aliases={"fish"}, category=Category.FUN, permission="ajstri.fish", description="Fish Command")
public class FishCommand implements ICommand {

	@Override
	public void execute(ExtendedMessageReceivedEvent e, String[] args) {
		e.sendMessage("Fish, fish! Everyone gets a fish! :fish:");
	}
	
}
