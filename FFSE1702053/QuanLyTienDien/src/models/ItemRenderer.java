package models;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

public class ItemRenderer extends BasicComboBoxRenderer
{
    public Component getListCellRendererComponent(
        JList list, Object value, int index,
        boolean isSelected, boolean cellHasFocus)
    {
        super.getListCellRendererComponent(list, value, index,
            isSelected, cellHasFocus);

        if (value != null)
        {
        	if(value instanceof District) {
	            District item = (District)value;
	            setText( item.getTenQuan() );
        	} else if(value instanceof Ward) {
        		Ward item = (Ward)value;
 	            setText( item.getTenPhuong());
        	} else if(value instanceof KhachHang) {
        		KhachHang kh = (KhachHang)value;
        		setText(kh.getHoTen());
        	}
        }

        if (index == -1)
        {
        	if(value instanceof District) {
        		District item = (District)value;
                setText(item.getTenQuan());
        	} else if(value instanceof Ward) {
        		Ward item = (Ward)value;
                setText( "" + item.getTenPhuong());
        	} else if(value instanceof KhachHang) {
        		KhachHang kh = (KhachHang)value;
        		setText(kh.getHoTen());
        	}
        }


        return this;
    }
}

