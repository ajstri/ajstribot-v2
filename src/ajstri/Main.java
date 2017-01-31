package ajstri;

import java.io.File;
import java.util.HashMap;

import ajstri.commands.CommandExecutor;
import ajstri.commands.admin.GetIDCommand;
import ajstri.commands.admin.GuildInfoCommand;
import ajstri.commands.admin.UserInfoCommand;
import ajstri.commands.Command;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.Icon;

public class Main {
	
	public static JDA api;
	public static String id;
	public static HashMap<String, Command> cmds = new HashMap<String, Command>();
	
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
		cmds.put("getid", new GetIDCommand());
		cmds.put("guildinfo", new GuildInfoCommand());
		cmds.put("userinfo", new UserInfoCommand());
	}
	
}
