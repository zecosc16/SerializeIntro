/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializeintro;

import java.io.File;
import java.time.LocalDate;

/**
 *
 * @author oskar
 */
public class SaveTester {
    public static void main(String[] args) {
        Schueler s = new Schueler("Hans",LocalDate.of(2000, 3, 1));
        Schueler s2 = new Schueler("Franz",LocalDate.of(2001, 10, 22));
        
        SchuelerBL bl = new SchuelerBL();
        bl.add(s);
        bl.add(s2);
        
        try{
            bl.save(new File("./klasse.csv"));
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
           
}
