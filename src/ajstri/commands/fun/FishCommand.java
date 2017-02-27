package ajstri.commands.fun;

import ajstri.Category;
import ajstri.commands.Command;
import quack.ddbl.core.message.ExtendedMessageReceivedEvent;

public class FishCommand extends Command {

	public FishCommand() {
		super(new String[]{"fish"}, EVERYONE, false);
	}

	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		e.sendMessage("Fish, fish! Everyone gets a fish! :fish:");
	}

	@Override
	public String setCommandInfo() {
		return "Fish Command";
	}

	@Override
	public Category setCategory() {
		return Category.Fun;
	}
}
