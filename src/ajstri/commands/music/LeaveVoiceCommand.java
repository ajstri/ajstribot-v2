package ajstri.commands.music;

import ajstri.Category;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

@Command(aliases={"leave"}, category=Category.MUSIC, permission="ajstri.music.leave", description="Make the Bot leave the VoiceChannel")
public class LeaveVoiceCommand implements ICommand {
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e, String[] args) {
		e.getAudioManager().leaveWOAction(e);
	}
	
}
