/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializeintro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        for (Schueler s : schueler) {
            bw.write(s.getName());
            bw.write(";");
            bw.write(s.getBirthday().toString());
            bw.newLine();
        }
        
        bw.flush();
        bw.close();
        
    }
    
    public void load(File f) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(f));
        String line="";
        
        while ((line=br.readLine())!=null){
            String[] w=line.split(";");
            schueler.add(new Schueler(w[0],LocalDate.parse(w[1])));
        }
        
        fireContentsChanged(this, 0, schueler.size()-1);
    }
    
    public void print(){
        for (Schueler schueler1 : schueler) {
            System.out.println(schueler1.getName()+" "+schueler1.getBirthday());
        }
    }
    
    
}
