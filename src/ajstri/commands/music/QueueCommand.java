package ajstri.commands.music;

import ajstri.Category;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

public class QueueCommand extends ICommand {
	
	public QueueCommand() {
		super("queue");
		setCategory(Category.MUSIC);
		setPermissions("ajstri.music.queue");
		setGuildOnly(true);
		setDescription("List the songs in queue or add a song to the queue.");
	}
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		if(e.args.length == 2 && e.args[0].contains("queue")) {
			e.getAudioManager().playWOAction(e.args[1], e);
			//e.getAudioManager().playWOAction("https://www.youtube.com/watch?v=E1W7egBC0k", e);
			return;
		}
		e.getAudioManager().listWOAction(e);
	}
	
}
