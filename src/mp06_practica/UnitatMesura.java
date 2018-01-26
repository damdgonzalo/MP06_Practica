package mp06_practica;

public class UnitatMesura {
     private String id_unitat;
     private String descripcio;
     
     public UnitatMesura(String id_unitat, String descripcio) {
          this.id_unitat = id_unitat;
          this.descripcio = descripcio;
     }
     
     public String get_id_unitat() {return id_unitat;}
     public String get_descripcio() {return descripcio;}
     
     public void set_id_unitat(String id_unitat) {this.id_unitat = id_unitat;}
     public void set_descripcio(String descripcio) {this.descripcio = descripcio;}
}
