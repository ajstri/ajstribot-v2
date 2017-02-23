package ajstri.commands.music;

import ajstri.Category;
import ajstri.Main;
import ajstri.Permission;
import ajstri.UserUtils;
import ajstri.commands.Command;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;

public class LeaveVoiceCommand implements Command {

	@Override
	public void execute(GuildMessageReceivedEvent e, String[] args) {
		if(Main.ami!=null) Main.ami.closeAudioConnection();
		e.getChannel().sendMessage("Okay, bye! Have a nice day :wink:").queue();
		System.out.println("Executed in Guild: LEAVE");
	}
	
	@Override
	public void execute(PrivateMessageReceivedEvent e, String[] args) {
		UserUtils.sendPrivateMessage2(e, "B-b-b-b-but...this isn't a *guild*!");
		System.out.println("Attempt to Execute in DM: LEAVE");
	}
	
	@Override
	public Permission getValidExecutors() {
		return Permission.Everyone;
	}

	@Override
	public String getInfo() {
		return "Leave voice channel";
	}

	@Override
	public Category category() {
		return Category.Music;
	}
}
