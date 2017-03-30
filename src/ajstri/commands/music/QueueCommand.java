package ajstri.commands.music;

import ajstri.Category;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

@Command(aliases={"list", "queue"}, category=Category.MUSIC, permissions={"ajstri.music.list"}, description="List the Songs in queue, or add a Song queue [url]")
public class QueueCommand implements ICommand {
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		if(e.args.length == 2 && e.args[0].contains("queue")) {
			e.getAudioManager().play(e.args[1], e);
			return;
		}
		e.getAudioManager().listWOAction(e);
	}
	
}
