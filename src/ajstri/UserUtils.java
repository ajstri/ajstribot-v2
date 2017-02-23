package ajstri;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;

public class UserUtils {
	
	public static void sendPrivateMessage(MessageReceivedEvent e, String msg) {
		e.getAuthor().openPrivateChannel().queue(success -> {
			e.getAuthor().getPrivateChannel().sendMessage(msg).queue();
		});
	}
	
	public static void sendPrivateMessage2(PrivateMessageReceivedEvent e, String msg) {
		e.getAuthor().openPrivateChannel().queue(success -> {
			e.getAuthor().getPrivateChannel().sendMessage(msg).queue();
		});
	}
}
