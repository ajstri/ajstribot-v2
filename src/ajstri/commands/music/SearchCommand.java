package ajstri.commands.music;

import java.util.Arrays;
import java.util.stream.Collectors;

import quack.ddbl.core.commands.Command;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

@Command(aliases={"play-s", "search"}, guildOnly=true, permissions={"ajstri.music.search"}, description="Search a YouTube Song")
public class SearchCommand implements ICommand {

	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		String search = Arrays.asList(e.args).stream().collect(Collectors.joining(" ")).replace(e.args[0]+" ", "");
		e.getAudioManager().searchWOAction(search, e, false);
	}
}