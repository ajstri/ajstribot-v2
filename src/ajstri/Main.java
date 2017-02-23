package ajstri;

import java.io.File;
import java.util.HashMap;

import ajstri.commands.Command;
import ajstri.commands.CommandExecutor;
import ajstri.commands.admin.*;
import ajstri.commands.fun.*;
import ajstri.commands.generic.*;
import ajstri.commands.music.*;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.Icon;
import net.dv8tion.jda.core.managers.AudioManager;

public class Main {
	public static JDA api;
	public static String id;
	public static HashMap<String, Command> cmds = new HashMap<String, Command>();
	public static AudioManager ami;
	
	public static void main(String[] args) {
		try {
			api = new JDABuilder(AccountType.BOT).setToken(Data.TOKEN).buildBlocking();
			File f = new File("FirePicture.png");
			if(f.exists()) api.getSelfUser().getManager().setAvatar(Icon.from(f)).queue(); 
			api.getPresence().setGame(Game.of("Confusion!"));
			api.addEventListener(new CommandExecutor());
			api.setAutoReconnect(true);
			id = api.getSelfUser().getId();
		} 
		catch(Exception e) {
		}
		cmds.put("help", new HelpCommand());
		cmds.put("getid", new GetIDCommand());
		cmds.put("guildinfo", new GuildInfoCommand());
		cmds.put("userinfo", new UserInfoCommand());
		cmds.put("fish", new FishCommand());
		cmds.put("banhammer", new BanHammerCommand());
		cmds.put("join", new JoinVoiceCommand());
		cmds.put("leave", new LeaveVoiceCommand());
		cmds.put("giggle", new GiggleCommand());
		cmds.put("em", new EmbedCommand());
		cmds.put("adtes", new AdminTestCommand());
		cmds.put("ban", new BanCommand());
		cmds.put("welcome", new WelcomeCommand());
	}
}
