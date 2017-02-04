package ajstri.commands.admin;

import java.awt.Color;
import java.util.Arrays;
import java.util.stream.Collectors;

import ajstri.Category;
import ajstri.Permission;
import ajstri.commands.Command;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class RoleInfoCommand implements Command {
	
	@Override
	public void execute(MessageReceivedEvent e, String[] args) {
		if(args!=null) {
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
				}
				if(r!=null) {
					int usercount = 0;
					for(Member im : e.getGuild().getMembers()) {
						if(im.getRoles().contains(r)) {
							usercount = usercount+1;
						}
					}
					Color c = r.getColor();
					e.getTextChannel().sendMessage(""
							+ "**Name: **"+r.getName()+"\n"
							+ "**User(s) with Role: **"+usercount+"\n"
							+ "**Position: **"+r.getPosition()+"\n"
							+ "**ColorValues **"+"[Red:"+c.getRed()+", Green:"+c.getGreen()+", Blue:"+c.getBlue()+"]"
							+ "").queue();
				} else {
					e.getTextChannel().sendMessage("Sorry... Didnt find the Requested Role!").queue();
					return;
				}
			}
		} else {
			e.getTextChannel().sendMessage("Invalid Command!").queue();
			return;
		}
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
