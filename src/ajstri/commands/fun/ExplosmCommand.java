package ajstri.commands.fun;

import java.awt.Color;

import ajstri.Category;
import quack.ddbl.core.api.Explosm_API;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

public class ExplosmCommand extends ICommand {

	public ExplosmCommand() {
		super("explosm", "ex");
		setDescription("Random Explosm");
		setCategory(Category.FUN);
	}
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		if(e.args.length==1) Explosm_API.getRandomExplosmComic().after(c -> {
			e.sendMessage(c.asMessageEmbed(Color.GREEN));
		});
		if(e.args.length==2) Explosm_API.getExplosmComic(e.args[1]).after(c -> {
			e.sendMessage(c.asMessageEmbed(Color.GREEN));
		});;
	}
}
