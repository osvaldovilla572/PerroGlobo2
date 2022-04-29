/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class HiloCaminata extends Thread{
    crearEscenaGraficaA crearEscena = new crearEscenaGraficaA();
    boolean c = false;
    
    public HiloCaminata(crearEscenaGraficaA cE){
        crearEscena = cE;
    }
    
    @Override
    public void run(){
        while(true)
        {
            crearEscena.p1.Caminata();
            if(c==false) break;
            try {
                Thread.sleep(18);
            } catch (InterruptedException ex) {
                
            }
        }//while
    }//run
    
}
