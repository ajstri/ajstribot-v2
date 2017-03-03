package ajstri.commands.music;

import quack.ddbl.core.message.ExtendedMessageReceivedEvent;

public class NowPlayingCommand extends MusicCommand {

	public NowPlayingCommand() {
		super("nowplaying", "np");
	}
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		e.getAudioManager().nowPlaying(e);
	}

}
