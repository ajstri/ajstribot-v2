package ajstri.commands.music;

import java.util.Arrays;
import java.util.stream.Collectors;

import ajstri.Category;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

public class JoinVoiceCommand extends ICommand {

	public JoinVoiceCommand() {
		super("join");
		setCategory(Category.MUSIC);
		setPermissions("ajstri.music.join");
		setDescription("Make the Bot join a Voice Channel");
		setGuildOnly(true);
	}
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		if(e.args.length==1) {
			e.getAudioManager().joinWOAction(e);
			return;
		}
		if(e.args.length>=2) {
			String voice = Arrays.stream(e.args).collect(Collectors.joining(" ")).replace(e.args[0]+" ", "");
			e.getAudioManager().joinWOAction(voice, e);
			return;
		}
	}
	
}
