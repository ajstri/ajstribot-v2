package ajstri;

//import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;

public class UserUtils {
	
	public static void sendPrivateMessage(GuildMessageReceivedEvent e, String msg) {
		e.getAuthor().openPrivateChannel().queue(success -> {
			e.getAuthor().getPrivateChannel().sendMessage(msg).queue();
		});
	}
	
	public static void sendPrivateMessage2(PrivateMessageReceivedEvent e, String msg) {
		e.getAuthor().openPrivateChannel().queue(success -> {
			e.getAuthor().getPrivateChannel().sendMessage(msg).queue();
		});
	}
	/*
	public static void sendPrivateMessage3(PrivateMessageReceivedEvent e, EmbedBuilder msg) {
		e.getAuthor().openPrivateChannel().queue(success -> {
			e.getAuthor().getPrivateChannel().sendMessage(msg).queue();
		});
	}
	*/
}
