package ajstri.commands.music;

import ajstri.Category;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

public class StopCommand extends ICommand {
	
	public StopCommand() {
		super("stop");
		setCategory(Category.MUSIC);
		setPermissions("ajstri.music.stop");
		setGuildOnly(true);
		setDescription("Make the bot clear the queue and leave the voice channel");
	}
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		e.getAudioManager().stopWOAction(e);
		e.getAudioManager().leaveWOAction(e);
	}
}
