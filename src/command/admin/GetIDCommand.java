package command.admin;

import ajstri.Permission;
import command.Command;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class GetIDCommand implements Command {

	@Override
	public void execute(MessageReceivedEvent e, String[] args) {
		if(args!=null) {
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
	public Permission getValidExecutors() {
		return Permission.Admins;
	}

	@Override
	public String getInfo() {
		return "Get the ID of an User.";
	}

	@Override
	public String category() {
		return "admin";
	}
}
