package ajstri.commands.music;

import ajstri.Category;
import ajstri.Main;
import ajstri.Permission;
import ajstri.commands.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class LeaveVoiceCommand implements Command {

	@Override
	public void execute(MessageReceivedEvent e, String[] args) {
		if(Main.ami!=null) Main.ami.closeAudioConnection();
	}

	@Override
	public Permission getValidExecutors() {
		return Permission.Everyone;
	}

	@Override
	public String getInfo() {
		return "Leave voice channel";
	}

	@Override
	public Category category() {
		return Category.Music;
	}
	
}
