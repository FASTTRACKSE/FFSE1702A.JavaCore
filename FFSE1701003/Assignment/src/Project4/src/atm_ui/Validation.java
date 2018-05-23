package atm_ui;

import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

public class Validation {
	public static boolean checkDuration(JDateChooser dateFrom, JDateChooser dateTo) {
		Calendar cldFrom = dateFrom.getCalendar();
		Calendar cldTo = dateTo.getCalendar();

		if (cldFrom == null || cldTo == null) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn ngày.", "Lỗi", JOptionPane.WARNING_MESSAGE);
			return false;
		} else {
			/* Xử lý nếu chọn ngày vượt quá thời điểm hiện tại */
			Calendar current = Calendar.getInstance();
			Date date = new Date();
			current.setTime(date);
			if (cldFrom.after(current)) {
				cldFrom.setTime(date);
				dateFrom.setDate(date);
			}
			if (cldTo.after(current)) {
				cldTo.setTime(date);
				dateTo.setDate(date);
			}

			cldTo.add(Calendar.DATE, 1);
			Calendar durationMax = dateFrom.getCalendar();
			durationMax.add(Calendar.DATE, 90);
			Calendar durationMin = dateFrom.getCalendar();
			durationMin.add(Calendar.HOUR, 1);

			if (cldTo.after(durationMin) && durationMax.after(cldTo)) {
				return true;
			} else {
				JOptionPane.showMessageDialog(null, "Khoảng thời gian phải hợp lệ và không quá 90 ngày.", "Lỗi",
						JOptionPane.WARNING_MESSAGE);
				return false;
			}
		}
	}
}
