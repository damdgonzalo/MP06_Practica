package mp06_practica;

public class ProducteAGranel extends Producte {
     
     private int id_producte_granel;
     private double preu;
     
     public ProducteAGranel(int id_producte, String nom, String origen, int id_producte_granel, double preu) {
          this.id_producte = id_producte;
          this.nom = nom;
          this.origen = origen;
          this.id_producte_granel = id_producte_granel;
          this.preu = preu;
     }
     
     
     public int getId_producte_granel() {
          return id_producte_granel;
     }

     public void setId_producte_granel(int id_producte_granel) {
          this.id_producte_granel = id_producte_granel;
     }

     public double getPreu() {
          return preu;
     }

     public void setPreu(double preu) {
          this.preu = preu;
     }
     
     
}
