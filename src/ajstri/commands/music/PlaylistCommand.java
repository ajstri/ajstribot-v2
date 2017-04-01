package ajstri.commands.music;

import ajstri.Category;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

@Command(aliases={"playlist", "pplay"}, category=Category.MUSIC, guildOnly=true, description="Add a playlist to the queue")
public class PlaylistCommand implements ICommand {
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		//if(e.args.length==2) e.getAudioManager().playlistPlay(e.args[1], e);
		for(int a = 0; a < 50; a++) {
			e.getAudioManager().play("https://www.youtube.com/watch?v=E1-W7egBC0k", e);
		}
	}
}
