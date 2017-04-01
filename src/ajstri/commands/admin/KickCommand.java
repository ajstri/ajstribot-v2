package ajstri.commands.admin;

import ajstri.Category;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

public class KickCommand extends ICommand {

	public KickCommand() {
		super("kick");
		setCategory(Category.ADMIN);
		setDescription("Kick a member from a Guild");
		setPermissions(Permission.ADMINISTRATOR);
		setGuildOnly(true);
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
				g.getController().kick(m).queue(success -> e.sendMessage("Kicked "+m.getEffectiveName()+"! Cya!"));
			}
		} 
		else {
			e.sendMessage("B-b-b-b-but... this isn't a *guild*!");
		}
	}
	
}
