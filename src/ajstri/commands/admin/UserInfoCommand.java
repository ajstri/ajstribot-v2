package ajstri.commands.admin;

import java.time.format.DateTimeFormatter;

import ajstri.commands.Command;
import ajstri.Category;
import ajstri.Permission;
import ajstri.UserUtils;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;

public class UserInfoCommand implements Command {

    @Override
    public void execute(GuildMessageReceivedEvent e, String[] args) {
        if(args.length > 1) {
            Member m = null;
            for(Member mi : e.getGuild().getMembers()) {
                if(mi.getEffectiveName().equals(args[1].replace("@", ""))) {
                    m = mi;
                    break;
                }
                if(mi.getEffectiveName().equals(args[1])) {
                    m = mi;
                    break;
                }
            }    
            if(m == null) {
                e.getChannel().sendMessage("Didn't find the Requested User!").queue();
                System.out.println(e.getAuthor() + "Attempt to Execute in Guild: USERINFO");
                return;
            }
            String roles = "";
            for(Role r : m.getRoles()) {
                roles += r.getName()+", ";
            }
            if(roles.length() < 2) {
                roles = "<no Roles>";
            } else 
                roles = roles.substring(0, roles.length()-2);
            e.getChannel().sendMessage(""
                    + "**Name:** "+m.getEffectiveName()+"\n"
                    + "**Created:** "+m.getUser().getCreationTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)+"\n"
                    + "**Roles:** "+roles+"\n"
                    + "**isOwner:** "+m.isOwner()+"\n"
                    + "**isBot:** "+m.getUser().isBot()+"\n"
                    + "**OnlineStatus:** "+(m.getOnlineStatus()==OnlineStatus.INVISIBLE?"OFFLINE":m.getOnlineStatus().toString())+"\n"
                    + "**Avatar:** "+m.getUser().getAvatarUrl()
                    + "").queue();
            System.out.println(e.getAuthor() + "Executed in Guild: USERINFO");
        }
    }
    
    @Override
	public void execute(PrivateMessageReceivedEvent e, String[] args) {
    	UserUtils.sendPrivateMessage2(e, "B-b-b-b-but...this isn't a *guild*!");
    	System.out.println(e.getAuthor() + "Attempt to Execute in DM: USERINFO");
	}

	@Override
	public Permission getValidExecutors() {
		return Permission.Admins;
	}

	@Override
	public String getInfo() {
		return "See some information about a User.";
	}

	@Override
	public Category category() {
		return Category.Admin;
	}

	

}
