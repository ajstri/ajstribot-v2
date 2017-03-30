package ajstri.commands.music;

import java.awt.Color;

import ajstri.Category;
import net.dv8tion.jda.core.EmbedBuilder;
import quack.ddbl.core.commands.Command;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;

@Command(aliases={"volume", "v"}, category=Category.MUSIC, description="Volume...", permissions={"ajstri.music.volume"})
public class VolumeCommand implements ICommand {

	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		if(e.args.length==1) e.getAudioManager().volumeWOAction(e);
		else if(e.args.length==2) {
			int newVolume = 0;
			try {
				newVolume = Integer.parseInt(e.args[1]);
				if(newVolume<0||newVolume>100) {
					EmbedBuilder eb = new EmbedBuilder();
					eb.setColor(Color.RED);
					eb.addField("Invalid Number", "The number does not fit the allowed range of {0-100}", true);
					e.sendMessage(eb.build());
					return;
				}
			} catch(NumberFormatException ex) {
				EmbedBuilder eb = new EmbedBuilder();
				eb.setColor(Color.RED);
				eb.addField("Invalid Number", "Please only give valid numbers! {0-100}", true);
				e.sendMessage(eb.build());
				return;
			}
			e.getAudioManager().volumeWOAction(newVolume, e);
		}
	}
	
}
