package ajstri.commands.music;

import ajstri.Category;
import ajstri.commands.ICommand;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

@Command(aliases={"leave"}, permission="ajstri.music.leave", description="Make the Bot leave the VoiceChannel")
public class LeaveVoiceCommand implements ICommand {
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e, String[] args) {
		e.getAudioManager().leave(e);
	}
	
	@Override
	public Category setCategory() {
		return Category.Music;
	}
	
}
