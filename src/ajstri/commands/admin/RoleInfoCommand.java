package ajstri.commands.admin;

import java.awt.Color;
import java.util.Arrays;
import java.util.stream.Collectors;

import ajstri.Category;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Role;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;
import quack.ddbl.core.utils.RoleUtils;

@Command(aliases={"roleinfo"}, category=Category.ADMIN, guildOnly=true, jdaPermissions={Permission.ADMINISTRATOR}, isJDAPermission=true, description="See some information about an Role...")
public class RoleInfoCommand implements ICommand {

	@Override
	public void execute(ExtendedMessageReceivedEvent e, String[] args) {
		if(args.length>=2) {
			String roleNameRaw = Arrays.stream(args).collect(Collectors.joining(" ")).replace(args[0]+" ", "");
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
