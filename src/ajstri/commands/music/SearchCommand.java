package ajstri.commands.music;

//import java.util.Arrays;
//import java.util.stream.Collectors;

import ajstri.Category;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

public class SearchCommand extends ICommand {

	public SearchCommand() {
		super("search", "play-s");
		setCategory(Category.MUSIC);
		setPermissions("ajstri.music.search");
		setGuildOnly(true);
		setDescription("Search for a song to add to queue");
	}
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		/*String search = Arrays.asList(e.args).stream().collect(Collectors.joining(" ")).replace(e.args[0]+" ", "");
		e.getAudioManager().searchWOAction(search, e, false);*/
		e.getAudioManager().playWOAction("https://www.youtube.com/watch?v=E1-W7egBC0k", e);
	}
}