package ajstri;

import ajstri.commands.admin.*;
import ajstri.commands.fun.*;
import ajstri.commands.generic.*;
import ajstri.commands.music.*;
import quack.ddbl.core.DDBLCore;

public class Main extends DDBLCore {
	
	public Main() {
		super(Data.cmdPrefix, Data.TOKEN);
		startWithShards(4);
		authors = new String[]{"AJStri", "Felix Vogel"};
		description = "\n"+
		"Who knows what's going on here?\n"+
		"Private bot for guild-y thing.\n"+ 
		"This project uses [DDBL](https://github.com/FelixVogel/DDBL) and [JDA](https://github.com/DV8FromTheWorld/JDA)\n"+ 
		"####Features\n"+ 
		"Yeah this is a major **WIP**";
		version = "00a59";
		since = "10/02/2017";
	}
	
	public static void main(String[] args) {
		new Main();
	}

	@Override
	public void onStart() {
		registerCommand(AdminTestCommand.class);
		registerCommand(BanCommand.class);
		registerCommand(GetIDCommand.class);
		registerCommand(GuildInfoCommand.class);
		registerCommand(RoleInfoCommand.class);
		registerCommand(UserInfoCommand.class);
		registerCommand(BanHammerCommand.class);
		registerCommand(CryCommand.class);
		registerCommand(FishCommand.class);
		registerCommand(GiggleCommand.class);
		registerCommand(HelpCommand.class);
		registerCommand(WelcomeCommand.class);
		registerCommand(JoinVoiceCommand.class);
		registerCommand(LeaveVoiceCommand.class);
		registerCommand(PlayCommand.class);
		registerCommand(QueueCommand.class);
		registerCommand(PauseCommand.class);
		registerCommand(NowPlayingCommand.class);
		registerCommand(SkipCommand.class);
		registerCommand(RepeatCommand.class);
	}
}
