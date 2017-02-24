package ajstri.commands.fun;

import ajstri.Category;
import ajstri.Permission;
import ajstri.UserUtils;
import ajstri.commands.Command;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;

public class FishCommand implements Command {

	@Override
	public void execute(GuildMessageReceivedEvent e, String[] args) {
		e.getChannel().sendMessage("Fish, fish! Everyone gets a fish! :fish:").queue();
		System.out.println(e.getAuthor() + "Executed in Guild: FISH");
	}
	
	@Override
	public void execute(PrivateMessageReceivedEvent e, String[] args) {
		UserUtils.sendPrivateMessage2(e, "Fish, fish! Everyone gets a fish! :fish:");
		System.out.println(e.getAuthor() + "Executed in DM: FISH");
	}

	@Override
	public Permission getValidExecutors() {
		return Permission.Everyone;
	}

	@Override
	public String getInfo() {
		return "Fish Command";
	}

	@Override
	public Category category() {
		return Category.Fun;
	}
}
