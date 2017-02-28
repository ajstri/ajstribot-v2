package ajstri.commands.admin;

import ajstri.Category;
import ajstri.commands.Command;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Member;
import quack.ddbl.core.message.ExtendedMessageReceivedEvent;

public class GetIDCommand extends Command {

	public GetIDCommand() {
		super(new String[]{"getid"}, Permission.ADMINISTRATOR, false);
	}

	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		if(e.isGuildMessage()) {
			if(args.length==2) {
				Member m = e.getGuild().getMembersByName(args[1].replaceFirst("@", ""), false).get(0);
				if(m==null) {
					e.sendMessage("Cannot find requested Member.");
					return;
				}
				e.sendMessage(m.getEffectiveName()+" ID: "+m.getUser().getId());
			}
		} else {
			e.sendMessage("Your ID: "+e.getAuthor().getId());
		}
	}

	@Override
	public String setCommandInfo() {
		return "Get the ID of an User.";
	}
	
	@Override
	public Category setCategory() {
		return Category.Admin;
	}
	
}
