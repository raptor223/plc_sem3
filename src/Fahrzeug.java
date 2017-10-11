/**
 * @author <your-name-here>
 * Matrikelnummer:
 */

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;


public abstract class Fahrzeug implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public static DecimalFormat getDecimalFormat() {
		DecimalFormatSymbols dfs = DecimalFormatSymbols.getInstance();
		dfs.setDecimalSeparator('.');
		return new DecimalFormat("0.00", dfs);
	}		
}
