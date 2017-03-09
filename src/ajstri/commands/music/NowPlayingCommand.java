package ajstri.commands.music;

import ajstri.Category;
import ajstri.commands.ICommand;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

@Command(aliases={"nowplaying", "np"}, permission="ajstri.music.nowplaying", description="See the current playing track")
public class NowPlayingCommand implements ICommand {
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e, String[] args) {
		e.getAudioManager().nowPlaying(e);
	}
	
	@Override
	public Category setCategory() {
		return Category.Music;
	}

}
