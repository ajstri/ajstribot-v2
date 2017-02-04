package ajstri.commands.fun;

import ajstri.Permission;
import ajstri.commands.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class BanCommand implements Command {

	@Override
	public void execute(MessageReceivedEvent e, String[] args) {
		e.getChannel().sendMessage("I can drop the BAN HAMMER on you!");
	}

	@Override
	public Permission getValidExecutors() {
		return Permission.Everyone;
	}

	@Override
	public String getInfo() {
		return "Drop the ban hammer.";
	}

	@Override
	public String category() {
		return "fun";
	}

}
