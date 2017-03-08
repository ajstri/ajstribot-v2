package ajstri.commands.admin;

import ajstri.Category;
import ajstri.commands.ICommand;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.message.ExtendedMessageReceivedEvent;

@Command(aliases={"adtest"}, guildOnly=true, permission="ADMINISTRATOR", isJDAPermission=true, description="Yes")
public class AdminTestCommand implements ICommand {

	@Override
	public void execute(ExtendedMessageReceivedEvent e, String[] args) {
		System.out.println(e.getMember().getPermissions());
	}
	
	@Override
	public Category setCategory() {
		return Category.Admin;
	}
}