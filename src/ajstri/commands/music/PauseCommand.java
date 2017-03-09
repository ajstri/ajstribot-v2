package ajstri.commands.music;

import ajstri.Category;
import ajstri.commands.ICommand;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

@Command(aliases={"pause"}, permission="ajstri.music.pause", description="Pause/Unpause the Music")
public class PauseCommand implements ICommand {
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e, String[] args) {
		e.getAudioManager().pause(e);
	}
	
	@Override
	public Category setCategory() {
		return Category.Music;
	}

}
