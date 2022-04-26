/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PerroGlobo;

/**
 *
 * @author osval
 */
public class HiloMortal extends Thread{
    crearEscenaGraficaPerro crearEscena = new crearEscenaGraficaPerro();
    boolean c = false;
    
    public HiloMortal(crearEscenaGraficaPerro cE){
        crearEscena = cE;
    }
    
    @Override
    public void run(){
        while(true)
        {
            crearEscena.Mortal();
            if(c==false) break;
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                
            }
        }//while
    }//run
    
}
