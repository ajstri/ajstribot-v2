package ajstri.commands.generic;

import ajstri.Category;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

public class WelcomeCommand extends ICommand {

	public WelcomeCommand() {
		super("welcome");
		setCategory(Category.GENERIC);
		setDescription("Welcome, let's get started!");
		setPermissions("ajstri.generic.welcome");
	}
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		e.sendPrivateMessage(e.getAuthor(), 
				"Hi! I am AJStriBot. " +
				"Thanks for choosing me! " +
				"One of my Commands, `/ban`, requires me to be higher in " +
				"the heirarchy than the member to be kicked. Keep this in mind! " +
				"\n" +
				"Type `/help` to begin...");
	}

}
