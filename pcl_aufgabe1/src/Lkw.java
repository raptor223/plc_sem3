
import java.text.DecimalFormat;

/**
 * @author <your-name-here>
 * Matrikelnummer:
 */

public class Lkw extends Fahrzeug {

    private static final long serialVersionUID = 1L;

    public Lkw(int id, String marke, String modell, int baujahr, double grundpreis) {
        super(id, marke, modell, baujahr, grundpreis);
    }

    @Override
    public double getRabatt() {
        double rabattAlter = 0;

        for(int i=0;i<this.getAlter();i++){
            rabattAlter += this.getGrundpreis()*0.05;
        }
        
        if((rabattAlter) > this.getGrundpreis()*0.20){
            return this.getGrundpreis()*0.15;
        }else if(rabattAlter < 0.00){
            return 0.00;
        }else{
            return rabattAlter;
        }
    }

    
    

	
}
