package ajstri.commands.music;

import ajstri.Category;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

public class LeaveVoiceCommand extends ICommand {
	
	public LeaveVoiceCommand() {
		super("leave");
		setCategory(Category.MUSIC);
		setPermissions("ajstri.music.leave");
		setGuildOnly(true);
		setDescription("Make the Bot leave the Voice Channel");
	}
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		e.getAudioManager().leaveWOAction(e);
	}
	
}
