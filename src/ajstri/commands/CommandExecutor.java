package ajstri.commands;

import java.util.List;

import ajstri.Data;
import ajstri.Main;
import ajstri.Permission;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class CommandExecutor extends ListenerAdapter {
	
	@Override
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		if(!event.getAuthor().getId().equals(Data.BOT_ID)) {
			String msg = event.getMessage().getContent();
			if(msg.startsWith(Data.cmdPrefix)) {
				String[] args = msg.split(" ");
				if(args.length>0) {
					String cmd = args[0].replace(Data.cmdPrefix, "");
					if(Main.cmds.containsKey(cmd.toLowerCase())) {
						Command iCMD = Main.cmds.get(cmd.toLowerCase());
						if(iCMD.getValidExecutors() == Permission.Everyone) {
							iCMD.execute(event, args);
							return;
						} 
						else 
						{
							List<net.dv8tion.jda.core.Permission> m = event.getMember().getPermissions();
							
							if(m.contains(net.dv8tion.jda.core.Permission.ADMINISTRATOR) && iCMD.getValidExecutors() == Permission.Admins) {
								iCMD.execute(event, args);
								return;
							} else if(m.contains(net.dv8tion.jda.core.Permission.BAN_MEMBERS) && iCMD.getValidExecutors() == Permission.Ban) {
								iCMD.execute(event, args);
								return;
							}
							event.getChannel().sendMessage("You cannot execute the command "+cmd+", silly!").queue();
							return;
						}
					}
				}
			}
		}
	}
	
	@Override
	public void onPrivateMessageReceived(PrivateMessageReceivedEvent event) {
		if(!event.getAuthor().getId().equals(Data.BOT_ID)) {
			String msg = event.getMessage().getContent();
			if(msg.startsWith(Data.cmdPrefix)) {
				String[] args = msg.split(" ");
				if(args.length>0) {
					String cmd = args[0].replace(Data.cmdPrefix, "");
					if(Main.cmds.containsKey(cmd.toLowerCase())) {
						Command iCMD = Main.cmds.get(cmd.toLowerCase());
						iCMD.execute(event, args);
						return;
					}
				}
			}
		}
	}
}
