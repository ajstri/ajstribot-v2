package ajstri.commands.fun;

import ajstri.Category;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

@Command(aliases={"cry"}, category=Category.FUN, permissions={"ajstri.fun.cry"}, description="I cry every time")
public class CryCommand implements ICommand {

	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		e.sendMessage("*cries*");
	}
	
}
