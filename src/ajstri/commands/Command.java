package ajstri.commands;

import ajstri.Category;
import ajstri.Permission;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;

public interface Command {
	public void execute(GuildMessageReceivedEvent e, String[] args);
	public void execute(PrivateMessageReceivedEvent e, String[] args);
	public Permission getValidExecutors();
	public String getInfo();
	public Category category();
}
