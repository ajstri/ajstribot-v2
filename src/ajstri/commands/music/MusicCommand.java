package ajstri.commands.music;

import quack.ddbl.core.commands.ICommand;

public abstract class MusicCommand extends ICommand {

	public MusicCommand(String name) {
		super(EVERYONE, true, name);
	}

	public MusicCommand(String... names) {
		super(EVERYONE, true, names);
	}
}