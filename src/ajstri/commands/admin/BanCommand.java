package ajstri.commands.admin;

import ajstri.Category;
import ajstri.commands.ICommand;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

@Command(aliases={"ban"}, guildOnly=true, permission="ADMINISTRATOR", isJDAPermission=true, description="Ban a member from your Guild!")
public class BanCommand implements ICommand {

	@Override
	public void execute(ExtendedMessageReceivedEvent e, String[] args) {
		if(e.isGuildMessage()) {
			if(args.length == 2) {
				Guild g = e.getGuild();
				Member m = e.getGuild().getMembersByName(args[1].replace("@", ""), false).get(0);
				if(m == null) {
					e.sendMessage("Cannot find requested Member.");
					return;
				}
				g.getController().ban(m, 0).queue(success -> e.sendMessage("Kicked "+m.getEffectiveName()+"! Cya!"));
			}
		} 
		else {
			e.sendMessage("B-b-b-b-but... this isn't a *guild*!");
		}
	}
	
	@Override
	public Category setCategory() {
		return Category.Admin;
	}
}