package ajstri.commands.music;

import ajstri.Category;
import ajstri.commands.Command;
import quack.ddbl.core.DDBLCore;
import quack.ddbl.core.message.ExtendedMessageReceivedEvent;

public class LeaveVoiceCommand extends Command {

	public LeaveVoiceCommand() {
		super(EVERYONE, true, "leave");
	}
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		DDBLCore.getAudioManager().leave(e);
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
