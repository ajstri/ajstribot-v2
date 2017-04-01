package ajstri.commands.fun;

import ajstri.Category;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

public class BanHammerCommand extends ICommand {

	public BanHammerCommand() {
		super("banhammer");
		setDescription("Drop the ban hammer");
		setCategory(Category.FUN);
		setPermissions("ajstri.fun.banhammer");
	}
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		e.sendMessage("I can drop the BAN HAMMER on you!");
	}
	
}
