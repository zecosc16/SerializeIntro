/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializeintro;

import java.io.File;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oskar
 */
public class LoadTester {
     
        
       public static void main(String[] args) {
       
           try {
               SchuelerBL bl = new SchuelerBL();
               bl.load(new File("./klasse.csv"));
               System.out.println(bl.getSize());
               
           } catch (Exception ex) {
               Logger.getLogger(LoadTester.class.getName()).log(Level.SEVERE, null, ex);
           }
        
        
    }
}
