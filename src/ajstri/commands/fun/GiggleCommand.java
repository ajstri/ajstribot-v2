package ajstri.commands.fun;

import ajstri.Category;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

//@Command(aliases={"giggle"}, category=Category.FUN, permissions={"ajstri.fun.giggle"}, description="Giggles!")
public class GiggleCommand extends ICommand {

	public GiggleCommand() {
		super("giggle");
		setCategory(Category.FUN);
		setDescription("Giggles!");
		setPermissions("ajstri.fun.giggle");
	}
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		e.sendMessage("*giggles*");
	}

}
