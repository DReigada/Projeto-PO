package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;

/* FIXME: import core classes here */

/**
 * Command for showing the content of current section.
 */
public class ShowSection extends Command<Section> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public ShowSection(Section ent) {
        super(MenuEntry.SHOW_CONTENT, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        /* FIXME: implement command */
     }
}
