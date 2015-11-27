package edt.textui.visitors;

import edt.core.visitor.Visitor;

import edt.core.Paragraph;
import edt.core.Section;
import edt.core.Document;

import edt.textui.section.Message;

import pt.utl.ist.po.ui.Display;

import java.util.List;

/**
 * GetContentVisitor implements the Visitor interface.
 * <p>GetContentVisitor performs the getContent operation on sections and paragraphs.
 *
 * @author Daniel Reigada
 * @author Diogo Mesquita
 * @author Sebastião Araújo
 * @version 1.0
*/
public class GetContentVisitor implements Visitor {

	/**
	 * The Visitor's visit method implementation for Section Element.
	 *
	 * @param sec the element to visit
	 */
	@Override
	public void visit(Section sec) {

		Display display = new Display();

		display.add(getSections(sec, false))
			   .display();
	}

	/**
	 * The Visitor's visit method implementation for Document Element.
	 *
	 * @param doc the element to visit
	 */
	@Override
	public void visit(Document doc) {

		Display display = new Display();

		display.add(getSections(doc, true))
				 .display();
	}

	/**
	 * The Visitor's visit method implementation for Paragraph Element.
	 *
	 * @param  par the element to visit
	 */
	@Override
	public void visit(Paragraph par) {

		Display display = new Display();

		display.addNewLine(par.getContent()).display();
	}


	/**
     * Returns all of the content of a Section
     *
     * @param section the section to get all content from
     * @param isDocument the mode of this method
     * @return String all of the content from every subsection of the current one
     */
    private String getSections(Section section, boolean isDocument){

			String content;

			if(isDocument)
				content = "{" + section.getTitle() + "}\n";
			else
        content = Message.sectionIndexEntry(section.getKey(),
                                                   section.getTitle()) +
                                                   "\n";

        List<Paragraph> paragraphs = section.getParagraphs();
        List<Section> subSections = section.getSubsections();

        for (Paragraph p: paragraphs) content += p.getContent() + "\n";

        for (Section s: subSections) content += this.getSections(s, false);

        return content;
    }
}
