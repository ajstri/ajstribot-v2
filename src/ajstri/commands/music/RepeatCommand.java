package ajstri.commands.music;

import ajstri.Category;
import ajstri.commands.ICommand;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

@Command(aliases={"repeat"}, permission="ajstri.music.repeat", description="Set the player to repeat/non-repeat")
public class RepeatCommand implements ICommand {
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e, String[] args) {
		e.getAudioManager().repeat(e);
	}
	
	@Override
	public Category setCategory() {
		return Category.Music;
	}
	
}
