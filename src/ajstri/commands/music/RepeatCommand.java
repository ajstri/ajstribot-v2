package ajstri.commands.music;

import quack.ddbl.core.DDBLCore;
import quack.ddbl.core.message.ExtendedMessageReceivedEvent;

public class RepeatCommand extends MusicCommand {

	public RepeatCommand () {
		super("repeat");
	}
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		DDBLCore.getAudioManager().repeat(e);
	}
}
