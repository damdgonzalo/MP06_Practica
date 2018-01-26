package mp06_practica;

import java.io.Serializable;


public class Producte implements Serializable{
     int id_producte;
     String nom;
     String origen;
     
     public Producte(int id_producte, String nom, String origen) {
          this.id_producte = id_producte;
          this.nom = nom;
          this.origen = origen;
     }
     
     public Producte() {}

     public int getId_producte() {
          return id_producte;
     }

     public void setId_producte(int id_producte) {
          this.id_producte = id_producte;
     }

     public String getNom() {
          return nom;
     }

     public void setNom(String nom) {
          this.nom = nom;
     }

     public String getOrigen() {
          return origen;
     }

     public void setOrigen(String origen) {
          this.origen = origen;
     }
     
     
     
}
