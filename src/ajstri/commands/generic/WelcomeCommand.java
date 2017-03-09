package ajstri.commands.generic;

import ajstri.Category;
import ajstri.commands.ICommand;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

@Command(aliases={"welcome"}, description="Welcome, let's get started!")
public class WelcomeCommand implements ICommand {

	@Override
	public void execute(ExtendedMessageReceivedEvent e, String[] args) {
		e.sendPrivateMessage(e.getAuthor(), 
				"Hi! I am AJStriBot. " +
				"Thanks for choosing me! " +
				"One of my Commands, `/ban`, requires me to be higher in " +
				"the heirarchy than the member to be kicked. Keep this in mind! " +
				"Admin commands are sorted by default. If you have Administrative privilages, " +
				"you can use them in a guild! \n" +
				"Type `/help` to begin...");
	}

	@Override
	public Category setCategory() {
		return Category.Generic;
	}

}
