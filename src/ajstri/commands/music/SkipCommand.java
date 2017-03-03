package ajstri.commands.music;

import quack.ddbl.core.message.ExtendedMessageReceivedEvent;

public class SkipCommand extends MusicCommand {

	public SkipCommand() {
		super("skip");
	}
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		e.getAudioManager().skip(e);
	}
}
