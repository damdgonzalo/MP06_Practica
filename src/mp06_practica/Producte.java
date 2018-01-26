/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp06_practica;

/**
 *
 * @author Dana
 */
public class Producte {
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
