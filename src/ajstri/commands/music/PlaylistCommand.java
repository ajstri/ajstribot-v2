package ajstri.commands.music;

import ajstri.Category;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

public class PlaylistCommand extends ICommand {
	
	public PlaylistCommand() {
		super("playlist", "pplay");
		setCategory(Category.MUSIC);
		setPermissions("ajstri.music.playlist");
		setGuildOnly(true);
		setDescription("Add a playlist to queue");
	}
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		//if(e.args.length==2) e.getAudioManager().playlistPlay(e.args[1], e);
		for(int a = 0; a < 50; a++) {
			e.getAudioManager().playWOAction("https://www.youtube.com/watch?v=E1-W7egBC0k", e);
		}
	}
}
