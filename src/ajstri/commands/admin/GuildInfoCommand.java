package ajstri.commands.admin;

import java.awt.Color;

import ajstri.Category;
import net.dv8tion.jda.core.Permission;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

@Command(aliases={"guildinfo"}, category=Category.ADMIN, guildOnly=true, jdaPermissions={Permission.ADMINISTRATOR}, isJDAPermission=true, description="Some Guild information...")
public class GuildInfoCommand implements ICommand {

	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		e.sendMessage(e.getGuildUtils().getGuildInfo(e.getShardID()).asMessageEmbed(Color.RED));
	}
	
}
