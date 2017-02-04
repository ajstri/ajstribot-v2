package ajstri.commands;

import ajstri.Category;
import ajstri.Permission;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public interface Command {
	public void execute(MessageReceivedEvent e, String[] args);
	public Permission getValidExecutors();
	public String getInfo();
	public Category category();
}
