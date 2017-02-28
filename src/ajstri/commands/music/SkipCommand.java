package ajstri.commands.music;

import quack.ddbl.core.DDBLCore;
import quack.ddbl.core.message.ExtendedMessageReceivedEvent;

public class SkipCommand extends MusicCommand {

	public SkipCommand() {
		super("skip");
	}
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		DDBLCore.getAudioManager().skip(e);
	}
}
