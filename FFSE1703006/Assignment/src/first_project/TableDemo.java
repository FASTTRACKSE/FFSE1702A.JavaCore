package first_project;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.TableColumn;

public class TableDemo extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private boolean DEBUG = true;

	@SuppressWarnings("serial")
	public TableDemo() {
		super("TableDemo");

		Object[][] data = { { "Ella Fitzgerald", "How High the Moon", "Verve Jazz Masters", "5" },
				{ "Louis Jordan", "Buzz Me", "Let the Good Times Rool, CD 4", "1" },
				{ "Stuff Smith & his Onyx Club Boys", "You'se a Viper", "Viper Mad Blues", "8" },
				{ "Jelly Roll Morton", "Mama's Got a Baby", "Last Sessions", "24" } };

		String[] columnNames = { "Artist", "Song", "Album", "Track" };

		final JTable table = new JTable(data, columnNames);
		final JPopupMenu menu = new JPopupMenu();
		final JToolBar toolBar = new JToolBar();
		final XTableColumnModel columnModel = new XTableColumnModel();

		table.setColumnModel(columnModel);
		table.createDefaultColumnsFromModel();

		toolBar.add(new JButton(new javax.swing.AbstractAction("ALL") {
			@Override
			public void actionPerformed(ActionEvent e) {
				columnModel.setAllColumnsVisible();
			}
		}));

		toolBar.add(new JButton(new javax.swing.AbstractAction("Artist") {
			public void actionPerformed(ActionEvent e) {
				TableColumn column = columnModel.getColumnByModelIndex(0);
				boolean visible = columnModel.isColumnVisible(column);
				columnModel.setColumnVisible(column, !visible);
			}
		}));
		toolBar.add(new JButton(new javax.swing.AbstractAction("Song") {
			public void actionPerformed(ActionEvent e) {
				TableColumn column = columnModel.getColumnByModelIndex(1);
				boolean visible = columnModel.isColumnVisible(column);
				columnModel.setColumnVisible(column, !visible);
			}
		}));
		toolBar.add(new JButton(new javax.swing.AbstractAction("Album") {
			public void actionPerformed(ActionEvent e) {
				TableColumn column = columnModel.getColumnByModelIndex(2);
				boolean visible = columnModel.isColumnVisible(column);
				columnModel.setColumnVisible(column, !visible);
			}
		}));
		toolBar.add(new JButton(new javax.swing.AbstractAction("Track") {
			public void actionPerformed(ActionEvent e) {
				TableColumn column = columnModel.getColumnByModelIndex(3);
				boolean visible = columnModel.isColumnVisible(column);
				columnModel.setColumnVisible(column, !visible);
			}
		}));

		table.setPreferredScrollableViewportSize(new Dimension(500, 70));

		table.getTableHeader().addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				maybeShowPopup(e);
			}

			public void mouseReleased(MouseEvent e) {
				maybeShowPopup(e);
			}

			private void maybeShowPopup(MouseEvent e) {
				if (e.isPopupTrigger()) {
					menu.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane(table);

		getContentPane().add(toolBar, BorderLayout.NORTH);
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		TableDemo frame = new TableDemo();
		frame.pack();
		frame.setVisible(true);
	}
}