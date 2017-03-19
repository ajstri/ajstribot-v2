package ajstri.commands.music;

import java.util.Arrays;
import java.util.stream.Collectors;

import ajstri.Category;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

@Command(aliases={"join"}, category=Category.MUSIC, permission="ajstri.music.join", description="Make Bot join a VoiceChannel")
public class JoinVoiceCommand implements ICommand {

	@Override
	public void execute(ExtendedMessageReceivedEvent e, String[] args) {
		if(args.length==1) {
			e.getAudioManager().joinWOAction(e);
			return;
		}
		if(args.length>=2) {
			String voice = Arrays.stream(args).collect(Collectors.joining(" ")).replace(args[0]+" ", "");
			e.getAudioManager().joinWOAction(voice, e);
			return;
		}
	}
	
}
