package ui;

import java.util.Calendar;

import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

public class Validation {
	public static boolean checkDuration(JDateChooser dateFrom, JDateChooser dateTo) {
		Calendar cldFrom = dateFrom.getCalendar();
		Calendar cldTo = dateTo.getCalendar();
		
		if (cldFrom == null || cldTo == null) {
			JOptionPane.showMessageDialog(null,"Bạn chưa chọn ngày.",
					"Lỗi",JOptionPane.WARNING_MESSAGE);
			return false;
		} else {
			cldTo.add(Calendar.DATE, 1);
			/*FIX lỗi chọn ngày kết thúc trước, ngày bắt đầu sau*/
			cldTo.add(Calendar.MINUTE, 10);
		
			Calendar durationMax = dateFrom.getCalendar();
			durationMax.add(Calendar.DATE, 90);
			Calendar durationMin = dateFrom.getCalendar();
			durationMin.add(Calendar.MONTH, 1);
		
			if ( cldTo.after(durationMin)  && durationMax.after(cldTo) ) {
				return true;
			} else {
				JOptionPane.showMessageDialog(null,"Khoảng thời gian phải là 1 tháng/năm và không quá 90 ngày.",
						"Lỗi",JOptionPane.WARNING_MESSAGE);
				return false;
			}
		}
	}
}
