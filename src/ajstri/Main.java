package ajstri;

import ajstri.commands.admin.*;
import ajstri.commands.fun.*;
import ajstri.commands.generic.*;
import ajstri.commands.music.*;
import quack.ddbl.core.DDBLCore;

public class Main extends DDBLCore {
	
	public Main() {
		super(Data.cmdPrefix, Data.TOKEN);
	}
	
	public static void main(String[] args) {
		new Main();
	}

	@Override
	public void onStart() {
		registerCommand(new AdminTestCommand());
		registerCommand(new BanCommand());
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
		registerCommand(new PlayCommand());
		registerCommand(new QueueCommand());
		registerCommand(new PauseCommand());
		registerCommand(new NowPlayingCommand());
		registerCommand(new SkipCommand());
		registerCommand(new RepeatCommand());
	}
}
