package ajstri.commands.music;

import java.util.Arrays;
import java.util.stream.Collectors;

import quack.ddbl.core.message.ExtendedMessageReceivedEvent;

public class JoinVoiceCommand extends MusicCommand {

	public JoinVoiceCommand() {
		super("join");
	}

	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
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
}
