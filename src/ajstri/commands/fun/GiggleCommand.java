package ajstri.commands.fun;

import ajstri.Category;
import ajstri.Permission;
import ajstri.commands.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;

public class GiggleCommand implements Command {

	@Override
	public void execute(MessageReceivedEvent e, String[] args) {
		e.getTextChannel().sendMessage("*giggles*").queue();
	}
	
	@Override
	public void execute(PrivateMessageReceivedEvent e, String[] args) {
		e.getChannel().sendMessage("*giggles*").queue();
	}
	
	@Override
	public Permission getValidExecutors() {
		return Permission.Everyone;
	}

	@Override
	public String getInfo() {
		return "Giggles!";
	}

	@Override
	public Category category() {
		return Category.Fun;
	}

	

}
