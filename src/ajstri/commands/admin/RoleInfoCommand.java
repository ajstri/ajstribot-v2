package ajstri.commands.admin;

import java.awt.Color;
import java.util.Arrays;
import java.util.stream.Collectors;

import ajstri.Category;
import ajstri.Permission;
import ajstri.UserUtils;
import ajstri.commands.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;

public class RoleInfoCommand implements Command {
	
	@Override
	public void execute(GuildMessageReceivedEvent e, String[] args) {
		if(args!=null) {
			EmbedBuilder em = new EmbedBuilder();
			em.setColor(Color.RED);
			if(args.length>=2) {
				Role r = null;
				String roleS = "";
				if(args.length==1) {
					roleS = args[1];
				} else {
					roleS = Arrays.stream(args).collect(Collectors.joining(" ")).replace(args[0]+" ", "");
				}
				for(Role ir : e.getGuild().getRoles()) {
					if(ir.getName().equals(roleS.replace("@", ""))) {
						r = ir;
						break;
					}
					else if(ir.getName().equals(roleS)) {
						r = ir;
						break;
					}
				}
				if(r!=null) {
					int usercount = 0;
					for(Member im : e.getGuild().getMembers()) {
						if(im.getRoles().contains(r)) {
							usercount = usercount + 1;
						}
					}
					Color c = r.getColor();
					em.addField("**Name: **"+r.getName()+"\n",
							"" + "**User(s) with Role: **"+usercount+"\n"
							+ "**Position: **"+r.getPosition()+"\n"
							+ "**ColorValues **"+"[Red:"+c.getRed()+", Green:"+c.getGreen()+", Blue:"+c.getBlue()+"]"
							+ "", true);
					e.getChannel().sendMessage(em.build()).queue();
					System.out.println(e.getAuthor() + "Executed in Guild: ROLEINFO");
				} else 
				{
					e.getChannel().sendMessage("Sorry... Didnt find the Requested Role!").queue();
					System.out.println(e.getAuthor() + "Attempted to Execute in Guild: ROLEINFO");
					return;
				}
			}
		} else {
			e.getChannel().sendMessage("Invalid Command!").queue();
			System.out.println(e.getAuthor() + "Executed in Guild: ROLEINFO");
			return;
		}
	}
	
	@Override
	public void execute(PrivateMessageReceivedEvent e, String[] args) {
		UserUtils.sendPrivateMessage2(e, "B-b-b-b-but...this isn't a *guild*!");
		System.out.println(e.getAuthor() + "Attempted to Execute in DM: ROLEINFO");
	}
	
	@Override
	public Permission getValidExecutors() {
		return Permission.Admins;
	}

	@Override
	public String getInfo() {
		return "See some information about an Role...";
	}

	@Override
	public Category category() {
		return Category.Admin;
	}

	
	
}
