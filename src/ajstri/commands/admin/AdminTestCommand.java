package ajstri.commands.admin;

import ajstri.Category;
import ajstri.Permission;
import ajstri.commands.Command;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;

public class AdminTestCommand implements Command {

	@Override
	public void execute(GuildMessageReceivedEvent e, String[] args) {
		System.out.println(e.getMember().getPermissions());
	}

	@Override
	public void execute(PrivateMessageReceivedEvent e, String[] args) {
		
	}

	@Override
	public Permission getValidExecutors() {
		return Permission.Admins;
	}

	@Override
	public String getInfo() {
		return "Yes";
	}

	@Override
	public Category category() {
		return Category.Admin;
	}

}
