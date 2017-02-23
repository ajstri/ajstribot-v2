package ajstri.commands.generic;

import java.util.ArrayList;
import java.util.Collections;

import ajstri.Category;
import ajstri.Data;
import ajstri.Main;
import ajstri.Permission;
import ajstri.commands.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;

public class HelpCommand implements Command {
	
	@Override
	public void execute(MessageReceivedEvent e, String[] args) {
		if(args!=null) {
			StringBuilder sb = new StringBuilder();
			if(args.length==1) {
				for(Category c : Category.values()) {
					sb.append("*"+c.getName()+"*\n");
				}
				e.getTextChannel().sendMessage("**Help: **Categorys\n"+sb.toString()).queue();
			}
			if(args.length>=2) {
				String cat = args[1];
				ArrayList<String> keySet = new ArrayList<String>();
				for(String ck : Main.cmds.keySet()) keySet.add(ck);
				Collections.sort(keySet);
				for(int i = 0; i<keySet.size(); i++) {
					Command cmd = Main.cmds.get(keySet.get(i));
					if(cmd.category().getName().equalsIgnoreCase(cat)) sb.append("*"+Data.cmdPrefix+keySet.get(i)+"* | "+cmd.getInfo()+"\n");
				}
				e.getTextChannel().sendMessage("**Help: **Category: "+cat+"\n"+sb.toString()).queue();
			}
		}
	}
	
	@Override
	public void execute(PrivateMessageReceivedEvent e, String[] args) {
		if(args!=null) {
			StringBuilder sb = new StringBuilder();
			if(args.length==1) {
				for(Category c : Category.values()) {
					sb.append("*"+c.getName()+"*\n");
				}
				e.getChannel().sendMessage("**Help: **Categorys\n"+sb.toString()).queue();
			}
			if(args.length>=2) {
				String cat = args[1];
				ArrayList<String> keySet = new ArrayList<String>();
				for(String ck : Main.cmds.keySet()) keySet.add(ck);
				Collections.sort(keySet);
				for(int i = 0; i<keySet.size(); i++) {
					Command cmd = Main.cmds.get(keySet.get(i));
					if(cmd.category().getName().equalsIgnoreCase(cat)) sb.append("*"+Data.cmdPrefix+keySet.get(i)+"* | "+cmd.getInfo()+"\n");
				}
				e.getChannel().sendMessage("**Help: **Category: "+cat+"\n"+sb.toString()).queue();
			}
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
	public Category category() {
		return Category.Generic;
	}
}
