package ajstri.commands.fun;

import ajstri.Category;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

@Command(aliases={"giggle"}, category=Category.FUN, permissions={"ajstri.fun.giggle"}, description="Giggles!")
public class GiggleCommand implements ICommand {

	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		e.sendMessage("*giggles*");
	}

}
