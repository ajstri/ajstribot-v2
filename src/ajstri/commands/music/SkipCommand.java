package ajstri.commands.music;

import ajstri.Category;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

@Command(aliases={"skip"}, category=Category.MUSIC, permissions={"ajstri.music.skip"}, description="Skip the current Track")
public class SkipCommand implements ICommand {
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		e.getAudioManager().skipWOAction(e);
	}
	
}
