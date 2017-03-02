package ajstri.commands.generic;

import ajstri.Category;
import ajstri.commands.Command;
import quack.ddbl.core.message.ExtendedMessageReceivedEvent;
import quack.ddbl.core.utils.MessageUtils;

public class WelcomeCommand extends Command {

	public WelcomeCommand() {
		super(EVERYONE, false, "welcome");
	}

	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		if(e.isGuildMessage()) MessageUtils.sendPrivateMessage(e.getAuthor(), 
				"Hi! I am AJStriBot. " +
				"Thanks for choosing me! " +
				"One of my Commands, `/ban`, requires me to be higher in " +
				"the heirarchy than the member to be kicked. Keep this in mind! " +
				"Admin commands are sorted by default. If you have Administrative privilages, " +
				"you can use them in a guild! \n" +
				"Type `/help` to begin...");
	}

	@Override
	public String setCommandInfo() {
		return "Welcome, let's get started!";
	}

	@Override
	public Category setCategory() {
		return Category.Generic;
	}

}
