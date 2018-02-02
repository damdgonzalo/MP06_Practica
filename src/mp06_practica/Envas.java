/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp06_practica;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author xaviercastillo
 */

@Entity
@Table(name="Envas")
public class Envas implements Serializable {
     
    private int id_envas;
    
    private String id_unitat;
    private String tipus;
    private double capacitat;
    
    public Envas() {
    
    }

    public Envas(int id_envas, String id_unitat, String tipus, double capacitat) {
        this.id_envas = id_envas;
        this.id_unitat = id_unitat;
        this.tipus = tipus;
        this.capacitat = capacitat;
    }
    
    
    @Id
    @Column(name="id_envas")
    public int getId_envas() {
        return id_envas;
    }

    public void setId_envas(int id_envas) {
        this.id_envas = id_envas;
    }

    public String getId_unitat() {
        return id_unitat;
    }

    public void setId_unitat(String id_unitat) {
        this.id_unitat = id_unitat;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public double getCapacitat() {
        return capacitat;
    }

    public void setCapacitat(double capacitat) {
        this.capacitat = capacitat;
    }
    
    
    
    
    
}
