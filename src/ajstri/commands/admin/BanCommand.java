package ajstri.commands.admin;

import ajstri.Category;
import ajstri.commands.Command;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import quack.ddbl.core.message.ExtendedMessageReceivedEvent;

public class BanCommand extends Command {

	public BanCommand() {
		super(new String[]{"ban"}, Permission.ADMINISTRATOR, true);
	}

	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		if(e.isGuildMessage()) {
			if(args.length==2) {
				Guild g = e.getGuild();
				Member m = e.getGuild().getMembersByName(args[1], false).get(0);
				if(m==null) {
					e.sendMessage("Cannot find requested Member.");
					return;
				}
				g.getController().kick(m).queue(success -> e.sendMessage("Kicked "+m.getEffectiveName()+"! Cya!"));
			}
		} else {
			e.sendMessage("B-b-b-b-but... this isn't a *guild*!");
		}
	}

	@Override
	public String setCommandInfo() {
		return "Ban a member from your Guild!";
	}
	
	@Override
	public Category setCategory() {
		return Category.Admin;
	}
	
}
