package ajstri.commands.music;

import ajstri.Category;
import ajstri.Main;
import ajstri.commands.Command;
import quack.ddbl.core.message.ExtendedMessageReceivedEvent;

public class LeaveVoiceCommand extends Command {

	public LeaveVoiceCommand() {
		super(new String[]{"leave"}, EVERYONE, true);
	}

	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		if(Main.ami!=null) if(Main.ami.isConnected()) Main.ami.closeAudioConnection();
		e.sendMessage("Okay, bye! Have a nice day :wink:");
	}

	@Override
	public String setCommandInfo() {
		return "Leave the connected voice channel";
	}

	@Override
	public Category setCategory() {
		return Category.Music;
	}
	
}
