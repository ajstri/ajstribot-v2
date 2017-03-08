package ajstri.commands;

import ajstri.Category;

public interface ICommand extends quack.ddbl.core.commands.ICommand {
	public default Category setCategory() {
		return Category.Generic;
	}
}
