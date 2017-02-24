package ajstri.commands.admin;

import java.time.format.DateTimeFormatter;

import ajstri.Category;
import ajstri.Permission;
import ajstri.UserUtils;
import ajstri.commands.Command;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;

public class GuildInfoCommand implements Command {

	@Override
	public void execute(GuildMessageReceivedEvent e, String[] args) {
		e.getChannel().sendMessage(""
                + "**Name:** " + e.getGuild().getName() +  "\n"
                + "**Created:** " + e.getGuild().getCreationTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + "\n"
                + "**User Count:** "+ e.getGuild().getMembers().size() + "\n"
                + "**Role Count:** " + e.getGuild().getRoles().size() + "\n"
                + "**Text Channel Count:** " + e.getGuild().getTextChannels().size() + "\n"
                + "**Voice Channel Count:** " + e.getGuild().getVoiceChannels().size() + "\n"
                + "**Server Image:** " + e.getGuild().getIconUrl()
                + "").queue();
		System.out.println(e.getAuthor() + "Executed in Guild: GUILDINFO");

	}
	
	@Override
	public void execute(PrivateMessageReceivedEvent e, String[] args) {
		UserUtils.sendPrivateMessage2(e, "B-b-b-b-but...this isn't a *guild*!");
		System.out.println(e.getAuthor() + "Attempt to Execute in DM: GUILDINFO");
	}
	@Override
	public Permission getValidExecutors() {
		return Permission.Admins;
	}

	@Override
	public String getInfo() {
		return "Some Guild information...";
	}

	@Override
	public Category category() {
		return Category.Admin;
	}
}
