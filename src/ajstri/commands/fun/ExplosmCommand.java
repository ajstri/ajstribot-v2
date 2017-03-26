package ajstri.commands.fun;

import java.awt.Color;

import ajstri.Category;
import quack.ddbl.core.api.Explosm_API;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

@Command(aliases={"explosm", "ex"}, category=Category.FUN, description="Random Explosm")
public class ExplosmCommand implements ICommand {

	@Override
	public void execute(ExtendedMessageReceivedEvent e, String[] args) {
		if(args.length==1) Explosm_API.getRandomExplosmComic().after(c -> {
			e.sendMessage(c.asMessageEmbed(Color.GREEN));
		});
		if(args.length==2) Explosm_API.getExplosmComic(args[1]).after(c -> {
			e.sendMessage(c.asMessageEmbed(Color.GREEN));
		});;
	}

}
