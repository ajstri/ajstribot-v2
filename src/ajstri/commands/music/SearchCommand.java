package ajstri.commands.music;

import java.util.Arrays;
import java.util.stream.Collectors;

import quack.ddbl.core.commands.Command;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

@Command(aliases={"search"}, guildOnly=true, permissions={"ajstri.music.search"}, description="Search a YouTube Song")
public class SearchCommand implements ICommand {

	@Override
	public void execute(ExtendedMessageReceivedEvent e, String[] args) {
		String search = Arrays.asList(args).stream().collect(Collectors.joining(" ")).replace(args[0]+" ", "");
		e.getAudioManager().searchWOAction(search, e, false);
	}
}