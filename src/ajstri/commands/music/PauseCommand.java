package ajstri.commands.music;

import ajstri.Category;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

@Command(aliases={"pause"}, category=Category.MUSIC, permission="ajstri.music.pause", description="Pause/Unpause the Music")
public class PauseCommand implements ICommand {
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e, String[] args) {
		e.getAudioManager().pauseWOAction(e);
	}

}
