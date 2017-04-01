package ajstri.commands.admin;

import ajstri.Category;
import net.dv8tion.jda.core.Permission;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

public class AdminTestCommand extends ICommand {

	public AdminTestCommand() {
		super("adtest");
		setDescription("Yes");
		setCategory(Category.ADMIN);
		setPermissions(Permission.ADMINISTRATOR);
	}
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		System.out.println(e.getMember().getPermissions());
	}
}