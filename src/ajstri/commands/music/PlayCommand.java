package ajstri.commands.music;

import ajstri.Category;
import ajstri.commands.ICommand;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

@Command(aliases={"play"}, permission="ajstri.music.play", description="Unpause the player, or add a song")
public class PlayCommand implements ICommand {
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e, String[] args) {
		if(args.length==1) {
			e.getAudioManager().playWOAction(e);
			return;
		}
		if(args.length==2) {
			e.getAudioManager().playWOAction(args[1], e);
			return;
		}
	}
	
	@Override
	public Category setCategory() {
		return Category.Music;
	}
	
}