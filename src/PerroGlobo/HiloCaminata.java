/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PerroGlobo;

public class HiloCaminata extends Thread{
    crearEscenaGraficaPerro crearEscena = new crearEscenaGraficaPerro();
    boolean c = false;
    
    public HiloCaminata(crearEscenaGraficaPerro cE){
        crearEscena = cE;
    }
    
    @Override
    public void run(){
        while(true)
        {
            crearEscena.Caminata();
            if(c==false) break;
            try {
                Thread.sleep(18);
            } catch (InterruptedException ex) {
                
            }
        }//while
    }//run
    
}
