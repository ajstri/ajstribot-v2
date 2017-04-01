package ajstri.commands.admin;

import java.awt.Color;

import ajstri.Category;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Member;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;
import quack.ddbl.core.utils.MemberUtils;

public class UserInfoCommand extends ICommand {

	public UserInfoCommand() {
		super("userinfo");
		setDescription("See User Information");
		setCategory(Category.ADMIN);
		setPermissions(Permission.ADMINISTRATOR);
	}
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		if(e.isGuildMessage()) {
			EmbedBuilder eb = new EmbedBuilder();
			eb.setColor(Color.RED);
			if(e.args.length==1) {
	            e.sendMessage(e.getMemberUtils().getUserInfoFor(e.getMember()).asMessageEmbed(Color.RED));
	            return;
			}
			if(e.args.length>=2) {
				Member m = e.getGuild().getMembersByName(e.args[1].replaceFirst("@", ""), false).get(0);
				if(m == null) {
					e.sendMessage("Could not find requested User.");
					return;
				}
	            e.sendMessage(e.getMemberUtils().getUserInfoFor(m).asMessageEmbed(Color.RED));
	            return;
			}
		} else {
            e.sendMessage(new MemberUtils(null).getUserInfoFor(e.getAuthor()).asMessageEmbed(Color.RED));
            return;
		}
	}

}
