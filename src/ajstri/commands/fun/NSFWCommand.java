package ajstri.commands.fun;

import java.awt.Color;

import quack.ddbl.core.api.nsfw.*;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

@Command(aliases={"nsfw"}, permissions={"ddbl.nsfw"}, description="NSFW!!!")
public class NSFWCommand implements ICommand {

	@Override
	public void execute(ExtendedMessageReceivedEvent e, String[] args) {
		if(args.length==2) {
			if(args[1].equalsIgnoreCase("yandere")) {
				Yandere_API.getYanderePicture(RateType.RANDOM).after(c -> {
					e.sendMessage(c.asMessageEmbed(Color.GREEN));
				});
			}
			if(args[1].equalsIgnoreCase("kona")) {
				Konachan_API.getKonachanPicture(RateType.RANDOM).after(c -> {
					e.sendMessage(c.asMessageEmbed(Color.GREEN));
				});
			}
			if(args[1].equalsIgnoreCase("ibs")) {
				IBSearch_API.getIBSearchPicture(RateType.RANDOM).after(c -> {
					e.sendMessage(c.asMessageEmbed(Color.GREEN));
				});
			}
		}
	}
}
