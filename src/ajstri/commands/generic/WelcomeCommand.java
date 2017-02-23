package ajstri.commands.generic;

import ajstri.Category;
import ajstri.Permission;
import ajstri.UserUtils;
import ajstri.commands.Command;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;

public class WelcomeCommand implements Command {

	@Override
	public void execute(GuildMessageReceivedEvent e, String[] args) {
		UserUtils.sendPrivateMessage(e, "Hi! I am AJStriBot. " +
				   "Thanks for choosing me! " +
				   "One of my Commands, `/ban`, requires I be higher in"
				   + "the heirarchy than the member to be kicked. Keep this in mind! " +
				   "Admin commands are sorted by default. If you have Administrative privilages, "
				   + "you can use them in a guild! \n" +
				   "Type `/help` to begin...");
		System.out.println("Executed in Guild: WELCOME");
	}

	@Override
	public void execute(PrivateMessageReceivedEvent e, String[] args) {
		UserUtils.sendPrivateMessage2(e, "Hi! I am AJStriBot. " +
				   "Thanks for choosing me! " +
				   "One of my Commands, `/ban`, requires I be higher in"
				   + "the heirarchy than the member to be kicked. Keep this in mind! " +
				   "Admin commands are sorted by default. If you have Administrative privilages, "
				   + "you can use them in a guild! \n" +
				   "Type `/help` to begin...");
		System.out.println("Executed in DM: WELCOME");
	}

	@Override
	public Permission getValidExecutors() {
		return Permission.Everyone;
	}

	@Override
	public String getInfo() {
		return "Welcome, let's get started!";
	}

	@Override
	public Category category() {
		return Category.Generic;
	}

}
