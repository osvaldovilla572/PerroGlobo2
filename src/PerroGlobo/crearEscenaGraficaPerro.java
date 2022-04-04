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
import javax.media.j3d.Appearance;
import javax.media.j3d.BoundingSphere;
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
    
    public crearEscenaGraficaPerro(){
        int paraTextura = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        Textura textura = new Textura();
        
        //<------CABEZA----->
        Transform3D t3dGirarCabeza = new Transform3D();
        Transform3D t3dMoverCabeza = new Transform3D();
        t3dMoverCabeza.setTranslation(new Vector3f(0.34f,-0.43f,0.0f));
        t3dGirarCabeza.rotZ(Math.PI/180*-120);
        t3dMoverCabeza.mul(t3dGirarCabeza);
        cabeza.tgCapsula.setTransform(t3dMoverCabeza);
        //<----FIN CABEZA---->
        
        //<-----BASE COLA---->
        Transform3D t3dGirarColita1 = new Transform3D();
        Transform3D t3dMoverColita1 = new Transform3D();
        t3dMoverColita1.setTranslation(new Vector3f(0.3f,0.43f,0.0f));
        t3dGirarColita1.rotZ(Math.PI/180*-60);
        t3dMoverColita1.mul(t3dGirarColita1);
        cola1.tgCapsula.setTransform(t3dMoverColita1);
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
       t3dMoverPataTraseraIzq.setTranslation(new Vector3f(-0.35f,0.27f,0.22f));
       t3dPataTraseraIzq.rotZ(Math.PI/180*90);
       t3dMoverPataTraseraIzq.mul(t3dPataTraseraIzq);
       pataTraseraIzq.tgCapsula.setTransform(t3dMoverPataTraseraIzq);
       //<-------FIN PATA TRASERA IZQ------>
       
       
       //<-------PATA TRASERA DER----------->
       Transform3D t3dPataTraseraDer = new Transform3D();
       Transform3D t3dMoverPataTraseraDer = new Transform3D();
       t3dMoverPataTraseraDer.setTranslation(new Vector3f(-0.35f,0.27f,-0.22f));
       t3dPataTraseraDer.rotZ(Math.PI/180*90);
       t3dMoverPataTraseraDer.mul(t3dPataTraseraDer);
       pataTraseraDer.tgCapsula.setTransform(t3dMoverPataTraseraDer);
       //<-------FIN PATA TRASERA DER------>
       
       //<-------PATA DELANTERA IZQ----------->
       Transform3D t3dPataDelanteraIzq = new Transform3D();
       Transform3D t3dMoverPataDelanteraIzq = new Transform3D();
       t3dMoverPataDelanteraIzq.setTranslation(new Vector3f(-0.35f,-0.27f,0.22f));
       t3dPataDelanteraIzq.rotZ(Math.PI/180*90);
       t3dMoverPataDelanteraIzq.mul(t3dPataDelanteraIzq);
       pataDelanteraIzq.tgCapsula.setTransform(t3dMoverPataDelanteraIzq);
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
       Sphere esferaGiro = new Sphere(0.09f,ap.color(0,0,0));
       tgMoverEsferaPDD.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
       tgMoverEsferaPDD.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
       tgMoverEsferaPDD.addChild(esferaGiro);
       
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
            
                objRotate.addChild(panza.tgCapsula);
                panza.tgCapsula.addChild(cabeza.tgCapsula);
                panza.tgCapsula.addChild(cola1.tgCapsula);
                cola1.tgCapsula.addChild(cola2.tgCapsula);
                panza.tgCapsula.addChild(pataTraseraIzq.tgCapsula);
                panza.tgCapsula.addChild(pataTraseraDer.tgCapsula);
                panza.tgCapsula.addChild(pataDelanteraIzq.tgCapsula);
                //panza.tgCapsula.addChild(pataDelanteraDer.tgCapsula);
                tgMoverEsferaPDD.addChild(pataDelanteraDer.tgCapsula);
                panza.tgCapsula.addChild(tgMoverEsferaPDD);
                cabeza.tgCapsula.addChild(orejaIzq.tgCapsula);
                cabeza.tgCapsula.addChild(orejaDer.tgCapsula);
                cabeza.tgCapsula.addChild(boca.tgCapsula);
                boca.tgCapsula.addChild(tgNariz);
                
       //<------FIN ROTAR CON MOUSE------->
       
       
        
    }
    
}
