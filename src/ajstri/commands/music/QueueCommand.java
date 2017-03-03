package ajstri.commands.music;

import quack.ddbl.core.message.ExtendedMessageReceivedEvent;

public class QueueCommand extends MusicCommand {

	public QueueCommand() {
		super("list", "queue");
	}
	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		if(args.length == 2 && args[0].contains("queue")) {
			e.getAudioManager().play(args[1], e);
			return;
		}
		e.getAudioManager().list(e);
	}
}
