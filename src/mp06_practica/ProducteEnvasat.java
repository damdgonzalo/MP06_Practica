/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp06_practica;

/**
 *
 * @author xaviercastillo
 */
public class ProducteEnvasat extends Producte {
    
    private Envas tipusEnvas; 
    private double preu;
    
    public ProducteEnvasat(int id_producte, String nom, String origen, double preu, Envas tipusEnvas) {
          this.id_producte = id_producte;
          this.nom = nom;
          this.origen = origen;
          this.tipusEnvas = tipusEnvas;
          this.preu = preu;
     }

    public ProducteEnvasat(Envas tipusEnvas, double preu) {
        this.tipusEnvas = tipusEnvas;
        this.preu = preu;
    }
    
    public Envas getTipusEnvas() {
        return tipusEnvas;
    }

    public void setTipusEnvas(Envas tipusEnvas) {
        this.tipusEnvas = tipusEnvas;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }
    
    
    
}


