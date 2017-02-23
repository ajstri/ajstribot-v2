package ajstri.commands.music;

import ajstri.Category;
import ajstri.Main;
import ajstri.Permission;
import ajstri.commands.Command;
import net.dv8tion.jda.core.entities.VoiceChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;

public class JoinVoiceCommand implements Command {

	@Override
	public void execute(MessageReceivedEvent e, String[] args) {
		if(args!=null) {
		    for(VoiceChannel vc : e.getGuild().getVoiceChannels()) {
		    	System.out.println(vc.getName().substring(2));
		        if((vc.getName().substring(2)).equals(args[1])) {
		            Main.ami = e.getGuild().getAudioManager();
		            Main.ami.openAudioConnection(vc);
		            e.getTextChannel().sendMessage("Connected To: **" + vc.getName() + "**").queue();
		        }
		    }
		}
	}
	
	@Override
	public void execute(PrivateMessageReceivedEvent e, String[] args) {
		e.getAuthor().getPrivateChannel().startCall();
	}

	@Override
	public Permission getValidExecutors() {
		return Permission.Everyone;
	}

	@Override
	public String getInfo() {
		return "Join voice channel.";
	}

	@Override
	public Category category() {
		return Category.Music;
	}
}
