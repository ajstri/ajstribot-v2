package ajstri.commands.custom;

import ajstri.Category;
import ajstri.Permission;
import ajstri.commands.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class DenoobzCommand implements Command {

	@Override
	public void execute(MessageReceivedEvent e, String[] args) {
		e.getTextChannel().sendMessage("What a *noob*").queue();
	}

	@Override
	public Permission getValidExecutors() {
		return Permission.Denoobz;
	}

	@Override
	public String getInfo() {
		return "Custom Command: Denoobz";
	}

	@Override
	public Category category() {
		return Category.Custom;
	}

}
