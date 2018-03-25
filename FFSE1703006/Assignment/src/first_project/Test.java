package first_project;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Test extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Test() {
		super("Table example, Wines from Bordeaux");

		Object[][] tabledata = { { "Chateau Meyney, St. Estephe", "$18.75", "$18.75" },
				{ "Chateau Montrose, St. Estephe", "$18.75", "$54.25" },
				{ "Chateau Gloria, St. Julien", "$18.75", "$22.99" },
				{ "Chateau Beychevelle, St. Julien", "$18.75", "$61.63" },
				{ "Chateau La Tour de Mons, Margeaux", "$18.75", "$57.03" },
				{ "Chateau Brane-Cantenac, Margeaux", "$18.75", "$49.92" }, };

		String columnheaders[] = { "Wine", "Vintage", "Price" };

		JTable table = new JTable(tabledata, columnheaders);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		JScrollPane scrollPane = new JScrollPane(table);

		table.setIntercellSpacing(new Dimension(10, 20));

		getContentPane().add(scrollPane);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		pack();
	}

	public static void main(String[] args) {
		Test main = new Test();
		main.show();
	}
}