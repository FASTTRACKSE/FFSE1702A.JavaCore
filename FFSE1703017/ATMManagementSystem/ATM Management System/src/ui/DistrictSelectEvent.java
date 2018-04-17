package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import model.AddressDB;
import model.ComboItem;

public class DistrictSelectEvent implements ActionListener {

	JComboBox<ComboItem> cbDistrict, cbWard;
	
	public DistrictSelectEvent(JComboBox<ComboItem> cbDistrict, JComboBox<ComboItem> cbWard) {
		super();
		this.cbDistrict = cbDistrict;
		this.cbWard = cbWard;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int i = cbDistrict.getSelectedIndex();
		if (i > 0) {
			cbWard.removeAllItems();
			ComboItem item = (ComboItem) cbDistrict.getSelectedItem();
			int id = item.getKey();
			AddressDB.setWards(cbWard, id);
		} else {
			cbWard.removeAllItems();
			ComboItem item = new ComboItem(0, "Chọn phường");
			cbWard.addItem(item);
		}
	}

}
