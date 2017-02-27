package ajstri;

import ajstri.commands.admin.AdminTestCommand;
import ajstri.commands.admin.BanCommand;
import ajstri.commands.admin.EmbedCommand;
import ajstri.commands.admin.GetIDCommand;
import ajstri.commands.admin.GuildInfoCommand;
import ajstri.commands.admin.RoleInfoCommand;
import ajstri.commands.admin.UserInfoCommand;
import ajstri.commands.fun.BanHammerCommand;
import ajstri.commands.fun.CryCommand;
import ajstri.commands.fun.FishCommand;
import ajstri.commands.fun.GiggleCommand;
import ajstri.commands.generic.HelpCommand;
import ajstri.commands.generic.WelcomeCommand;
import ajstri.commands.music.JoinVoiceCommand;
import ajstri.commands.music.LeaveVoiceCommand;
import net.dv8tion.jda.core.managers.AudioManager;
import quack.ddbl.core.DDBLCore;

public class Main extends DDBLCore {
	
	public Main() {
		super(Data.cmdPrefix, Data.TOKEN);
	}
	
	public static AudioManager ami;
	
	public static void main(String[] args) {
		new Main();
	}

	@Override
	public void onStart() {
		registerCommand(new AdminTestCommand());
		registerCommand(new BanCommand());
		registerCommand(new EmbedCommand());
		registerCommand(new GetIDCommand());
		registerCommand(new GuildInfoCommand());
		registerCommand(new RoleInfoCommand());
		registerCommand(new UserInfoCommand());
		registerCommand(new BanHammerCommand());
		registerCommand(new CryCommand());
		registerCommand(new FishCommand());
		registerCommand(new GiggleCommand());
		registerCommand(new HelpCommand());
		registerCommand(new WelcomeCommand());
		registerCommand(new JoinVoiceCommand());
		registerCommand(new LeaveVoiceCommand());
	}
	
}
