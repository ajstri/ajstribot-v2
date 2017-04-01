package ajstri.commands.fun;

import java.awt.Color;

import ajstri.Category;
import quack.ddbl.core.api.Cat_API;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

public class CatCommand extends ICommand {

	public CatCommand() {
		super("cat", "neko");
		setDescription("Get a random cat picture");
		setCategory(Category.FUN);
		setPermissions("ajstri.fun.cat");
	}
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		Cat_API.getRandomCatPicture().after(c -> {
			e.sendMessage(c.asMessageEmbed(Color.GREEN));
		});
	}
}