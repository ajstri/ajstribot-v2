package ajstri.commands.music;

import ajstri.Category;
import ajstri.Main;
import ajstri.commands.Command;
import net.dv8tion.jda.core.entities.VoiceChannel;
import quack.ddbl.core.message.ExtendedMessageReceivedEvent;

public class JoinVoiceCommand extends Command {

	public JoinVoiceCommand() {
		super(new String[]{"join"}, EVERYONE, true);
	}

	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		if(args.length==2) {
		    for(VoiceChannel vc : e.getGuild().getVoiceChannels()) {
		        if(vc.getName().contentEquals(args[1])) {
		            Main.ami = e.getGuild().getAudioManager();
		            Main.ami.openAudioConnection(vc);
		            e.getChannel().sendMessage("Connected To: **" + vc.getName() + "**").queue();
		            System.out.println(e.getAuthor() + "Executed in Guild: JOIN");
		        } else {
		        	if(vc.getName().equals(args[1])){
		        		Main.ami = e.getGuild().getAudioManager();
			            Main.ami.openAudioConnection(vc);
			            e.getChannel().sendMessage("Connected To: **" + vc.getName() + "**").queue();
			            System.out.println(e.getAuthor() + "Executed in Guild: JOIN");
		        	}
		        }
		    }
		}
	}

	@Override
	public String setCommandInfo() {
		return "Make me join the voice channel that you currently are in";
	}

	@Override
	public Category setCategory() {
		return Category.Music;
	}
	
}
