/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PerroGlobo;

import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.geometry.Sphere;
import javax.media.j3d.Appearance;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Vector3f;

/**
 *
 * @author DE LA CRUZ VILLANUEV
 */
class crearEscenaGraficaPerro {
    
    BranchGroup objRaiz = new BranchGroup();
    
    public crearEscenaGraficaPerro(){
        
        Appearance apBlanca = new Appearance();
        //<-----------CUERPO----------->
        //Panza
        Transform3D t3dPanza = new Transform3D();
        t3dPanza.rotZ(Math.PI/180*90);
        TransformGroup tgPanza = new TransformGroup(t3dPanza);
        Cylinder panza = new Cylinder(0.2f, 0.6f,apBlanca);
        objRaiz.addChild(tgPanza);
        tgPanza.addChild(panza);
        
        //Esfera 1
        Transform3D t3dEsferaPanza1 = new Transform3D();
        t3dEsferaPanza1.setTranslation(new Vector3f(0.0f,0.3f,0.0f));
        
        TransformGroup tgEsferaPanza1 = new TransformGroup(t3dEsferaPanza1);
        Sphere esferaPanza1 = new Sphere(0.2f,apBlanca);
        tgPanza.addChild(tgEsferaPanza1);
        tgEsferaPanza1.addChild(esferaPanza1);
        
        //Esfera 2
        Transform3D t3dEsferaPanza2 = new Transform3D();
        t3dEsferaPanza2.setTranslation(new Vector3f(0.0f,-0.3f,0.0f));
        
        TransformGroup tgEsferaPanza2 = new TransformGroup(t3dEsferaPanza2);
        Sphere esferaPanza2 = new Sphere(0.2f,apBlanca);
        tgPanza.addChild(tgEsferaPanza2);
        tgEsferaPanza2.addChild(esferaPanza2);
        //<------------FIN CUERPO------------->
        
        //<---------------CUELLO-------------->
        Transform3D t3dCuello = new Transform3D();
        t3dCuello.rotZ(Math.PI/180*-30);
        t3dCuello.setTranslation(new Vector3f(0.5f,0.335f,0.0f));
        TransformGroup tgCuello = new TransformGroup(t3dCuello);
        Cylinder cuello = new Cylinder(0.1f,0.2f,apBlanca);
        objRaiz.addChild(tgCuello);
        tgCuello.addChild(cuello);
        
        //esfera 1 cuello
        Transform3D t3dEsferaCuello1 = new Transform3D();
        t3dEsferaCuello1.setTranslation(new Vector3f(0.0f,0.1f,0.0f));
        
        TransformGroup tgEsferaCuello1 = new TransformGroup(t3dEsferaCuello1);
        Sphere esferaCuello1 = new Sphere(0.1f,apBlanca);
        tgCuello.addChild(tgEsferaCuello1);
        tgEsferaCuello1.addChild(esferaCuello1);
        
        //Esfera 2 cuello
        Transform3D t3dEsferaCuello2 = new Transform3D();
        t3dEsferaCuello2.setTranslation(new Vector3f(0.0f,-0.1f,0.0f));
        
        TransformGroup tgEsferaCuello2 = new TransformGroup(t3dEsferaCuello2);
        Sphere esferaCuello2 = new Sphere(0.1f,apBlanca);
        tgCuello.addChild(tgEsferaCuello2);
        tgEsferaCuello2.addChild(esferaCuello2);
        //<------------FIN CUELLO------------->
        
        
        
    }
    
}
