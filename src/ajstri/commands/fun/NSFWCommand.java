package ajstri.commands.fun;

import java.awt.Color;

import quack.ddbl.core.api.nsfw.*;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

public class NSFWCommand extends ICommand {

	public NSFWCommand() {
		super("nsfw");
		setDescription("NSFW!");
		setPermissions("ajstri.fun.nsfw");
	}
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		if(e.args.length==2) {
			if(e.args[1].equalsIgnoreCase("yandere")) {
				Yandere_API.getYanderePicture(RateType.RANDOM).after(c -> {
					e.sendMessage(c.asMessageEmbed(Color.GREEN));
				});
			}
			if(e.args[1].equalsIgnoreCase("kona")) {
				Konachan_API.getKonachanPicture(RateType.RANDOM).after(c -> {
					e.sendMessage(c.asMessageEmbed(Color.GREEN));
				});
			}
			if(e.args[1].equalsIgnoreCase("ibs")) {
				IBSearch_API.getIBSearchPicture(RateType.RANDOM).after(c -> {
					e.sendMessage(c.asMessageEmbed(Color.GREEN));
				});
			}
		}
	}
}
