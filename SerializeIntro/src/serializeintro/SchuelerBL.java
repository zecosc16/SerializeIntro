/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializeintro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author oskar
 */
public class SchuelerBL extends AbstractListModel{
    
    private ArrayList<Schueler> schueler = new ArrayList<>();
    
    public void add(Schueler s){
        schueler.add(s);
    }

    @Override
    public int getSize() {
        return schueler.size();
     }

    @Override
    public Object getElementAt(int index) {
        return schueler.get(index);
    }
    
    public void save(File f) throws Exception{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f)); 
            for (Schueler s : schueler) {
                oos.writeObject(s);
            }
            
            oos.flush();
            oos.close();
        
        
    }
    
    public void load(File f) throws Exception{
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(f));
            Object obj;
            while ((obj = ois.readObject()) != null) {
                
                if (obj instanceof Schueler) {
                    schueler.add((Schueler) obj);
                }
            }
        } catch (EOFException ex) {
       
        }
        
        ois.close();
        fireContentsChanged(this, 0, schueler.size()-1);
    }
    
    public void print(){
        for (Schueler s : schueler) {
            System.out.println(s.getName()+" "+s.getBirthday());
        }
    }
    
        
 
    
    
}
