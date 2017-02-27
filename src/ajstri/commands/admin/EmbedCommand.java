package ajstri.commands.admin;

import ajstri.Category;
import ajstri.commands.Command;
import net.dv8tion.jda.core.Permission;
import quack.ddbl.core.message.ExtendedMessageReceivedEvent;
import quack.ddbl.core.message.MessageUtils;

public class EmbedCommand extends Command {

	public EmbedCommand() {
		super(new String[]{"em"}, Permission.ADMINISTRATOR, false);
	}

	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		if(e.isGuildMessage()) {
			e.sendMessage(e.getAuthor().getAsMention()+": What do you want?");
			MessageUtils.sendPrivateMessage(e.getAuthor(), "Hi, I like you");
		} else {
			e.sendMessage("Hi, I like you");
		}
	}

	@Override
	public Category setCategory() {
		return Category.Admin;
	}

	@Override
	public String setCommandInfo() {
		return "Test Command";
	}
	
}
