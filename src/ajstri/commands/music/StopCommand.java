package ajstri.commands.music;

import quack.ddbl.core.commands.Command;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

@Command(aliases={"leave"}, guildOnly=true, permissions={"ddbl.music.leave"}, description="Makes the Bot leave the connected VoiceChannel")
public class StopCommand implements ICommand {
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e, String[] args) {
		e.getAudioManager().stopWOAction(e);
		e.getAudioManager().leaveWOAction(e);
	}
}
