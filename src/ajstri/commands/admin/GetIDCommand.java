package ajstri.commands.admin;

import ajstri.Category;
import ajstri.Permission;
import ajstri.commands.Command;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;

public class GetIDCommand implements Command {

	@Override
	public void execute(MessageReceivedEvent e, String[] args) {
		if(args != null) {
			Guild g = e.getGuild();
			for(Member m : g.getMembers()) {
				if(m.getEffectiveName().equals(args[1])) {
					e.getTextChannel().sendMessage("UserID: " + m.getUser().getId()).queue();
					break;
				}
			}
		}
	}
	
	@Override
	public void execute(PrivateMessageReceivedEvent e, String[] args) {
		e.getChannel().sendMessage("B-b-b-b-but...this isn't a *guild*!").queue();
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
