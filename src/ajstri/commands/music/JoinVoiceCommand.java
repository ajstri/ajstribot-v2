package ajstri.commands.music;

import ajstri.Category;
import ajstri.Main;
import ajstri.Permission;
import ajstri.UserUtils;
import ajstri.commands.Command;
import net.dv8tion.jda.core.entities.VoiceChannel;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;

public class JoinVoiceCommand implements Command {

	@Override
	public void execute(GuildMessageReceivedEvent e, String[] args) {
		if(args!=null) {
		    for(VoiceChannel vc : e.getGuild().getVoiceChannels()) {
		        if((vc.getName().substring(2)).equals(args[1])) {
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
	public void execute(PrivateMessageReceivedEvent e, String[] args) {
		UserUtils.sendPrivateMessage2(e, "B-b-b-b-but...this isn't a *guild*!");
		System.out.println(e.getAuthor() + "Attempt to Execute in DM: JOIN");
	}

	@Override
	public Permission getValidExecutors() {
		return Permission.Everyone;
	}

	@Override
	public String getInfo() {
		return "Join voice channel.";
	}

	@Override
	public Category category() {
		return Category.Music;
	}
}
