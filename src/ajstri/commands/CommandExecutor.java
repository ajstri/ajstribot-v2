package ajstri.commands;

import ajstri.Data;
import ajstri.Main;
import ajstri.Permission;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class CommandExecutor extends ListenerAdapter {
	
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		if(!event.getAuthor().getId().equals(Data.BOT_ID)) {
			String msg = event.getMessage().getContent();
			String cmd = null;
			String[] args = null;
			if(msg.startsWith(Data.cmdPrefix)) {
				if(msg.contains(" ")) {
					args = msg.split(" ");
					cmd = args[0].replace(Data.cmdPrefix, "");
				} else {
					cmd = msg.replace(Data.cmdPrefix, "");
				}
				if(Main.cmds.containsKey(cmd.toLowerCase())) {
					Command iCMD = Main.cmds.get(cmd.toLowerCase());
					if(iCMD.getValidExecutors()==Permission.Everyone) {
						iCMD.execute(event, args);
						return;
					} else {
						for(String allowed : iCMD.getValidExecutors().getUsers()) {
							if(event.getAuthor().getId().equals(allowed)) {
								iCMD.execute(event, args);
								return;
							}
						}
						event.getTextChannel().sendMessage("You cannot execute the command " + cmd + ", silly!").queue();
						return;
					}
				}
			}
		}
	}
	
}
