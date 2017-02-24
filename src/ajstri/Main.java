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
import net.dv8tion.jda.core.managers.AudioManager;

public class Main {
	public static JDA api;
	public static String id;
	public static HashMap<String, Command> cmds = new HashMap<String, Command>();
	public static AudioManager ami;
	
	public static void main(String[] args) {
		try {
			api = new JDABuilder(AccountType.BOT).setToken(Data.TOKEN).buildBlocking();
		} 
		catch(Exception e) {
			System.out.println("JDA Builder threw an exception!");
		}
		try {
			api.getPresence().setGame(Game.of("/welcome to begin!"));
		}
		catch(Exception e) {
			System.out.println("getPresence threw an exception!");
		}
		try {
			api.addEventListener(new CommandExecutor());
		}
		catch(Exception e) {
			System.out.println("addEventListener threw an exception!");
		}
		try {
			api.setAutoReconnect(true);
		}
		catch(Exception e) {
			System.out.println("setAutoReconnect threw an exception!");
		}
		try {
			id = api.getSelfUser().getId();
		}
		catch(Exception e) {
			System.out.println("getSelfUser threw an exception!");
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
