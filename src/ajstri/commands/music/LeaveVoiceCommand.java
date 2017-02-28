package ajstri.commands.music;

import quack.ddbl.core.DDBLCore;
import quack.ddbl.core.message.ExtendedMessageReceivedEvent;

public class LeaveVoiceCommand extends MusicCommand {

	public LeaveVoiceCommand() {
		super("leave");
	}
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		DDBLCore.getAudioManager().leave(e);
	}
}
