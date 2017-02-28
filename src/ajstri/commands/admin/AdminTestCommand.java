package ajstri.commands.admin;

import ajstri.Category;
import ajstri.commands.Command;
import net.dv8tion.jda.core.Permission;
import quack.ddbl.core.message.ExtendedMessageReceivedEvent;

public class AdminTestCommand extends Command {

	public AdminTestCommand() {
		super(Permission.ADMINISTRATOR, true, "adtest");
	}

	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		System.out.println(e.getMember().getPermissions());
	}

	@Override
	public String setCommandInfo() {
		return "Yes";
	}
	
	@Override
	public Category setCategory() {
		return Category.Admin;
	}
}