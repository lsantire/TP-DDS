/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Triple<F, S, T> {

    public final F first;
    public final S second;
    public final T third;

    public Triple(F first, S second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Triple)) {
            return false;
        }
        Triple<?, ?, ?> p = (Triple<?, ?, ?>) o;
        return first.equals(p.first) && second.equals(p.second) && third.equals(p.third);
    }

    private static boolean equals(Object x, Object y) {
        return (x == null && y == null) || (x != null && x.equals(y));
    }

    @Override
    public int hashCode() {
        return (first == null ? 0 : first.hashCode()) ^ (second == null ? 0 : second.hashCode()) ^ (third == null ? 0 : third.hashCode());
    }

    public static <F, S, T> Triple <F, S, T> create(F f, S s, T t) {
        return new Triple<F, S, T>(f, s, t);
    }

    public String toStringEsporadica() {  
        
        return ((Date)first).getDate()+"/"+(((Date)first).getMonth()+1)+"/"+(((Date)first).getYear()+1900)+": "
                +((Time)second).getHours()+":"+((Time)second).getMinutes()/10+"0 - "
                +((Time)third).getHours()+":"+((Time)third).getMinutes()/10+"0";
    }
    
    public String toStringPeriodica() {
        
        String retorno="";
        
        switch(((Date)first).getDay()){
                    case 1:retorno+="Lunes";break;
                    case 2:retorno+="Martes";break;
                    case 3:retorno+="Miercoles";break;
                    case 4:retorno+="Jueves";break;
                    case 5:retorno+="Viernes";break;
                }
        
        retorno +=": "+((Time)second).getHours()+":"+((Time)second).getMinutes()/10+"0 - "
                +((Time)third).getHours()+":"+((Time)third).getMinutes()/10+"0";
        
        return retorno;
        
    }
    
}