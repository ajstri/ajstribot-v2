package ajstri.commands.generic;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

import ajstri.Category;
import ajstri.commands.ICommand;
import net.dv8tion.jda.core.EmbedBuilder;
import quack.ddbl.core.DDBLCore;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.commands.CommandRegistry.CommandEntry;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

@Command(aliases={"help"}, description="Help Command!")
public class HelpCommand implements ICommand {

	@Override
	public void execute(ExtendedMessageReceivedEvent e, String[] args) {
		EmbedBuilder eb = new EmbedBuilder();
		eb.setColor(Color.RED);
		if(args.length==1) {
			StringBuilder sb = new StringBuilder();
			ArrayList<String> cats = Category.getNames();
			Collections.sort(cats);
			for(int i = 0; i<cats.size(); i++) {
				sb.append("*"+cats.get(i)+"*\n");
			}
			eb.addField("Help: Categorys", sb.toString(), true);
			e.sendMessage(eb.build());
		}
		if(args.length==2) {
			if(Category.getNames().contains(args[1])) {
				eb.addField("Help: "+args[1], "", true);
				for(String[] ckey : DDBLCore.getCommandRegistry().getHelpMap().keySet()) {
					CommandEntry entry = DDBLCore.getCommandRegistry().getHelpMap().get(ckey);
					try {
						ICommand cmd = (ICommand)entry.cls.newInstance();
						if(cmd.setCategory().getName().equalsIgnoreCase(args[1])) eb.addField(DDBLCore.getPrefix()+entry.commandMeta.aliases()[0], entry.commandMeta.description(), true);
					}
					catch(InstantiationException e1) {
						e1.printStackTrace();
					}
					catch(IllegalAccessException e1) {
						e1.printStackTrace();
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
	public Category setCategory() {
		return Category.Generic;
	}
	
}
