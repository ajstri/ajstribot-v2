package ajstri.commands.admin;

import ajstri.Category;
import ajstri.Permission;
import ajstri.UserUtils;
import ajstri.commands.Command;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;

public class EmbedCommand implements Command {

	public void execute(MessageReceivedEvent e, String[] args) {
		User m = e.getAuthor();
		e.getTextChannel().sendMessage(m.getAsMention() + ": What do you want?").queue();
		UserUtils.sendPrivateMessage(e, "Hi, I like you");
	}
	
	@Override
	public void execute(PrivateMessageReceivedEvent e, String[] args) {
		UserUtils.sendPrivateMessage2(e, "Hi, I like you");
	}

	@Override
	public Permission getValidExecutors() {
		return Permission.Admins;
	}

	@Override
	public String getInfo() {
		return "Test Command";
	}

	@Override
	public Category category() {
		return Category.Admin;
	}
}
