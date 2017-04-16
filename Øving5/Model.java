import java.text.DecimalFormat;

class Model {

	private double NokValuta;
	private double SekValuta;

	public Model(double NokValuta, double SekValuta){
		this.NokValuta = NokValuta;
		this.SekValuta = SekValuta;
	}

	public String tilSek(String nok){
		if(nok == null || nok.equals("")){
			throw new IllegalArgumentException("");
		}
		return new DecimalFormat("#.##").format(Double.parseDouble(nok.trim())* SekValuta);
	}

	public String tilNok(String sek){
		if(sek == null || sek.equals("")){
			throw new IllegalArgumentException("");
		}
		return new DecimalFormat("#.##").format(Double.parseDouble(sek.trim())* NokValuta);
	}
}