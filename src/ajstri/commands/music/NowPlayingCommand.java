package ajstri.commands.music;

import ajstri.Category;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

@Command(aliases={"nowplaying", "np"}, category=Category.MUSIC, permissions={"ajstri.music.nowplaying"}, description="See the current playing track")
public class NowPlayingCommand implements ICommand {
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e, String[] args) {
		e.getAudioManager().nowPlayingWOAction(e);
	}

}
