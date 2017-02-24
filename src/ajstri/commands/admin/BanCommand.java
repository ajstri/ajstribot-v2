package ajstri.commands.admin;

import ajstri.Category;
import ajstri.Permission;
import ajstri.UserUtils;
import ajstri.commands.Command;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.PermissionException;

public class BanCommand implements Command {

	@Override
	public void execute(GuildMessageReceivedEvent e, String[] args) {
		Guild g = e.getGuild();
		for(Member m : g.getMembers()) {
			if(m.getEffectiveName().equals(args[1])) {
                Member selfMember = g.getSelfMember();

                if (!selfMember.canInteract(m))
                {
                    e.getChannel().sendMessage("Cannot kicked member: " + m.getEffectiveName() +", they are higher " +
                            "in the hierachy than I am!").queue();
                    System.out.println(e.getAuthor() + "Attempted to Execute in Guild: BAN");
                    continue;
                }
                g.getController().kick(m).queue(
                    success -> 
                    e.getChannel().sendMessage("Kicked " + m.getEffectiveName() + "! Cya!").queue(),
                    error ->
                    {
                        if (error instanceof PermissionException)
                        {
                            
                            e.getChannel().sendMessage("PermissionError kicking [" + m.getEffectiveName()
                                    + "]").queue();
                            System.out.println(e.getAuthor() + "Attempted to Execute in Guild: BAN");
                        }
                        else
                        {
                            e.getChannel().sendMessage("Unknown error while kicking [" + m.getEffectiveName()
                                    + "]: " + "<" + error.getClass().getSimpleName() + ">: " + error.getMessage()).queue();
                            System.out.println(e.getAuthor() + "Attempted to Execute in Guild: BAN");
                        }
                    });
			}
		}
	}

	@Override
	public void execute(PrivateMessageReceivedEvent e, String[] args) {
		UserUtils.sendPrivateMessage2(e, "B-b-b-b-but...this isn't a *guild*!");
		System.out.println("Attempt to Execute in DM: BAN");
	}

	@Override
	public Permission getValidExecutors() {
		return Permission.Ban;
	}

	@Override
	public String getInfo() {
		return "Ban a Member from the Guild.";
	}

	@Override
	public Category category() {
		return Category.Admin;
	}

}
