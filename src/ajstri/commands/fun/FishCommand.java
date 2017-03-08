package ajstri.commands.fun;

import ajstri.Category;
import ajstri.commands.ICommand;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.message.ExtendedMessageReceivedEvent;

@Command(aliases={"fish"}, permission="ajstri.fish", description="Fish Command")
public class FishCommand implements ICommand {

	@Override
	public void execute(ExtendedMessageReceivedEvent e, String[] args) {
		e.sendMessage("Fish, fish! Everyone gets a fish! :fish:");
	}

	@Override
	public Category setCategory() {
		return Category.Fun;
	}
}
