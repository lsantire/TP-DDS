/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Bedel;
import Entidad.PoliticaSeguridad;
import Excepciones.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Facundo
 */
public class Gestor_Bedeles {
    
    //Patrón Singleton
    private static Gestor_Bedeles instance=null;
    private Gestor_Bedeles(){};
    public static Gestor_Bedeles getInstance(){
        if(instance==null) instance=new Gestor_Bedeles();
        return instance;
    }
    
    public Collection<Bedel> buscarBedel(){
        
        //a implementar
        
        return new ArrayList();
        
    }
    
    public void crearBedel(String nombre, String apellido, String turno, String id, String pass) throws BedelEnUsoException,ErrorInsercionException,NoCumplePoliticaException {
        
        ArrayList<PoliticaSeguridad> politicas =(ArrayList<PoliticaSeguridad>)(DAO_PoliticaSeguridad.getInstance().find());
        
        if(politicas.isEmpty()){
            throw new NoCumplePoliticaException("No existe una politica de seguridad.\nNo se puede crear un bedel");
        }
        
        PoliticaSeguridad politicaSeguridad=null;
        
        for(int i=0;i<politicas.size();i++){
            if(politicas.get(i).isVigente()){
                politicaSeguridad=politicas.get(i); //En el caso que haya muchas vigentes, va a tomar la ultima en la BDD
            }
        }
        
        
        
        //Validacion de politica seguridad
        if(!this.validarPolitica(politicaSeguridad,pass)){
            String infoError = "";
            if(politicaSeguridad.isDebeEspecial())infoError+="La contraseña debe tener al menos un signo especial(@#$%&*)\n";
            if(politicaSeguridad.isDebeUnNumero())infoError+="La contraseña debe tener al menos un numero\n";
            if(politicaSeguridad.isDebeUnaMayus())infoError+="La contraseña debe tener una mayuscula\n";
            infoError+="La contraseña debe tener un mínimo de "+politicaSeguridad.getLongitudMinima()+" caracteres\n";
            
            throw new NoCumplePoliticaException(infoError);
        }
        
        //Validacion de existencia del bedel
        if(!DAO_Bedeles.getInstance().find(new Bedel(id)).isEmpty()){
            throw new BedelEnUsoException();
        }
        
        //Se crea el nuevo bedel y se procede a pedirle al DAO que lo inserte en la bdd
        Bedel bdl = new Bedel (nombre,apellido,id,pass,turno);
        if(!DAO_Bedeles.getInstance().insert(bdl)){
            throw new ErrorInsercionException();
        }    
    }
    
    public boolean eliminarBedel (Bedel bdl){
        
        //a implementar
        
        return true;
    }
    
    public Bedel modificarBedel(Bedel bdl){
        
        //A implementar
        
        return new Bedel("a");
         
    }
    
    private boolean validarPolitica(PoliticaSeguridad ps, String pass){
        
        if(ps.isDebeEspecial() && !(pass.contains("@")||pass.contains("#")||pass.contains("$")||pass.contains("%")||pass.contains("&")||pass.contains("*"))){
            return false;
        }
        if(ps.isDebeUnNumero() && !(pass.contains("0")||pass.contains("1")||pass.contains("2")||pass.contains("3")||pass.contains("4")||pass.contains("5")||
                                    pass.contains("6")||pass.contains("7")||pass.contains("8")||pass.contains("9"))){
            return false;
        }
        if(ps.isDebeUnaMayus() && pass.equals(pass.toLowerCase())){
            return false;
        }
        if(ps.getLongitudMinima()>pass.length()){
            return false;
        }
        
        //No se evalua la posibilidad de una contraseña anterior porque este es un bedel nuevo
        
        return true;
    }
    
}
