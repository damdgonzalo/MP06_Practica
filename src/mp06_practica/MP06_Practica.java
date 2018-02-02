package mp06_practica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MP06_Practica {
     
     static Scanner sc;
     static Connection c;
     
     public static void main(String[] args) throws Exception {
          
          sc = new Scanner(System.in);
          c = connexio();
          
          int opcio_menu = -1;
          
          while (opcio_menu != 11) {
               System.out.print(  "-------------------- MENÚ --------------------\n"
                                + "[1] Afegir article envasat\n"
                                + "[2] Afegir producte a granel\n"
                                + "[3] Modificar producte envasat\n"
                                + "[4] Modificar producte a granel\n"
                                + "[5] Veure producte envasat\n"
                                + "[6] Veure producte a granel\n"
                                + "[7] Veure magatzem productes envasats\n"
                                + "[8] Veure magatzem productes a granel\n"
                                + "[9] Eliminar producte envasat\n"
                                + "[10] Eliminar producte a granel\n"
                                + "[11] Sortir\n\n"
                                + "Tria una opció [1-11]: ");

               opcio_menu = sc.nextInt();

               System.out.println("----------------------------------------------\n");

               //afegir article envasat o a granel
               switch (opcio_menu) {
                    
                    case 1: afegir_producte_envasat(); break;
                    case 2: afegir_producte_granel(); break;
                    case 5: veure_producte_envasat(); break;
                    case 6: veure_producte_granel(); break;
                    case 7: veure_magatzem_envas(); break;
                    case 8: veure_magatzem_granel(); break;
                    
                    default: System.out.println(opcio_menu + " no és una opció vàlida.");
                          
               }

          }
          
          c.close(); //tanquem la connexió
     }
     
//-- fi main() -----------------------------------------------------------------

     public static Connection connexio() {          
          try {
               Class.forName("org.postgresql.Driver");
               c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/MP06Practica","postgres", "root");
               c.setAutoCommit(false);
          } catch (ClassNotFoundException | SQLException ignored) {
               System.err.println("No s'ha pogut establir la connexió");
          }
          
          return c;
     }

     
     public static void afegir_producte_envasat() throws SQLException {
          System.out.println("Introducció de les dades:");

          System.out.print("\t- ID producte: ");
          int id_producte = sc.nextInt();

          System.out.print("\t- ID producte nou: ");
          int id_producte_envasat = sc.nextInt();

          System.out.print("\t- ID envàs: ");
          int id_envas = sc.nextInt();

          System.out.println("\t- Preu:");
          double preu = sc.nextDouble(); 
                    
          Statement stmt = null;
          
          try {
               String sql = "INSERT INTO producte_envasat VALUES (" + id_producte + "," + id_producte_envasat + "," + id_envas + "," + preu + ")";
               
               stmt = c.createStatement();
               stmt.executeUpdate(sql);
               
               stmt.close();
               c.commit();
               System.out.println("Producte afegit correctament.\n");

             
          } catch (SQLException e) {
               c.rollback();
               System.err.println("[ERROR] No s'ha pogut afegir el producte.\n");
          }
     }
     
     public static void afegir_producte_granel() throws SQLException {
          System.out.println("Introducció de les dades:");

          System.out.print("\t- ID producte: ");
          int id_producte = sc.nextInt();

          System.out.print("\t- ID producte nou: ");
          int id_producte_envasat = sc.nextInt();

          System.out.println("\t- Preu:");
          double preu = sc.nextDouble(); 
                    
          Statement stmt = null;
          
          try {
               String sql = "INSERT INTO producte_granel VALUES (" + id_producte + "," + id_producte_envasat + "," + preu + ")";
               
               stmt = c.createStatement();
               stmt.executeUpdate(sql);
               
               stmt.close();
               c.commit();
               System.out.println("Producte afegit correctament.\n");

             
          } catch (SQLException e) {
               c.rollback();
               System.err.println("[ERROR] No s'ha pogut afegir el producte.\n");
          }
     }
     
     public static void veure_producte_envasat() throws SQLException {

          System.out.print("ID producte a veure: ");
          int id_producte_envasat = sc.nextInt();
                    
          Statement stmt = null;
          ResultSet rs = null;
          
          try {
               String sql = "SELECT * FROM producte_envasat WHERE id_producte_envasat=" + id_producte_envasat;
               
               stmt = c.createStatement();
               rs = stmt.executeQuery(sql);
               
               int id_prod = -1;
               int id_envas = -1;
               double preu = -1;
               
               while (rs.next()) {
                    id_prod = rs.getInt("id_producte");
                    id_envas = rs.getInt("id_envas");
                    preu = rs.getDouble("preu");
               }
               
               sql = "SELECT * FROM producte WHERE id_producte=" + id_prod;
               stmt = c.createStatement();
               rs = stmt.executeQuery(sql);
               
               String nom = "";
               String origen = "";
               
               while (rs.next()) {
                    nom = rs.getString("nom");
                    origen = rs.getString("origen");
               }
               
               sql = "SELECT * FROM envas WHERE id_envas=" + id_envas;
               stmt = c.createStatement();
               rs = stmt.executeQuery(sql);
               
               String tipus = "";
               String id_unitat = "";
               double capacitat = -1;
               
               while (rs.next()) {
                    tipus = rs.getString("tipus");
                    id_unitat = rs.getString("id_unitat");
                    capacitat = rs.getDouble("capacitat");
               }
               
               if (preu==-1) System.err.println("[ERROR] Aquest producte no existeix.\n");
               else {
                    System.out.println("\nProducte: " + nom + " " + origen);
                    System.out.println("Preu: " + preu);
                    System.out.println("Envàs: " + tipus + ", " + capacitat + id_unitat + "\n");
               }
               
               
               
               rs.close();
               stmt.close();
               c.commit();

             
          } catch (SQLException e) {
               c.rollback();
               System.err.println("[ERROR] No s'ha pogut afegir el producte.\n");
          }
     }
     
     public static void veure_producte_granel() throws SQLException {

          System.out.print("ID producte a veure: ");
          int id_producte_granel = sc.nextInt();
                    
          Statement stmt = null;
          ResultSet rs = null;
          
          try {
               String sql = "SELECT * FROM producte_granel WHERE id_producte_granel=" + id_producte_granel;
               
               stmt = c.createStatement();
               rs = stmt.executeQuery(sql);
               
               int id_prod = -1;
               double preu = -1;
               
               while (rs.next()) {
                    id_prod = rs.getInt("id_producte");
                    preu = rs.getDouble("preu");
               }
               
               sql = "SELECT * FROM producte WHERE id_producte=" + id_prod;
               stmt = c.createStatement();
               rs = stmt.executeQuery(sql);
               
               String nom = "";
               String origen = "";
               
               while (rs.next()) {
                    nom = rs.getString("nom");
                    origen = rs.getString("origen");
               }     
               
               if (preu==-1) System.err.println("[ERROR] Aquest producte no existeix.\n");
               else {
                    System.out.println("\nProducte: " + nom + " " + origen);
                    System.out.println("Preu: " + preu);
               }
               
               
               
               rs.close();
               stmt.close();
               c.commit();

             
          } catch (SQLException e) {
               c.rollback();
               System.err.println("[ERROR] No es pot veure aquest producte.\n");
          }
     }
     
     public static void veure_magatzem_envas() throws SQLException {
     
          Statement stmt_magatzem = null;
          ResultSet rs_magatzem = null;
          
          try {
               String sql_magatzem = "SELECT * FROM magatzem_envas";
               
               stmt_magatzem = c.createStatement();
               rs_magatzem = stmt_magatzem.executeQuery(sql_magatzem);
               
               int id = -1;
               
               while (rs_magatzem.next()) {
                    id = rs_magatzem.getInt("id_producte"); 
                    
                    String sql_prod = "SELECT * FROM producte_envasat WHERE id_producte_envasat=" + id;
               
                    Statement stmt_prod = c.createStatement();
                    ResultSet rs_prod = stmt_prod.executeQuery(sql_prod);
               
                    int id_prod = -1;
                    double preu = -1;
               
                    while (rs_prod.next()) {
                         id_prod = rs_prod.getInt("id_producte");
                         preu = rs_prod.getDouble("preu");
                         
                         String sql = "SELECT * FROM producte WHERE id_producte=" + id_prod;
                         Statement stmt = c.createStatement();
                         ResultSet rs = stmt.executeQuery(sql);
               
                         String nom = "";
                         String origen = "";
               
                         while (rs.next()) {
                              nom = rs.getString("nom");
                              origen = rs.getString("origen");
                         }   
                         
                         rs.close();
                         stmt.close();
                         System.out.println("Producte: " + nom + " " + origen);
                    }
                    
                    rs_prod.close();
                    stmt_prod.close();

               }
               

               System.out.println();
               rs_magatzem.close();
               stmt_magatzem.close();
               c.commit();

             
          } catch (SQLException e) {
               c.rollback();
               System.err.println("[ERROR] No es pot veure aquest producte.\n");
          }
          
     }
     
     public static void veure_magatzem_granel() throws Exception{
     
          Statement stmt_magatzem = null;
          ResultSet rs_magatzem = null;
          
          try {
               String sql_magatzem = "SELECT * FROM magatzem_granel";
               
               stmt_magatzem = c.createStatement();
               rs_magatzem = stmt_magatzem.executeQuery(sql_magatzem);
               
               int id = -1;
               
               while (rs_magatzem.next()) {
                    id = rs_magatzem.getInt("id_producte"); 
                    
                    String sql_prod = "SELECT * FROM producte_granel WHERE id_producte_granel=" + id;
               
                    Statement stmt_prod = c.createStatement();
                    ResultSet rs_prod = stmt_prod.executeQuery(sql_prod);
               
                    int id_prod = -1;
                    double preu = -1;
               
                    while (rs_prod.next()) {
                         id_prod = rs_prod.getInt("id_producte");
                         preu = rs_prod.getDouble("preu");
                         
                         String sql = "SELECT * FROM producte WHERE id_producte=" + id_prod;
                         Statement stmt = c.createStatement();
                         ResultSet rs = stmt.executeQuery(sql);
               
                         String nom = "";
                         String origen = "";
               
                         while (rs.next()) {
                              nom = rs.getString("nom");
                              origen = rs.getString("origen");
                         }   
                         
                         rs.close();
                         stmt.close();
                         System.out.println("Producte: " + nom + " " + origen);
                    }
                    
                    rs_prod.close();
                    stmt_prod.close();

               }
               

               System.out.println();
               rs_magatzem.close();
               stmt_magatzem.close();
               c.commit();

             
          } catch (SQLException e) {
               c.rollback();
               System.err.println("[ERROR] No es pot veure aquest producte.\n");
          }
          
     }
     
     public static void stock_envas() throws Exception {
          Statement stmt_magatzem = null;
          ResultSet rs_magatzem = null;
          
          String sql_magatzem = "SELECT * FROM magatzem_envas";

          stmt_magatzem = c.createStatement();
          rs_magatzem = stmt_magatzem.executeQuery(sql_magatzem);

          int id = -1;
          double stock_total = 0;

          while (rs_magatzem.next()) {
               id = rs_magatzem.getInt("id_producte"); 

               String sql_prod = "SELECT * FROM producte_envasat WHERE id_producte_envasat=" + id;

               Statement stmt_prod = c.createStatement();
               ResultSet rs_prod = stmt_prod.executeQuery(sql_prod);
          }
     }
}