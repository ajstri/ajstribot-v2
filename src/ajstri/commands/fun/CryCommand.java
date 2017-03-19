package ajstri.commands.fun;

import ajstri.Category;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

@Command(aliases={"cry"}, category=Category.FUN, description="I cry every time")
public class CryCommand implements ICommand {

	@Override
	public void execute(ExtendedMessageReceivedEvent e, String[] args) {
		e.sendMessage("*cries*");
	}
	
}
