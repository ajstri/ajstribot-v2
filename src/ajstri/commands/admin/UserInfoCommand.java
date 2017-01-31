package ajstri.commands.admin;

import java.time.format.DateTimeFormatter;

import ajstri.commands.Command;
import ajstri.Permission;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class UserInfoCommand implements Command {

    @Override
    public void execute(MessageReceivedEvent e, String[] args) {
        if(args.length > 1) {
            Member m = null;
            for(Member mi : e.getGuild().getMembers()) {
                if(mi.getEffectiveName().equals(args[1].replace("@", ""))) {
                    m = mi;
                    System.out.println(""+mi.getEffectiveName()+" ? "+args[1]);
                    break;
                }
            }    
            if(m == null) {
                e.getTextChannel().sendMessage("Didn't find the Requested User!").queue();
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
            e.getTextChannel().sendMessage(""
                    + "**Name:** "+m.getEffectiveName()+"\n"
                    + "**Created:** "+m.getUser().getCreationTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)+"\n"
                    + "**Roles:** "+roles+"\n"
                    + "**isOwner:** "+m.isOwner()+"\n"
                    + "**isBot:** "+m.getUser().isBot()+"\n"
                    + "**OnlineStatus:** "+(m.getOnlineStatus()==OnlineStatus.INVISIBLE?"OFFLINE":m.getOnlineStatus().toString())+"\n"
                    + "**Avatar:** "+m.getUser().getAvatarUrl()
                    + "").queue();
        }
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
	public String category() {
		return "admin";
	}

}
