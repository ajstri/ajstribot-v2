package ajstri.commands.music;

import quack.ddbl.core.DDBLCore;
import quack.ddbl.core.message.ExtendedMessageReceivedEvent;

public class PauseCommand extends MusicCommand {

	public PauseCommand() {
		super("pause");
	}
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		DDBLCore.getAudioManager().pause(e);
	}

}
