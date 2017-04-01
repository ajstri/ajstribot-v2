package ajstri.commands.admin;

import java.awt.Color;

import ajstri.Category;
import net.dv8tion.jda.core.Permission;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

public class GuildInfoCommand extends ICommand {

	public GuildInfoCommand() {
		super("guildinfo");
		setDescription("Some Guild Information");
		setCategory(Category.ADMIN);
		setPermissions(Permission.ADMINISTRATOR);
		setGuildOnly(true);
	}
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		e.sendMessage(e.getGuildUtils().getGuildInfo(e.getShardID()).asMessageEmbed(Color.RED));
	}
	
}
