package ajstri.commands.fun;

import ajstri.Category;
import ajstri.commands.ICommand;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.message.ExtendedMessageReceivedEvent;

@Command(aliases={"cry"}, description="I cry every time")
public class CryCommand implements ICommand {

	@Override
	public void execute(ExtendedMessageReceivedEvent e, String[] args) {
		e.sendMessage("*cries*");
	}

	@Override
	public Category setCategory() {
		return Category.Fun;
	}
	
}
