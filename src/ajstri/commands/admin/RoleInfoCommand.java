package ajstri.commands.admin;

import java.awt.Color;
import java.util.Arrays;
import java.util.stream.Collectors;

import ajstri.Category;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Role;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;
import quack.ddbl.core.utils.RoleUtils;

public class RoleInfoCommand extends ICommand {

	public RoleInfoCommand() {
		super("roleinfo");
		setCategory(Category.ADMIN);
		setDescription("Role Information");
		setGuildOnly(true);
		setPermissions(Permission.ADMINISTRATOR);
	}
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		if(e.args.length>=2) {
			String roleNameRaw = Arrays.stream(e.args).collect(Collectors.joining(" ")).replace(e.args[0]+" ", "");
			roleNameRaw = roleNameRaw.replaceFirst("@", "");
			Role role = e.getGuild().getRolesByName(roleNameRaw, false).get(0);
			if(role==null) {
				e.sendMessage("The reqested role could not be found!");
				return;
			}
			e.sendMessage(new RoleUtils().getRoleInfo(role).asMessageEmbed(Color.RED));
		}
	}
	
}
