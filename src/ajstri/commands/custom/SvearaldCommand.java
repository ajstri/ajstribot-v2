package ajstri.commands.custom;

import ajstri.Category;
import ajstri.Permission;
import ajstri.commands.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;

public class SvearaldCommand implements Command {

	@Override
	public void execute(MessageReceivedEvent e, String[] args) {
		e.getTextChannel().sendMessage("The Lore Must Go On!").queue();
		
	}
	
	@Override
	public void execute(PrivateMessageReceivedEvent e, String[] args) {
		e.getChannel().sendMessage("The Lore Must Go On!").queue();
	}
	
	@Override
	public Permission getValidExecutors() {
		return Permission.Svearald;
	}

	@Override
	public String getInfo() {
		return "Custom Command: Svearald";
	}

	@Override
	public Category category() {
		return Category.Custom;
	}
}
