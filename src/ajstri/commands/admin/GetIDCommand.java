package ajstri.commands.admin;

import ajstri.Category;
import ajstri.Permission;
import ajstri.UserUtils;
import ajstri.commands.Command;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;

public class GetIDCommand implements Command {

	@Override
	public void execute(GuildMessageReceivedEvent e, String[] args) {
		if(args != null) {
			Guild g = e.getGuild();
			for(Member m : g.getMembers()) {
				if(m.getEffectiveName().equals(args[1])) {
					e.getChannel().sendMessage("UserID: " + m.getUser().getId()).queue();
					System.out.println("Executed in Guild: GETID");
					break;
				}
			}
		}
	}
	
	@Override
	public void execute(PrivateMessageReceivedEvent e, String[] args) {
		UserUtils.sendPrivateMessage2(e, "B-b-b-b-but...this isn't a *guild*!");
		System.out.println("Attempt to Execute in DM: GETID");
	}
	
	@Override
	public Permission getValidExecutors() {
		return Permission.Admins;
	}

	@Override
	public String getInfo() {
		return "Get the ID of an User.";
	}

	@Override
	public Category category() {
		return Category.Admin;
	}

	
}
