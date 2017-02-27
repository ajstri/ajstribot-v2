package ajstri.commands.generic;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import ajstri.Category;
import ajstri.commands.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import quack.ddbl.core.DDBLCore;
import quack.ddbl.core.message.ExtendedMessageReceivedEvent;

public class HelpCommand extends Command {

	public HelpCommand() {
		super(new String[]{"help"}, EVERYONE, false);
	}

	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		EmbedBuilder eb = new EmbedBuilder();
		eb.setColor(Color.RED);
		if(args.length==1) {
			StringBuilder sb = new StringBuilder();
			ArrayList<Category> cats = (ArrayList<Category>)Arrays.asList(Category.values());
			Collections.sort(cats);
			for(int i = 0; i<cats.size(); i++) {
				sb.append("*"+cats.get(i).getName()+"*\n");
			}
			eb.addField("Help: Categorys", sb.toString(), true);
			e.sendMessage(eb.build());
		}
		if(args.length==2) {
			if(Category.getNames().contains(args[1])) {
				eb.addField("Help: "+args[1], "", true);
				for(String[] ckey : DDBLCore.getDDBLInstance().getCommandMap().keySet()) {
					if(DDBLCore.getDDBLInstance().getCommandMap().get(ckey) instanceof ajstri.commands.Command) {
						Command cmd = (Command)DDBLCore.getDDBLInstance().getCommandMap().get(ckey);
						if(cmd.setCategory()==null||cmd.setCommandInfo()==null) DDBLCore.getDDBLInstance().getLogger().warning(cmd.getNames()[0]+" has a null value!");
						else if(cmd.setCategory().getName().equalsIgnoreCase(args[1])) eb.addField(cmd.getNames()[0], cmd.setCommandInfo(), true);
					}
				}
				e.sendMessage(eb.build());
				return;
			} else {
				e.sendMessage("Could not find requested category");
				return;
			}
		}
	}

	@Override
	public String setCommandInfo() {
		return null;
	}

	@Override
	public Category setCategory() {
		return null;
	}
	
}
