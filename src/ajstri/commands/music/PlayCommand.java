package ajstri.commands.music;

import quack.ddbl.core.message.ExtendedMessageReceivedEvent;

public class PlayCommand extends MusicCommand {

	public PlayCommand() {
		super("play");
	}
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		if(args.length==1) {
			e.getAudioManager().play(e);
			return;
		}
		if(args.length==2) {
			e.getAudioManager().play(args[1], e);
			return;
		}
	}
}