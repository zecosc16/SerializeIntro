/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializeintro;

import java.time.LocalDate;

/**
 *
 * @author oskar
 */
public class Schueler {
    
    private String name;
    private LocalDate birthday;

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Schueler(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }
}
