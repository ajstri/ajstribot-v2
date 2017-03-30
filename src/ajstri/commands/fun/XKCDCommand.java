package ajstri.commands.fun;

import java.awt.Color;

import quack.ddbl.core.api.XKCD_API;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

@Command(aliases={"xkcd", "comic"})
public class XKCDCommand implements ICommand {

	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		if(e.args.length==1) XKCD_API.getRandomXKCDComic().after(c -> {
			e.sendMessage(c.asMessageEmbed(Color.GREEN));
		});
		if(e.args.length==2) XKCD_API.getXKCDComic(e.args[1]).after(c -> {
			e.sendMessage(c.asMessageEmbed(Color.GREEN));
		});;
	}

}
