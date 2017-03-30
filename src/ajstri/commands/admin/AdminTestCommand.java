package ajstri.commands.admin;

import ajstri.Category;
import net.dv8tion.jda.core.Permission;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

@Command(aliases={"adtest"}, category=Category.ADMIN, guildOnly=true, jdaPermissions={Permission.ADMINISTRATOR}, isJDAPermission=true, description="Yes")
public class AdminTestCommand implements ICommand {

	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		System.out.println(e.getMember().getPermissions());
	}
}