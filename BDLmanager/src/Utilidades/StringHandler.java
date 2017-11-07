/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.util.ArrayList;

/**
 *
 * @author Facundo
 */
public class StringHandler {
    
    public static boolean isNameOrSurname(String s){
        
        boolean retorno=true;
        
        ArrayList bools=new ArrayList();
        
        for(int i=0;i<s.length();i++){
            
            char c=s.charAt(i);
            
            if(i==0){
                if(c<65){
                    bools.add(false);
                }
                
                if(c>90 && c<97){
                    bools.add(false);
                }
                
                if(c>122){
                    
                        bools.add(false);

                }
            }
            
            if(i>0){
                
                if(c<32){
                    bools.add(false);
                }
                
                if(c>32 && c<39){
                    bools.add(false);
                }
                
                if(c>39 && c<45){
                    bools.add(false);
                }
                
                if(c>45 && c<65){
                    bools.add(false);
                }
                
                if(c>90 && c<97){
                    bools.add(false);
                }
                
                if(c>122){
                    bools.add(false);
                }
                
                if(isGuionApostrofeEspacio(c) && isGuionApostrofeEspacio(s.charAt(i-1))){
                    bools.add(false);
                }
   
            }
            
        }
        
        for(int i=0;i<bools.size();i++){
            retorno=retorno && (boolean)bools.get(i);
        }
        
        return retorno;
        
    }
    
    public static String toProperNameCase(String s){
        
        char[] retorno = new char[s.length()];
        
        for(int i=0;i<s.length();i++){
            
            char c=s.charAt(i);
            
            if(i==0){
                if(c>=97 && c<=122){
                    retorno[i]=(char)(c-32);
                } else{
                    retorno[i]=c;
                }
            }
            
            if(i>0){
                
                if(c>=65 && c<=90 && !(isGuionApostrofeEspacio(s.charAt(i-1)))){
                    
                    retorno[i]=(char)(c+32);
                    
                }
                
                else if(c>=97 && c<=122 && (isGuionApostrofeEspacio(s.charAt(i-1)))){
                    
                    retorno[i]=(char)(c-32);
                    
                } else {
                    retorno[i]=c;
                }
                
            }
            
        }
        
        return String.valueOf(retorno);
        
    }
    
    private static boolean isGuionApostrofeEspacio(char c){
        
        if(c==32 || c==45 || c==39) {
            return true;
        }else return false;
        
    }
    
}
