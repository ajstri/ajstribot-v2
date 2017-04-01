package ajstri.commands.music;

import ajstri.Category;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

public class RepeatCommand extends ICommand {
	
	public RepeatCommand() {
		super("repeat");
		setCategory(Category.MUSIC);
		setPermissions("ajstri.music.repeat");
		setGuildOnly(true);
		setDescription("Repeat the current song");
	}
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		e.getAudioManager().repeatWOAction(e);
	}
	
}
