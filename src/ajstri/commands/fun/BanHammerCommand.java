package ajstri.commands.fun;

import ajstri.Category;
import ajstri.commands.ICommand;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

@Command(aliases={"banhammer"}, description="Drop the ban hammer.")
public class BanHammerCommand implements ICommand {

	@Override
	public void execute(ExtendedMessageReceivedEvent e, String[] args) {
		e.sendMessage("I can drop the BAN HAMMER on you!");
	}

	@Override
	public Category setCategory() {
		return Category.Fun;
	}
	
}
