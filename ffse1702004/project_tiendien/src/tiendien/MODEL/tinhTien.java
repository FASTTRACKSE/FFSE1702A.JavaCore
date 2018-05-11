package tiendien.MODEL;

import tiendien.UI.quanlybienlaiUI;

public class tinhTien {
	private int chisocu;
	private static int chisomoi;
	public static int sotienphaitra;

	public tinhTien() {
	}

	public tinhTien(int chisocu, int chisomoi, int sotienphaitra) {
		super();
		this.chisocu = chisocu;
		this.chisomoi = chisomoi;
		this.sotienphaitra = sotienphaitra;
	}

	public float getChisocu() {
		return chisocu;
	}

	public void setChisocu(int chisocu) {
		this.chisocu = chisocu;
	}

	public float getChisomoi() {
		return chisomoi;
	}

	public void setChisomoi(int chisomoi) {
		this.chisomoi = chisomoi;
	}

	public float getSotienphaitra() {
		return sotienphaitra;
	}

	public void setSotienphaitra(int sotienphaitra) {
		this.sotienphaitra = sotienphaitra;
	}

	public void tinhtien() {
		String csMoi = quanlybienlaiUI.text_chiso.getText();
		String csCu = ExceptionMD.chisocu;

		chisocu = Integer.parseInt(csCu);
		chisomoi = Integer.parseInt(csMoi);
		int tongso = chisomoi - chisocu ;
		if (chisomoi == 0 || tongso == 0) {
			sotienphaitra = 0;
		}
		
		if (tongso > 0 && tongso <= 50) {	
			sotienphaitra = tongso * 1549;
		}	
		if (tongso > 50 && tongso <= 100) {
			int key_1 = tongso - 50 ;
			int sotien_1 = 50 * 1549 ;
			int sotien_2 = key_1 * 1600;
			sotienphaitra = sotien_1 + sotien_2;
		}
		if (tongso > 100 && tongso <= 200) {
			
			int key_1 = tongso - 50 ;			
			int sotien_1 = 50 * 1549 ;
			
			int key_2 = key_1 - 50;
			int sotien_2 = 50 * 1600 ;
				
			int sotien_3 = key_2 * 1858 ;
					
			sotienphaitra = sotien_1 + sotien_2 + sotien_3 ;
		}
		if (tongso > 200 && tongso <= 300) {
			
			int key_1 = tongso - 50 ;			
			int sotien_1 = 50 * 1549 ;

			int key_2 = key_1 - 50;
			int sotien_2 = 50 * 1600 ;
			
			int key_3 = key_2 -100;
			int sotien_3 = 100 * 1858 ;
			
			int sotien_4 = key_3 * 2340 ;
			
			sotienphaitra = sotien_1 + sotien_2 + sotien_3 + sotien_4 ;
		}
		if (tongso > 300 && tongso <= 400) {
			
			int key_1 = tongso - 50 ;			
			int sotien_1 = 50 * 1549 ;
			
			int key_2 = key_1 - 50;
			int sotien_2 = 50 * 1600 ;
			
			int key_3 = key_2 -100;
			int sotien_3 = 100 * 1858 ;
			
			int key_4 = key_3 - 100;
			int sotien_4 = 100 * 2340 ;
			
			int sotien_5 = key_4 * 2615 ;
			
			sotienphaitra = sotien_1 +sotien_2+sotien_3+sotien_4+sotien_5;
		}
		if (tongso > 400) {
			
			int key_1 = tongso - 50 ;			
			int sotien_1 = 50 * 1549 ;
			
			int key_2 = key_1 - 50;
			int sotien_2 = 50 * 1600 ;
			
			int key_3 = key_2 -100;
			int sotien_3 = 100 * 1858 ;
			
			int key_4 = key_3 - 100;
			int sotien_4 = 100 * 2340 ;
			
			int key_5 = key_4 - 100;
			int sotien_5 = 100 * 2340 ;
			
			int sotien_6 = key_5 * 2701 ;
			
			sotienphaitra = sotien_1 + sotien_2 + sotien_3 + sotien_4 + sotien_5 + sotien_6;
		}

	}

}
