package ajstri.commands.music;

import ajstri.Category;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

public class SkipCommand extends ICommand {
	
	public SkipCommand() {
		super("skip");
		setCategory(Category.MUSIC);
		setPermissions("ajstri.music.skip");
		setGuildOnly(true);
		setDescription("Skip the current song");
	}
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		e.getAudioManager().skipWOAction(e);
	}
	
}
