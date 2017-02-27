package ajstri.commands.fun;

import ajstri.Category;
import ajstri.commands.Command;
import quack.ddbl.core.message.ExtendedMessageReceivedEvent;

public class BanHammerCommand extends Command {

	public BanHammerCommand() {
		super(new String[]{"banhammer"}, EVERYONE, false);
	}

	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		e.sendMessage("I can drop the BAN HAMMER on you!");
	}

	@Override
	public String setCommandInfo() {
		return "Drop the ban hammer.";
	}

	@Override
	public Category setCategory() {
		return Category.Fun;
	}
	
}
