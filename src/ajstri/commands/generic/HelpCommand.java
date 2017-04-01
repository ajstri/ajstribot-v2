package ajstri.commands.generic;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

import ajstri.Category;
import quack.ddbl.core.DDBLCore;
import quack.ddbl.core.commands.ICommand;
import quack.ddbl.core.event.ExtendedMessageReceivedEvent;
import quack.ddbl.core.managers.CommandRegistry.CommandEntry;
import quack.ddbl.core.utils.Embed;

public class HelpCommand extends ICommand {

	public HelpCommand() {
		super("help", "sendhelp");
		setCategory(Category.GENERIC);
		setDescription("Help Command");
		setPermissions("ajstri.generic.help");
	}
	
	@Override
	public void execute(ExtendedMessageReceivedEvent e) {
		if(e.args.length==1) {
			StringBuilder sb = new StringBuilder();
			ArrayList<String> cats = new ArrayList<String>(DDBLCore.getCommandRegistry().getCategoryMap().keySet());
			Collections.sort(cats);
			for(int i = 0; i<cats.size(); i++) {
				sb.append("*"+cats.get(i)+"*\n");
			}
			e.embed().color(Color.RED).field("Help: Categorys", sb.toString(), true).send();
		}
		if(e.args.length==2) {
			if(DDBLCore.getCommandRegistry().getCategoryMap().containsKey(e.args[1])) {
				Embed embed = e.embed();
				embed.color(Color.RED).field("Help: "+e.args[1], "", true);
				for(CommandEntry entry : DDBLCore.getCommandRegistry().getCategoryMap().get(e.args[1])) {
					embed.field(entry.commandMeta.aliases[0], entry.commandMeta.description, false);
				}
				embed.send();
				return;
			} else {
				e.sendMessage("Could not find requested category");
				return;
			}
		}
	}
	
}
