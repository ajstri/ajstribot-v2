package ajstri.commands.music;

import ajstri.Category;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

@Command(aliases={"playlist", "pplay"}, category=Category.MUSIC, guildOnly=true, description="Add a playlist to the queue")
public class PlaylistCommand implements ICommand {
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e, String[] args) {
		if(args.length==2) e.getAudioManager().playlistPlay(args[1], e);
	}
}
