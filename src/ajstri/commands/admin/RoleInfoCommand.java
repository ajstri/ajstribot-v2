package ajstri.commands.admin;

import java.awt.Color;
import java.util.Arrays;
import java.util.stream.Collectors;

import ajstri.Category;
import ajstri.commands.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Role;
import quack.ddbl.core.message.ExtendedMessageReceivedEvent;

public class RoleInfoCommand extends Command {

	public RoleInfoCommand() {
		super(new String[]{"roleinfo"}, Permission.ADMINISTRATOR, true);
	}

	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		if(args.length>=2) {
			String roleNameRaw = Arrays.stream(args).collect(Collectors.joining(" ")).replace(args[0]+" ", "");
			roleNameRaw = roleNameRaw.replaceFirst("@", "");
			Role role = e.getGuild().getRolesByName(roleNameRaw, false).get(0);
			if(role==null) {
				e.sendMessage("The reqested role could not be found!");
				return;
			}
			EmbedBuilder eb = new EmbedBuilder();
			eb.setColor(null);
			eb.addField(role.getName(), 
					"**"+(e.getGuild().getMembersWithRoles(role).size()==1?"User":"Users")+"with Role:** "+e.getGuild().getMembersWithRoles(role).size()+"\n"
					+ "**Position:** "+role.getPosition()+"\n"
					+ "**Mentionable:** "+role.isMentionable()+"\n"
					+ "**Color Values** [R:"+role.getColor().getRed()+", G:"+role.getColor().getGreen()+", B:"+role.getColor().getBlue()+"]", true);
			e.sendMessage(eb.build());
		}
	}

	@Override
	public String setCommandInfo() {
		return "See some information about an Role...";
	}

	@Override
	public Category setCategory() {
		return Category.Admin;
	}
	
}
