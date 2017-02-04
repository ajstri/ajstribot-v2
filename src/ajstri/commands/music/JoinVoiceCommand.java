package ajstri.commands.music;

import ajstri.Category;
import ajstri.Permission;
import ajstri.commands.Command;
import net.dv8tion.jda.core.entities.VoiceChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.managers.AudioManager;

public class JoinVoiceCommand implements Command {

	@Override
	public void execute(MessageReceivedEvent e, String[] args) {
		if(args!=null) {
		    for(VoiceChannel vc : e.getGuild().getVoiceChannels()) {
		        if(vc.getName().equals(args[1])) {
		            AudioManager ami = e.getGuild().getAudioManager();
		            ami.openAudioConnection(vc);
		        }
		    }
		}
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
