package ajstri.commands.custom;

import ajstri.Permission;
import ajstri.commands.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CrockCommand implements Command {

	@Override
	public void execute(MessageReceivedEvent e, String[] args) {
		e.getTextChannel().sendMessage("this is gonna be decided later i guess").queue();
	}

	@Override
	public Permission getValidExecutors() {
		return Permission.Crock;
	}

	@Override
	public String getInfo() {
		return "Custom Command: Crock";
	}

	@Override
	public String category() {
		return "custom";
	}

}
