package ajstri;

import ajstri.commands.admin.AdminTestCommand;
import ajstri.commands.admin.BanCommand;
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
import ajstri.commands.music.NowPlayingCommand;
import ajstri.commands.music.PauseCommand;
import ajstri.commands.music.PlayCommand;
import ajstri.commands.music.QueueCommand;
import ajstri.commands.music.RepeatCommand;
import ajstri.commands.music.SkipCommand;
import net.dv8tion.jda.core.entities.Game;
import quack.ddbl.core.DDBLCore;

public class Main extends DDBLCore {
	
	public Main() {
		super(Data.TOKEN);
		startWithShards(4);
		authors = new String[]{"AJStri", "Felix Vogel"};
		description = "\n"+
		"Who knows what's going on here?\n"+
		"Private bot for guild-y thing.\n"+ 
		"This project uses [DDBL](https://github.com/FelixVogel/DDBL) and [JDA](https://github.com/DV8FromTheWorld/JDA)\n"+ 
		"**Features**\n"+ 
		"Yeah this is a major **WIP**";
		version = "00a59";
		since = "10/02/2017";
	}
	
	public static void main(String[] args) {
		new Main();
	}

	@Override
	public void preInit() {
		setDefaultPrefix("/");
		setGame(Game.of("<p>welcome to begin!"));
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
