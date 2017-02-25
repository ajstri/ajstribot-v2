package ajstri.commands.fun;

import ajstri.Category;
import ajstri.Permission;
import ajstri.UserUtils;
import ajstri.commands.Command;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;

public class CryCommand implements Command {

	@Override
	public void execute(GuildMessageReceivedEvent e, String[] args) {
		e.getChannel().sendMessage("*cries*").queue();
	}

	@Override
	public void execute(PrivateMessageReceivedEvent e, String[] args) {
		UserUtils.sendPrivateMessage2(e, "*cries*");
	}

	@Override
	public Permission getValidExecutors() {
		return Permission.Everyone;
	}

	@Override
	public String getInfo() {
		return "I cry every time";
	}

	@Override
	public Category category() {
		return Category.Fun;
	}
}
