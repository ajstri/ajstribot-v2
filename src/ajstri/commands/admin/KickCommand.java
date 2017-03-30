package ajstri.commands.admin;

import ajstri.Category;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

@Command(aliases={"kick"}, category=Category.ADMIN, guildOnly=true, jdaPermissions={Permission.ADMINISTRATOR}, isJDAPermission=true, description="Kick a member from your Guild!")
public class KickCommand implements ICommand {

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
