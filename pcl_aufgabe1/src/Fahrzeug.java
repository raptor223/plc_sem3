/**
 * @author <your-name-here>
 * Matrikelnummer:
 */

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public abstract class Fahrzeug implements Serializable {
	
    private static final long serialVersionUID = 1L;

    private String marke;
    private String modell;
    private int baujahr;
    private double grundpreis;
    private int id;

    private int currentYear;
    
    
    
    /**
     * Exceptions:
     * "Error: Parameter ungueltig."
     * "Error: Baujahr ungueltig."
     * "Error: Grundpreis ungueltig."
     * "Error: Servicejahr ungueltig."
     * "Error: Fahrzeug bereits vorhanden. (id=<id>)"
     * "Error: Fahrzeug nicht vorhanden. (id=<id>)"
     * 
     * 
     * @param id
     * @param marke
     * @param modell
     * @param baujahr
     * @param grundpreis 
     */
    public Fahrzeug(int id, String marke, String modell, int baujahr, double grundpreis){
    
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        currentYear = calendar.get(Calendar.YEAR);
        
        try{
        
            if(marke.equals("") || modell.equals("") || id <= 0)
                throw new IllegalArgumentException("Parameter ungueltig.");
            
            if(baujahr > currentYear || baujahr <= 0)
                throw new IllegalArgumentException("Baujahr ungueltig.");
            
            if(grundpreis <= 0.0)
                throw new IllegalArgumentException("Grundpreis ungueltig.");
            else{
                this.baujahr = baujahr;
                this.marke = marke;
                this.modell = modell; 
                this.grundpreis = grundpreis;
                this.id = id;
            }   
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public int getCurrentYear() {
        return currentYear;
    }
    
    /**
     * Liefert den Rabatt eines Fahrzeuges zurueck.
     * @return double
     */
    public abstract double getRabatt();
    
    /**
     * Liefert das Alter eines Fahrzeuges zurueck.
     * @return int
     */
    public int getAlter(){
        return this.currentYear-this.baujahr;
    }
    
    /**
     * Liefert den Preis unter beruecksichtigung des @getRabatt() eines Fahrezeuges.
     * @return double
     */
    public double getPreis(){
        return this.grundpreis - getRabatt();
    }
    
    public static DecimalFormat getDecimalFormat() {
            DecimalFormatSymbols dfs = DecimalFormatSymbols.getInstance();
            dfs.setDecimalSeparator('.');
            return new DecimalFormat("0.00", dfs);
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public int getBaujahr() {
        return baujahr;
    }

    public void setBaujahr(int baujahr) {
        this.baujahr = baujahr;
    }

    public double getGrundpreis() {
        return grundpreis;
    }

    public void setGrundpreis(double grundpreis) {
        this.grundpreis = grundpreis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString(){
        DecimalFormat df = Fahrzeug.getDecimalFormat();
        return "Preis:" + df.format(this.getGrundpreis());
    }
        
}
