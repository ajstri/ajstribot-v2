package ajstri.commands.admin;

import java.time.format.DateTimeFormatter;

import ajstri.Permission;
import ajstri.commands.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class GuildInfoCommand implements Command {

	@Override
	public void execute(MessageReceivedEvent e, String[] args) {
		e.getTextChannel().sendMessage(""
                + "**Name:** " + e.getGuild().getName() +  "\n"
                + "**Created:** " + e.getGuild().getCreationTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + "\n"
                + "**User Count:** "+ e.getGuild().getMembers().size() + "\n"
                + "**Role Count:** " + e.getGuild().getRoles().size() + "\n"
                + "**Text Channel Count:** " + e.getGuild().getTextChannels().size() + "\n"
                + "**Voice Channel Count:** " + e.getGuild().getVoiceChannels().size() + "\n"
                + "**Server Image:** " + e.getGuild().getIconUrl()
                + "").queue();

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
	public String category() {
		return "admin";
	}

}
