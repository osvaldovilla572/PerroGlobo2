/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PerroGlobo;

import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import com.sun.j3d.utils.geometry.Cone;
import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.geometry.Primitive;
import com.sun.j3d.utils.geometry.Sphere;
import java.awt.Color;
import java.awt.color.ColorSpace;
import javax.media.j3d.AmbientLight;
import javax.media.j3d.Appearance;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.DirectionalLight;
import javax.media.j3d.Material;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Vector3f;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;

/**
 *
 * @author DE LA CRUZ VILLANUEV
 */
class crearEscenaGraficaPerro {
    
    BranchGroup objRaiz = new BranchGroup();
    
    Apariencia ap = new Apariencia();
    
    capsula panza = new capsula(1,1);
    capsula cabeza = new capsula(0.5f,0.27f);
    capsula cola1 = new capsula(0.45f,0.2f);
    capsula cola2 = new capsula(0.1f,0.4f);
    capsula pataTraseraIzq = new capsula(0.45f, 0.65f);
    capsula pataTraseraDer = new capsula(0.45f, 0.65f);
    capsula pataDelanteraIzq = new capsula(0.45f, 0.65f);
    capsula pataDelanteraDer = new capsula(0.45f, 0.65f);
    capsula orejaIzq = new capsula(0.5f, 0.5f);
    capsula orejaDer = new capsula(0.5f, 0.5f);
    capsula boca = new capsula(0.5f, 0.3f);
    TransformGroup tgMoverEsferaPDD;
    TransformGroup tgMoverEsferaPDI;
    TransformGroup tgMoverEsferaPTD;
    TransformGroup tgMoverEsferaPTI;
    TransformGroup tgMoverCola;
    TransformGroup tgMoverCabeza;
    Transform3D escalarPerro;
    int contador;
    int contadorAux;
    
    public crearEscenaGraficaPerro(){
        int paraTextura = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        Textura textura = new Textura();
        
        escalarPerro = new Transform3D();
        Transform3D posicionInicial = new Transform3D();
        escalarPerro.setScale(.5);
        posicionInicial.rotZ(Math.PI/180*90);
        escalarPerro.mul(posicionInicial);
        panza.tgCapsula.setTransform(escalarPerro);
        panza.tgCapsula.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        panza.tgCapsula.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        
        
        
        
        //<------CABEZA----->
        Transform3D t3dGirarCabeza = new Transform3D();
        Transform3D t3dMoverCabeza = new Transform3D();
        t3dMoverCabeza.setTranslation(new Vector3f(0.0f,0.0f,0.0f));
        t3dGirarCabeza.rotZ(Math.PI/180*-60);
        t3dMoverCabeza.mul(t3dGirarCabeza);
        cabeza.tgCapsula.setTransform(t3dMoverCabeza);
        
        Transform3D t3dEsferaCabeza = new Transform3D();
        Transform3D t3dGirarEsferaCabeza = new Transform3D();
        t3dMoverCabeza.setTranslation(new Vector3f(0.3f,-0.43f,0.0f));
        t3dGirarEsferaCabeza.rotZ(Math.PI/180);
        t3dEsferaCabeza.mul(t3dGirarEsferaCabeza);
        tgMoverCabeza = new TransformGroup(t3dMoverCabeza);
        Sphere esferaCabeza = new Sphere(0.085f,ap.color(255,0,0));
        tgMoverCabeza.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tgMoverCabeza.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        tgMoverCabeza.addChild(esferaCabeza);
        //<----FIN CABEZA---->
        
        //<-----BASE COLA---->
        Transform3D t3dGirarColita1 = new Transform3D();
        Transform3D t3dMoverColita1 = new Transform3D();
        t3dMoverColita1.setTranslation(new Vector3f(0.06f,0.04f,0.0f));
        t3dGirarColita1.rotZ(Math.PI/180*-60);
        t3dMoverColita1.mul(t3dGirarColita1);
        cola1.tgCapsula.setTransform(t3dMoverColita1);
        
        Transform3D t3dMoverCola = new Transform3D();
        Transform3D t3dGirarCola = new Transform3D();
        t3dMoverCola.setTranslation(new Vector3f(0.24f,0.39f,0.0f));
        t3dGirarCola.rotZ(Math.PI/180);
        t3dMoverCola.mul(t3dGirarCola);
        tgMoverCola = new TransformGroup(t3dMoverCola);
        Sphere esferaCola = new Sphere(0.085f,ap.color(255,0,0));
        tgMoverCola.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tgMoverCola.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        tgMoverCola.addChild(esferaCola);
        //<------FIN BASE COLA------->
        
        //<------FINAL COLA-------->
        Transform3D t3dGirarColita2 = new Transform3D();
        Transform3D t3dMoverColita2 = new Transform3D();
        t3dMoverColita2.setTranslation(new Vector3f(0.0f,0.2f,0.0f));
        t3dGirarColita2.rotZ(Math.PI/180);
        t3dMoverColita2.mul(t3dGirarColita2);
        cola2.tgCapsula.setTransform(t3dMoverColita2);
        //<------ FIN FINAL COLA-------->
        
       //<-------PATA TRASERA IZQ----------->
       Transform3D t3dPataTraseraIzq = new Transform3D();
       Transform3D t3dMoverPataTraseraIzq = new Transform3D();
       t3dMoverPataTraseraIzq.setTranslation(new Vector3f(-0.2f,0.0f,0.0f));
       t3dPataTraseraIzq.rotZ(Math.PI/180*90);
       t3dMoverPataTraseraIzq.mul(t3dPataTraseraIzq);
       pataTraseraIzq.tgCapsula.setTransform(t3dMoverPataTraseraIzq);
       
       Transform3D t3dMoverEsferaPTI = new Transform3D();
       Transform3D t3dGirarESferaPTI = new Transform3D();
       t3dMoverEsferaPTI.setTranslation(new Vector3f(-0.16f,0.27f,0.22f));
       t3dGirarESferaPTI.rotZ(Math.PI/180);
       t3dMoverEsferaPTI.mul(t3dGirarESferaPTI);
       tgMoverEsferaPTI = new TransformGroup(t3dMoverEsferaPTI);
       Sphere esferaGiroPTI = new Sphere(0.09f,ap.color(0,0,0));
       tgMoverEsferaPTI.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
       tgMoverEsferaPTI.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
       tgMoverEsferaPTI.addChild(esferaGiroPTI);

       //<-------FIN PATA TRASERA IZQ------>
       
       
       //<-------PATA TRASERA DER----------->
       Transform3D t3dPataTraseraDer = new Transform3D();
       Transform3D t3dMoverPataTraseraDer = new Transform3D();
       t3dMoverPataTraseraDer.setTranslation(new Vector3f(-0.2f,0.0f,-0.0f));
       t3dPataTraseraDer.rotZ(Math.PI/180*90);
       t3dMoverPataTraseraDer.mul(t3dPataTraseraDer);
       pataTraseraDer.tgCapsula.setTransform(t3dMoverPataTraseraDer);
       
       Transform3D t3dMoverEsferaPTD = new Transform3D();
       Transform3D t3dGirarESferaPTD = new Transform3D();
       t3dMoverEsferaPTD.setTranslation(new Vector3f(-0.16f,0.27f,-0.22f));
       t3dGirarESferaPTD.rotZ(Math.PI/180);
       t3dMoverEsferaPTD.mul(t3dGirarESferaPTD);
       tgMoverEsferaPTD = new TransformGroup(t3dMoverEsferaPTD);
       Sphere esferaGiroPTD = new Sphere(0.09f,ap.color(0,0,0));
       tgMoverEsferaPTD.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
       tgMoverEsferaPTD.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
       tgMoverEsferaPTD.addChild(esferaGiroPTD);
       //<-------FIN PATA TRASERA DER------>
       
       //<-------PATA DELANTERA IZQ----------->
       Transform3D t3dPataDelanteraIzq = new Transform3D();
       Transform3D t3dMoverPataDelanteraIzq = new Transform3D();
       t3dMoverPataDelanteraIzq.setTranslation(new Vector3f(-0.2f,-0.0f,0.0f));
       t3dPataDelanteraIzq.rotZ(Math.PI/180*90);
       t3dMoverPataDelanteraIzq.mul(t3dPataDelanteraIzq);
       pataDelanteraIzq.tgCapsula.setTransform(t3dMoverPataDelanteraIzq);
       
       Transform3D t3dMoverEsferaPDI = new Transform3D();
       Transform3D t3dGirarESferaPDI = new Transform3D();
       t3dMoverEsferaPDI.setTranslation(new Vector3f(-0.16f,-0.27f,0.22f));
       t3dGirarESferaPDI.rotZ(Math.PI/180);
       t3dMoverEsferaPDI.mul(t3dGirarESferaPDI);
       tgMoverEsferaPDI = new TransformGroup(t3dMoverEsferaPDI);
       Sphere esferaGiroPDI = new Sphere(0.09f,ap.color(0,0,0));
       tgMoverEsferaPDI.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
       tgMoverEsferaPDI.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
       tgMoverEsferaPDI.addChild(esferaGiroPDI);
       //<-------FIN PATA DELANTERA IZQ------>
       
       //<-------PATA DELANTERA DER----------->
       Transform3D t3dPataDelanteraDer = new Transform3D();
       Transform3D t3dMoverPataDelanteraDer = new Transform3D();
       t3dMoverPataDelanteraDer.setTranslation(new Vector3f(-0.2f,0.0f,0.0f));
       t3dPataDelanteraDer.rotZ(Math.PI/180*90);
       t3dMoverPataDelanteraDer.mul(t3dPataDelanteraDer);
       pataDelanteraDer.tgCapsula.setTransform(t3dMoverPataDelanteraDer);
       
       Transform3D t3dMoverEsferaPDD = new Transform3D();
       Transform3D t3dGirarESferaPDD = new Transform3D();
       t3dMoverEsferaPDD.setTranslation(new Vector3f(-0.16f,-0.27f,-0.22f));
       t3dGirarESferaPDD.rotZ(Math.PI/180);
       t3dMoverEsferaPDD.mul(t3dGirarESferaPDD);
       tgMoverEsferaPDD = new TransformGroup(t3dMoverEsferaPDD);
       Sphere esferaGiroPDD = new Sphere(0.09f,ap.color(0,0,0));
       tgMoverEsferaPDD.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
       tgMoverEsferaPDD.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
       tgMoverEsferaPDD.addChild(esferaGiroPDD);
       
       //<-------FIN PATA DELANTERA DER------>
       
       //<------------OREJA IZQ-------->
       Transform3D t3dOrejaIzq = new Transform3D();
       Transform3D t3dMoverOrejaIzq = new Transform3D();
       t3dMoverOrejaIzq.setTranslation(new Vector3f(-0.25f,0.25f,0.11f));
       t3dOrejaIzq.rotZ(Math.PI/180*45);
       t3dMoverOrejaIzq.mul(t3dOrejaIzq);
       orejaIzq.tgCapsula.setTransform(t3dMoverOrejaIzq);
       //<---------FIN OREJA IZQ------->
       
       //<---------OREJA DER--------->
       Transform3D t3dOrejaDer = new Transform3D();
       Transform3D t3dMoverOrejaDer = new Transform3D();
       t3dMoverOrejaDer.setTranslation(new Vector3f(-0.25f,0.25f,-0.11f));
       t3dOrejaDer.rotZ(Math.PI/180*45);
       t3dMoverOrejaDer.mul(t3dOrejaDer);
       orejaDer.tgCapsula.setTransform(t3dMoverOrejaDer);
       //<------FIN OREJA DER------->
       
       //<----------BOCA------------->
       Transform3D t3dBoca = new Transform3D();
       Transform3D t3dMoverBoca = new Transform3D();
       t3dMoverBoca.setTranslation(new Vector3f(0.22f,0.25f,0.0f));
       t3dBoca.rotZ(Math.PI/180*125);
       t3dMoverBoca.mul(t3dBoca);
       boca.tgCapsula.setTransform(t3dMoverBoca);
      //<---------FIN BOCA---------->
       
       //<--------------NARIZ----------->
       Appearance apBlanca = new Appearance();
      
       Transform3D t3dMoverNariz = new Transform3D();
       t3dMoverNariz.setTranslation(new Vector3f(0.0f,-0.2f,0.0f));
       
        TransformGroup tgNariz = new TransformGroup(t3dMoverNariz);
        Cone nariz = new Cone(0.04f,0.04f,apBlanca);
//       t3dNariz.rotZ(Math.PI/180);
         tgNariz.addChild(nariz);
       //<-----------FIN NARIZ---------->
       
       //<---------ROTAR CON MOUSE--------->
       TransformGroup objRotate = new TransformGroup();
        objRotate.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        objRotate.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        objRaiz.addChild(objRotate);
        
        MouseRotate myMouseRotate = new MouseRotate();
        myMouseRotate.setTransformGroup(objRotate);
        myMouseRotate.setSchedulingBounds(new BoundingSphere());
        objRaiz.addChild(myMouseRotate);
        Color3f colorLA = new Color3f(Color.BLACK);
        Color3f colorLD = new Color3f(Color.RED);
        Vector3f vector = new Vector3f(-1.0f,-1.0f,-1.0f);
                
//                objRaiz.addChild(ap.luzAmbiente());
                objRotate.addChild(panza.tgCapsula);
                panza.t3dCapsula.setScale(.2);
                tgMoverCabeza.addChild(cabeza.tgCapsula);
                tgMoverEsferaPDI.addChild(pataDelanteraIzq.tgCapsula);
                tgMoverEsferaPDD.addChild(pataDelanteraDer.tgCapsula);
                tgMoverEsferaPTD.addChild(pataTraseraDer.tgCapsula);
                tgMoverEsferaPTI.addChild(pataTraseraIzq.tgCapsula);
                tgMoverCola.addChild(cola1.tgCapsula);
                cola1.tgCapsula.addChild(cola2.tgCapsula);
                panza.tgCapsula.addChild(tgMoverEsferaPDD);
                panza.tgCapsula.addChild(tgMoverEsferaPDI);
                panza.tgCapsula.addChild(tgMoverEsferaPTD);
                panza.tgCapsula.addChild(tgMoverEsferaPTI);
                panza.tgCapsula.addChild(tgMoverCola);
                panza.tgCapsula.addChild(tgMoverCabeza);
                cabeza.tgCapsula.addChild(orejaIzq.tgCapsula);
                cabeza.tgCapsula.addChild(orejaDer.tgCapsula);
                cabeza.tgCapsula.addChild(boca.tgCapsula);
                boca.tgCapsula.addChild(tgNariz);
                
       //<------FIN ROTAR CON MOUSE------->
       Appearance apariencia = new Appearance();
       Material material = new Material();
        material.setAmbientColor(new Color3f(java.awt.Color.GREEN ));
        material.setDiffuseColor(new Color3f(java.awt.Color.BLACK));
        material.setSpecularColor(new Color3f(java.awt.Color.WHITE));
        material.setEmissiveColor(new Color3f(java.awt.Color.BLACK));
        material.setShininess(20.0f);
        apariencia.setMaterial(material);
        
        //Cylinder cilindro = new Cylinder(0.3f, 0.7f,apariencia);
        
        AmbientLight luzAmbiente = new AmbientLight(new Color3f(Color.DARK_GRAY));
        luzAmbiente.setInfluencingBounds(new BoundingSphere(new Point3d(0,0,0),100));
        
        DirectionalLight luzD = new DirectionalLight(new Color3f(Color.WHITE), new Vector3f(-1.0f,-1.0f,-1.0f));
         luzD.setInfluencingBounds(new BoundingSphere(new Point3d(0,0,0),100));

        //objRaiz.addChild(cilindro);
        objRaiz.addChild(luzAmbiente);
        objRaiz.addChild(luzD);
      
    }
   
    public void Caminata()
    {
        contador++;
        mover(panza.tgCapsula,0.0f,-0.02f,0.0f);
        if(contador<5){
            Movimiento(tgMoverEsferaPDD, 13, "z");
            Movimiento(tgMoverEsferaPDI, -13, "z");
            Movimiento(tgMoverEsferaPTD,13, "z");
            Movimiento(tgMoverEsferaPTI, -13, "z");
        } else {
            if(contador<9){
                Movimiento(tgMoverEsferaPDD, -13, "z");
                Movimiento(tgMoverEsferaPDI, 13, "z");
                Movimiento(tgMoverEsferaPTD,-13, "z");
                Movimiento(tgMoverEsferaPTI, 13, "z");
            } else {
                if(contador<13){
                    Movimiento(tgMoverEsferaPDD, -13, "z");
                    Movimiento(tgMoverEsferaPDI, 13, "z");
                    Movimiento(tgMoverEsferaPTD,-13, "z");
                    Movimiento(tgMoverEsferaPTI, 13, "z");
                } else {
                    if(contador<17){
                        Movimiento(tgMoverEsferaPDD,13, "z");
                        Movimiento(tgMoverEsferaPDI, -13, "z");
                        Movimiento(tgMoverEsferaPTD,13, "z");
                        Movimiento(tgMoverEsferaPTI, -13, "z");
                    } else {
                        if(contador==17)
                        {
                            contador=0;
                        }
                    }
                }
            }
        }
    }
    
    public void MoverCola()
    {
        contador++;
        if(contador<5)
        {
           contadorAux++;
          Movimiento(tgMoverCola,11,"x");
          if(contadorAux<5){
              Movimiento(tgMoverCabeza, 8, "x");
              mover(tgMoverCabeza, -0.01f, 0.01f, 0.0f);
              Movimiento(tgMoverCabeza, -7, "z");
              Movimiento(panza.tgCapsula, 10, "z");
              Movimiento(tgMoverEsferaPDD,-5,"z");
              Movimiento(tgMoverEsferaPDI,-5,"z");
              Movimiento(tgMoverEsferaPTD,12,"z");
              Movimiento(tgMoverEsferaPTI, 12, "z");
            }
        } else {
            if(contador<9)
            {
                Movimiento(tgMoverCola,-11,"x");
            } else {
                if(contador<13)
                {
                    Movimiento(tgMoverCola,-11,"x");
                } else {
                    if(contador<17)
                    {
                        Movimiento(tgMoverCola,11,"x");
                    } else {
                        if(contador==17)
                            contador=0;
                    }
                }
            }
        }
    }
    
public void Mortal()
{
   contador++;
   if(contador<37)
   {
       contadorAux++;
       Movimiento(panza.tgCapsula,10, "z");
       mover(panza.tgCapsula, 0.05f, 0.05f, 0.0f);
       if(contadorAux<5)
       {
           Movimiento(tgMoverEsferaPDD, 20, "z");
            Movimiento(tgMoverEsferaPDI, 20, "z");
            Movimiento(tgMoverEsferaPTD,-20, "z");
            Movimiento(tgMoverEsferaPTI, -20, "z");
       } 
       else if(contador>=33 && contador<37)
       {
               Movimiento(tgMoverEsferaPDD, -20, "z");
                Movimiento(tgMoverEsferaPDI, -20, "z");
                Movimiento(tgMoverEsferaPTD,20, "z");
                Movimiento(tgMoverEsferaPTI, 20, "z");
        }
   }
}
    
    public static void  Movimiento(TransformGroup t, int g, String eje)
    {
        
        Transform3D lectura=new Transform3D();
        Transform3D escritura=new Transform3D();
        
        t.getTransform(lectura);
        if (eje.equals("z")) {
            escritura.rotZ(Math.PI / 180 * g);
        }
        if (eje.equals("y")) {
            escritura.rotY(Math.PI / 180 * g);
        }
        if (eje.equals("x")) {
            escritura.rotX(Math.PI / 180 * g);
        }
        lectura.mul(escritura);
        t.setTransform(lectura);
    }
    
     public void mover(TransformGroup t, float x, float y, float z) {
        Transform3D lectura = new Transform3D();
        Transform3D escritura = new Transform3D();
        t.getTransform(lectura);
        escritura.setTranslation(new Vector3f(x, y, z));
        lectura.mul(escritura);
        t.setTransform(lectura);
    }
     
      public void girar(TransformGroup t, int g, String eje) {
        Transform3D lectura=new Transform3D();
        Transform3D escritura=new Transform3D();
        
        t.getTransform(lectura);
        if (eje.equals("z")) {
            escritura.rotZ(Math.PI / 180 * g);
        }
        if (eje.equals("y")) {
            escritura.rotY(Math.PI / 180 * g);
        }
        if (eje.equals("x")) {
            escritura.rotX(Math.PI / 180 * g);
        }
        lectura.mul(escritura);
        t.setTransform(lectura);
    }
}
