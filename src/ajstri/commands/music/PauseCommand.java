package ajstri.commands.music;

import ajstri.Category;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

public class PauseCommand extends ICommand {
	
	public PauseCommand() {
		super("pause");
		setCategory(Category.MUSIC);
		setPermissions("ajstri.music.pause");
		setGuildOnly(true);
		setDescription("Pause/Unpause the music");
	}
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		e.getAudioManager().pauseWOAction(e);
	}

}
