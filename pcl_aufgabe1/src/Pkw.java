/**
 * @author <your-name-here>
 * Matrikelnummer:
 */

public class Pkw extends Fahrzeug {
	
    private static final long serialVersionUID = 1L;

    private int serviceJahr;
    
    public Pkw(int id, String marke, String modell, int baujahr, double grundpreis) {
        super(id, marke, modell, baujahr, grundpreis);
    }

    @Override
    public double getRabatt() {
        
        double rabattAlter = 0;
        double rabattService = 0;
        for(int i=0;i<this.getAlter();i++){
            rabattAlter += this.getGrundpreis()*0.05;
        }
        
        for(int j=0;j<(this.getCurrentYear()-this.getServiceJahr());j++){
            rabattService += this.getGrundpreis()*0.02;
        }
        
        if((rabattAlter+rabattService) > this.getGrundpreis()*0.15){
            return this.getGrundpreis()*0.15;
        }else if(rabattAlter+rabattService < 0.00){
            return 0.00;
        }else{
            return rabattAlter+rabattService;
        }
    }

    public int getServiceJahr() {
        return serviceJahr;
    }

    public void setServiceJahr(int serviceJahr) {
        this.serviceJahr = serviceJahr;
    }

    
	
	
}
