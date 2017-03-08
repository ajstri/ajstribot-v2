package ajstri.commands.admin;

import java.awt.Color;
import java.time.format.DateTimeFormatter;

import ajstri.Category;
import ajstri.commands.ICommand;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.User;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.message.ExtendedMessageReceivedEvent;

@Command(aliases={"userinfo"}, guildOnly=true, permission="ADMINISTRATOR", isJDAPermission=true, description="See some information about a User.")
public class UserInfoCommand implements ICommand {

	@Override
	public void execute(ExtendedMessageReceivedEvent e, String[] args) {
		if(e.isGuildMessage()) {
			EmbedBuilder eb = new EmbedBuilder();
			eb.setColor(Color.RED);
			if(args.length==1) {
				Member m = e.getMember();
				User u = m.getUser();
	            eb.addField(u.getName()+"\n",
	                    "**Created:** "+u.getCreationTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)+"\n"
	                    + "**Role Count:** "+m.getRoles().size()+"\n"
	                    + "**isOwner:** "+m.isOwner()+"\n"
	                    + "**isBot:** "+u.isBot()+"\n"
	                    + "**OnlineStatus:** "+(m.getOnlineStatus()==OnlineStatus.INVISIBLE?"OFFLINE":m.getOnlineStatus().toString())+"\n"
	                    + "**Avatar:**", true);
	            eb.setImage(u.getAvatarUrl());
	            e.sendMessage(eb.build());
	            return;
			}
			if(args.length>=2) {
				Member m = e.getGuild().getMembersByName(args[1].replaceFirst("@", ""), false).get(0);
				if(m == null) {
					e.sendMessage("Could not find requested User.");
					return;
				}
				User u = m.getUser();
	            eb.addField(u.getName()+"\n",
	                    "**Created:** "+u.getCreationTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)+"\n"
	                    + "**Role Count:** "+m.getRoles().size()+"\n"
	                    + "**isOwner:** "+m.isOwner()+"\n"
	                    + "**isBot:** "+u.isBot()+"\n"
	                    + "**OnlineStatus:** "+(m.getOnlineStatus()==OnlineStatus.INVISIBLE?"OFFLINE":m.getOnlineStatus().toString())+"\n"
	                    + "**Avatar:**", true);
	            eb.setImage(u.getAvatarUrl());
	            e.sendMessage(eb.build());
	            return;
			}
		} else {
			EmbedBuilder eb = new EmbedBuilder();
			eb.setColor(Color.RED);
			User u = e.getAuthor();
            eb.addField(u.getName()+"\n",
                    "**Created:** "+u.getCreationTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)+"\n"
                    + "**isBot:** "+u.isBot()+"\n"
                    + "**OnlineStatus:** "+(u.getJDA().getPresence().getStatus()==OnlineStatus.INVISIBLE?"OFFLINE":u.getJDA().getPresence().getStatus().toString())+"\n"
                    + "**Avatar:**", true);
            eb.setImage(u.getAvatarUrl());
            e.sendMessage(eb.build());
            return;
		}
	}

	@Override
	public Category setCategory() {
		return Category.Admin;
	}

}
