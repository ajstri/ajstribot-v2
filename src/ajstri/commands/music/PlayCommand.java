package ajstri.commands.music;

import ajstri.Category;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

@Command(aliases={"play"}, category=Category.MUSIC, permissions={"ajstri.music.play"}, description="Unpause the player, or add a song")
public class PlayCommand implements ICommand {
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		if(e.args.length==1) {
			e.getAudioManager().playWOAction(e);
			return;
		}
		if(e.args.length==2) {
			e.getAudioManager().play(e.args[1], e);
			return;
		}
	}
	
}