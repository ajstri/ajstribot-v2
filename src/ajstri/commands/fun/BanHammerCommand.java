package ajstri.commands.fun;

import ajstri.Category;
import ajstri.Permission;
import ajstri.UserUtils;
import ajstri.commands.Command;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;

public class BanHammerCommand implements Command {

	@Override
	public void execute(GuildMessageReceivedEvent e, String[] args) {
		e.getChannel().sendMessage("I can drop the BAN HAMMER on you!").queue();
		System.out.println(e.getAuthor() + "Executed in Guild: BAN");
	}
	
	@Override
	public void execute(PrivateMessageReceivedEvent e, String[] args) {
		UserUtils.sendPrivateMessage2(e, "I can drop the BAN HAMMER on you!");
		System.out.println(e.getAuthor() + "Executed in DM: BAN");
	}
	
	@Override
	public Permission getValidExecutors() {
		return Permission.Everyone;
	}

	@Override
	public String getInfo() {
		return "Drop the ban hammer.";
	}

	@Override
	public Category category() {
		return Category.Fun;
	}
}
