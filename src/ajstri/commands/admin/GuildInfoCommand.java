package ajstri.commands.admin;

import java.awt.Color;
import java.time.format.DateTimeFormatter;

import ajstri.Category;
import ajstri.commands.ICommand;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

@Command(aliases={"guildinfo"}, guildOnly=true, permission="ADMINISTRATOR", isJDAPermission=true, description="Some Guild information...")
public class GuildInfoCommand implements ICommand {

	@Override
	public void execute(ExtendedMessageReceivedEvent e, String[] args) {
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
	public Category setCategory() {
		return Category.Admin;
	}
	
}
