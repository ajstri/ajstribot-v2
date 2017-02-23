package ajstri.commands.fun;

import ajstri.Category;
import ajstri.Permission;
import ajstri.UserUtils;
import ajstri.commands.Command;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;

public class GiggleCommand implements Command {

	@Override
	public void execute(GuildMessageReceivedEvent e, String[] args) {
		e.getChannel().sendMessage("*giggles*").queue();
		System.out.println("Executed in Guild: GIGGLE");
	}
	
	@Override
	public void execute(PrivateMessageReceivedEvent e, String[] args) {
		UserUtils.sendPrivateMessage2(e, "B-b-b-b-but...this isn't a *guild*!");
		System.out.println("Executed in DM: GIGGLE");
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
