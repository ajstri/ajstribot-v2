package ajstri.commands.music;

import ajstri.Category;
import ajstri.commands.ICommand;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

@Command(aliases={"skip"}, permission="ajstri.music.skip", description="Skip the current Track")
public class SkipCommand implements ICommand {
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e, String[] args) {
		e.getAudioManager().skipWOAction(e);
	}
	
	@Override
	public Category setCategory() {
		return Category.Music;
	}
	
}
