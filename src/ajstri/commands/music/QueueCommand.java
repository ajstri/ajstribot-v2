package ajstri.commands.music;

import ajstri.Category;
import ajstri.commands.ICommand;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

@Command(aliases={"list", "queue"}, permission="ajstri.music.list", description="List the Songs in queue, or add a Song queue [url]")
public class QueueCommand implements ICommand {
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e, String[] args) {
		if(args.length == 2 && args[0].contains("queue")) {
			e.getAudioManager().playWOAction(args[1], e);
			return;
		}
		e.getAudioManager().listWOAction(e);
	}
	
	@Override
	public Category setCategory() {
		return Category.Music;
	}
	
}
