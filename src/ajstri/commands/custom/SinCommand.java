package ajstri.commands.custom;

import ajstri.Category;
import ajstri.Permission;
import ajstri.commands.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class SinCommand implements Command {

	@Override
	public void execute(MessageReceivedEvent e, String[] args) {
		e.getTextChannel().sendMessage("I don't know what's going on here.").queue();
	}

	@Override
	public Permission getValidExecutors() {
		return Permission.Sin;
	}

	@Override
	public String getInfo() {
		return "Custom Command: Sin";
	}

	@Override
	public Category category() {
		return Category.Custom;
	}

}
