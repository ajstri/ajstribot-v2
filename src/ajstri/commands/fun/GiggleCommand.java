package ajstri.commands.fun;

import ajstri.Category;
import ajstri.commands.ICommand;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

@Command(aliases={"giggle"}, description="Giggles!")
public class GiggleCommand implements ICommand {

	@Override
	public void execute(ExtendedMessageReceivedEvent e, String[] args) {
		e.sendMessage("*giggles*");
	}

	@Override
	public Category setCategory() {
		return Category.Fun;
	}

}
