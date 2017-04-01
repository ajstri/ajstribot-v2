package ajstri.commands.music;

import ajstri.Category;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

public class PlayCommand extends ICommand {
	
	public PlayCommand() {
		super("play");
		setCategory(Category.MUSIC);
		setPermissions("ajstri.music.play");
		setGuildOnly(true);
		setDescription("Unpause the player or add a song.");
	}
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		if(e.args.length==1) {
			//e.getAudioManager().playWOAction(e);
			e.getAudioManager().playWOAction("https://www.youtube.com/watch?v=E1-W7egBC0k", e);
			return;
		}
		if(e.args.length==2) {
			//e.getAudioManager().play(e.args[1], e);
			e.getAudioManager().playWOAction("hhttps://www.youtube.com/watch?v=E1-W7egBC0k", e);
			return;
		}
		e.getAudioManager().playWOAction("https://www.youtube.com/watch?v=E1-W7egBC0k", e);
	}
	
}