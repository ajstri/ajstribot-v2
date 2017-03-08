package ajstri.commands.music;

import java.util.Arrays;
import java.util.stream.Collectors;

import ajstri.Category;
import ajstri.commands.ICommand;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.message.ExtendedMessageReceivedEvent;

@Command(aliases={"join"}, permission="ajstri.music.join", description="Make Bot join a VoiceChannel")
public class JoinVoiceCommand implements ICommand {

	@Override
	public void execute(ExtendedMessageReceivedEvent e, String[] args) {
		if(args.length==1) {
			e.getAudioManager().join(e);
			return;
		}
		if(args.length>=2) {
			String voice = Arrays.stream(args).collect(Collectors.joining(" ")).replace(args[0]+" ", "");
			e.getAudioManager().join(voice, e);
			return;
		}
	}
	
	@Override
	public Category setCategory() {
		return Category.Music;
	}
	
}
