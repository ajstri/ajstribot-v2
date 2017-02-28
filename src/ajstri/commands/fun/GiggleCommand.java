package ajstri.commands.fun;

import ajstri.Category;
import ajstri.commands.Command;
import quack.ddbl.core.message.ExtendedMessageReceivedEvent;

public class GiggleCommand extends Command {

	public GiggleCommand() {
		super(EVERYONE, false, "giggle");
	}

	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		e.sendMessage("*giggles*");
	}

	@Override
	public String setCommandInfo() {
		return "Giggles!";
	}

	@Override
	public Category setCategory() {
		return Category.Fun;
	}

}
