package ajstri.commands.generic;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

import ajstri.Category;
import ajstri.Data;
import ajstri.Main;
import ajstri.Permission;
import ajstri.commands.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;

public class HelpCommand implements Command {
	
	@Override
	public void execute(GuildMessageReceivedEvent e, String[] args) {
		if(args != null) {
			EmbedBuilder em = new EmbedBuilder();
			em.setColor(Color.RED);
			if(args.length == 1) {
				StringBuilder sb = new StringBuilder();
				for(Category c : Category.values()) {
					sb.append(c.getName()+"\n");
					//em.addField("*" + c.getName() + "*\n", "", true);
				}
				em.addField("**Help: Categorys**", sb.toString(), true);
				e.getChannel().sendMessage(em.build()).queue();
				System.out.println(e.getAuthor() + "Executed in Guild: HELP");
			}
			if(args.length >= 2) {
				String cat = args[1];
				ArrayList<String> keySet = new ArrayList<String>();
				for(String ck : Main.cmds.keySet()) keySet.add(ck);
				Collections.sort(keySet);
				StringBuilder sb = new StringBuilder();
				for(int i = 0; i < keySet.size(); i++) {
					Command cmd = Main.cmds.get(keySet.get(i));
					if(cmd.category()==null) {
						System.out.println("The Category for "+keySet.get(i)+" is null!");
					} 
					else if(cmd.category().getName().equalsIgnoreCase(cat)) {
						if(cmd.getInfo()==null) {
							System.out.println("The Info for "+keySet.get(i)+" is null!");
						} 
						else {
							sb.append("*"+Data.cmdPrefix+keySet.get(i)+"* || "+cmd.getInfo()+"\n");
							//em.addField(Data.cmdPrefix + keySet.get(i) + "\n", cmd.getInfo() + "\n", true);
						}
					}
				}
				em.addField("**Help: "+cat+"**", sb.toString(), true);
				e.getChannel().sendMessage(em.build()).queue();
				System.out.println(e.getAuthor() + "Executed in Guild: HELP");
			}
		}
	}
	
	@Override
	public void execute(PrivateMessageReceivedEvent e, String[] args) {
		if(args != null) {
			EmbedBuilder em = new EmbedBuilder();
			em.setColor(Color.RED);
			em.addField("**Help: Categories**", "", true);
			if(args.length == 1) {
				for(Category c : Category.values()) {
					em.addField("*" + c.getName() + "*\n", "This is a weird test", true);
				}
				e.getChannel().sendMessage(em.build()).queue();
				System.out.println(e.getAuthor() + "Executed in Guild: HELP");
			}
			if(args.length >= 2) {
				String cat = args[1];
				ArrayList<String> keySet = new ArrayList<String>();
				for(String ck : Main.cmds.keySet()) keySet.add(ck);
				Collections.sort(keySet);
				for(int i = 0; i < keySet.size(); i++) {
					Command cmd = Main.cmds.get(keySet.get(i));
					if(cmd.category() == null) {
						System.out.println("The Category for " + keySet.get(i) + " is null!");
					} 
					else if(cmd.category().getName().equalsIgnoreCase(cat)) {
						if(cmd.getInfo() == null) {
							System.out.println("The Info for " + keySet.get(i) + " is null!");
						} 
						else {
							em.addField(Data.cmdPrefix + keySet.get(i),cmd.getInfo() + "\n", true);
						}
					}
				}
				e.getChannel().sendMessage(em.build()).queue();
				System.out.println(e.getAuthor() + "Executed in Guild: HELP");
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
