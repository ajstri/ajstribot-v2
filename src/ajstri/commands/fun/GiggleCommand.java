package ajstri.commands.fun;

import ajstri.Category;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

@Command(aliases={"giggle"}, category=Category.FUN, description="Giggles!")
public class GiggleCommand implements ICommand {

	@Override
	public void execute(ExtendedMessageReceivedEvent e, String[] args) {
		e.sendMessage("*giggles*");
	}

}
