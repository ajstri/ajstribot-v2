package ajstri.commands.fun;

import java.awt.Color;

import ajstri.Category;
import quack.ddbl.core.api.Dog_API;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

public class DogCommand extends ICommand {

	public DogCommand() {
		super("dog", "woof");
		setDescription("Get a random dog picture");
		setCategory(Category.FUN);
	}
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		Dog_API.getRandomDogPicture().after(c -> {
			e.sendMessage(c.asMessageEmbed(Color.GREEN));
		});
	}
}