package ajstri.commands.fun;

import java.awt.Color;

import ajstri.Category;
import quack.ddbl.core.api.XKCD_API;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

public class XKCDCommand extends ICommand {

	public XKCDCommand() {
		super("xkcd", "comic");
		setDescription("XKCD Comic");
		setPermissions("ajstri.fun.xkcd");
		setCategory(Category.FUN);
	}
	
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
