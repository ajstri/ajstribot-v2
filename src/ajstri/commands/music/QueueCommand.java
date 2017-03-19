package ajstri.commands.music;

import ajstri.Category;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

@Command(aliases={"list", "queue"}, category=Category.MUSIC, permission="ajstri.music.list", description="List the Songs in queue, or add a Song queue [url]")
public class QueueCommand implements ICommand {
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e, String[] args) {
		if(args.length == 2 && args[0].contains("queue")) {
			e.getAudioManager().play(args[1], e);
			return;
		}
		e.getAudioManager().listWOAction(e);
	}
	
}
