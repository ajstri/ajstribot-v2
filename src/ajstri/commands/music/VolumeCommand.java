package ajstri.commands.music;

import java.awt.Color;

import net.dv8tion.jda.core.EmbedBuilder;
import quack.ddbl.core.message.ExtendedMessageReceivedEvent;


public class VolumeCommand extends MusicCommand {
	
	public VolumeCommand() {
		super("volume", "v");
	}

	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		if(args.length==1) e.getAudioManager().volumeWOAction(e);
		else if(args.length==2) {
			int newVolume = 0;
			try {
				newVolume = Integer.parseInt(args[1]);
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
