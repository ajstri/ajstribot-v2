package ajstri.commands.generic;

import java.util.stream.Collectors;

import ajstri.Data;
import ajstri.Main;
import ajstri.Permission;
import ajstri.commands.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class HelpCommand implements Command {

	@Override
	public void execute(MessageReceivedEvent e, String[] args) {
		if (args != null){
			StringBuilder sb = new StringBuilder();
			String[] cmds = Main.cmds.keySet().stream().collect(Collectors.joining(",")).split(",");
			for(int i = 0; i < cmds.length; i++) {
				if(Main.cmds.get(cmds[i]).category() == "admin") {
					sb.append(Data.cmdPrefix + cmds[i] + "\n");
				}
			}
			if(cmds[i].category() == args[1]){
			e.getTextChannel().sendMessage("Commands: \n"
					+ "\n"
					+ sb.toString()
					+ "").queue();
			}
		}
		else {
			e.getTextChannel().sendMessage("You Failed").queue();
		}
	}

	@Override
	public Permission getValidExecutors() {
		return Permission.Everyone;
	}

	@Override
	public String getInfo() {
		return "Help";
	}

	@Override
	public String category() {
		return "generic";
	}

}
