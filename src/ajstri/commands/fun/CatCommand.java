package ajstri.commands.fun;

import java.awt.Color;

import ajstri.Category;
import quack.ddbl.core.api.Cat_API;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

@Command(aliases={"cry"}, category=Category.FUN, description="Random Cats")
public class CatCommand implements ICommand {

	@Override
	public void execute(ExtendedMessageReceivedEvent e, String[] args) {
		Cat_API.getRandomCatPicture().after(c -> {
			e.sendMessage(c.asMessageEmbed(Color.GREEN));
		});
	}
}
