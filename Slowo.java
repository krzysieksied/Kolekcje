/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pzj_wykla2;

/**
 *
 * @author krzysiek
 */
public class Slowo implements Comparable<Slowo> {
    
    
    private String wyraz;
    private int liczba;
    
    public Slowo(String wyraz,int liczba){
    this.wyraz=wyraz;
    this.liczba=liczba;
    }
    
    public int  getliczba(){
        return liczba;
    }
    
    public void setLiczba(int liczba){
    this.liczba=liczba;
    }
    
    public String getWyraz(){
    return wyraz;  
    }
    
    public void setWyraz(String wyraz){
    this.wyraz=wyraz;
    }
    
    
    @Override
    public int compareTo(Slowo o){
    int result= o.liczba-this.liczba;
    return result;
    }
    
    @Override
    public String toString(){
    return wyraz+" "+liczba;
    }
}
