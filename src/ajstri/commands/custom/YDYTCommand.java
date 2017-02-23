package ajstri.commands.custom;

import ajstri.Category;
import ajstri.Permission;
import ajstri.commands.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;

public class YDYTCommand implements Command {

	@Override
	public void execute(MessageReceivedEvent e, String[] args) {
		e.getTextChannel().sendMessage("stupid bot").queue();
	}

	@Override
	public void execute(PrivateMessageReceivedEvent e, String[] args) {
		e.getChannel().sendMessage("stupid bot").queue();
	}
	
	@Override
	public Permission getValidExecutors() {
		return Permission.YDYT;
	}

	@Override
	public String getInfo() {
		return "Custom Command: YDYT";
	}

	@Override
	public Category category() {
		return Category.Custom;
	}
}
