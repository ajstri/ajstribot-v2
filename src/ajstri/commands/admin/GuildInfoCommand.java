package ajstri.commands.admin;

import java.awt.Color;
import java.time.format.DateTimeFormatter;

import ajstri.Category;
import ajstri.commands.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import quack.ddbl.core.message.ExtendedMessageReceivedEvent;

public class GuildInfoCommand extends Command {

	public GuildInfoCommand() {
		super(Permission.ADMINISTRATOR, true, "guildinfo");
	}

	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		Guild g = e.getGuild();
		EmbedBuilder eb = new EmbedBuilder();
		eb.setColor(Color.RED);
		eb.addField(g.getName(), 
				"**Created:** "+g.getCreationTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)+"\n"
				+ "**User Count:** "+g.getMembers().size()+"\n"
				+ "**Role Count:** "+g.getRoles().size()+"\n"
				+ "**Text Channel Count:** "+g.getTextChannels().size()+"\n"
				+ "**Voice Channel Count:** "+g.getVoiceChannels().size()+"\n"
				+ "**Server Image:**", true);
		eb.setImage(g.getIconUrl());
		e.sendMessage(eb.build());
	}

	@Override
	public String setCommandInfo() {
		return "Some Guild information...";
	}

	@Override
	public Category setCategory() {
		return Category.Admin;
	}
	
}
