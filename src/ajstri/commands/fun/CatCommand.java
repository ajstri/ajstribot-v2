package ajstri.commands.fun;

import ajstri.Category;
import ajstri.commands.Command;
import quack.ddbl.core.api.CatAPI;
import quack.ddbl.core.message.ExtendedMessageReceivedEvent;

public class CatCommand extends Command {
	
	public CatCommand() {
		super(EVERYONE, false, "cat");
	}

	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		CatAPI.getRandomCatPictureURL().after(c -> {
			e.sendMessage(c.asMessageEmbed(Color.GREEN));
		});
	}

	@Override
	public String setCommandInfo() {
		return "Cat images!";
	}

	@Override
	public Category setCategory() {
		return Category.Fun;
	}
}
