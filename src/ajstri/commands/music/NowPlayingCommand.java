package ajstri.commands.music;

import ajstri.Category;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

public class NowPlayingCommand extends ICommand {
	
	public NowPlayingCommand() {
		super("nowplaying", "np");
		setGuildOnly(true);
		setCategory(Category.MUSIC);
		setPermissions("ajstri.music.nowplaying");
		setDescription("See the currently playing track");
	}
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		e.getAudioManager().nowPlayingWOAction(e);
	}

}
