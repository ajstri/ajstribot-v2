package ajstri.commands.fun;

import java.awt.Color;

import ajstri.Category;
import quack.ddbl.core.api.Dog_API;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

@Command(aliases={"dog", "woof"}, category=Category.FUN, description="Get a random Dog picture")
public class DogCommand implements ICommand {

	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		Dog_API.getRandomDogPicture().after(c -> {
			e.sendMessage(c.asMessageEmbed(Color.GREEN));
		});
	}
}