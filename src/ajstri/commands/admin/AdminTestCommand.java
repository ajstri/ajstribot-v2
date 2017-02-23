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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Permission getValidExecutors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category category() {
		// TODO Auto-generated method stub
		return null;
	}

}
