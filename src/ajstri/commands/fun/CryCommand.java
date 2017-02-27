package ajstri.commands.fun;

import ajstri.Category;
import ajstri.commands.Command;
import quack.ddbl.core.message.ExtendedMessageReceivedEvent;

public class CryCommand extends Command {

	public CryCommand() {
		super(new String[]{"cry"}, EVERYONE, false);
	}

	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		e.sendMessage("*cries*");
	}

	@Override
	public String setCommandInfo() {
		return "I cry every time";
	}

	@Override
	public Category setCategory() {
		return Category.Fun;
	}
	
}
