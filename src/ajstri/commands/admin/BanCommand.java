package ajstri.commands.admin;

import ajstri.Category;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

public class BanCommand extends ICommand {
	
	public BanCommand() {
		super("ban");
		setDescription("Ban a member from a guild");
		setCategory(Category.ADMIN);
		setGuildOnly(true);
		setPermissions(Permission.ADMINISTRATOR);
	}

	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		if(e.isGuildMessage()) {
			if(e.args.length == 2) {
				Guild g = e.getGuild();
				Member m = e.getGuild().getMembersByName(e.args[1].replace("@", ""), false).get(0);
				if(m == null) {
					e.sendMessage("Cannot find requested Member.");
					return;
				}
				g.getController().ban(m, 0).queue(success -> e.sendMessage("Banned "+m.getEffectiveName()+"! Cya!"));
			}
		} 
		else {
			e.sendMessage("B-b-b-b-but... this isn't a *guild*!");
		}
	}
	
}