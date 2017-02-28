package ajstri.commands.music;

import quack.ddbl.core.commands.ICommand;

public abstract class MusicCommand extends ICommand {

	public MusicCommand(String name) {
		super("ddbl.music." + name, true, name);
	}

	public MusicCommand(String... names) {
		super("ddbl.music." + names[0], true, names);
	}
}