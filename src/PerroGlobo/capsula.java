/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PerroGlobo;

import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.geometry.Primitive;
import com.sun.j3d.utils.geometry.Sphere;
import javax.media.j3d.Appearance;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Vector3f;

/**
 *
 * @author DE LA CRUZ VILLANUEV
 */
public class capsula {
    
    TransformGroup tgCapsula;
    Transform3D t3dCapsula;
    
    int paraTextura = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
    Textura textura = new Textura();
    
    public capsula(float t, float a){
        Appearance apBlanca = new Appearance();
        
        t3dCapsula = new Transform3D();
        t3dCapsula.rotZ(Math.PI/180*90);
        tgCapsula = new TransformGroup(t3dCapsula);
        tgCapsula.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tgCapsula.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        Cylinder panza = new Cylinder(0.2f*t,0.6f*a,paraTextura,textura.crearTexturas("Pelo.jpg"));
        //objRaiz.addChild(tgCapsula);
        tgCapsula.addChild(panza);
        
        //Esfera 1
        Transform3D t3dEsferaCapsula1 = new Transform3D();
        t3dEsferaCapsula1.setTranslation(new Vector3f(0.0f,0.3f*a,0.0f));
        
        TransformGroup tgEsferaCapsula1 = new TransformGroup(t3dEsferaCapsula1);
        Sphere esferaCapsula1 = new Sphere(0.2f*t,paraTextura,textura.crearTexturas("Pelo.jpg"));
        tgCapsula.addChild(tgEsferaCapsula1);
        tgEsferaCapsula1.addChild(esferaCapsula1);
        
        //Esfera 2
        Transform3D t3dEsferaCapsula2 = new Transform3D();
        t3dEsferaCapsula2.setTranslation(new Vector3f(0.0f,-0.3f*a,0.0f));
        
        TransformGroup tgEsferaCapsula2 = new TransformGroup(t3dEsferaCapsula2);
        Sphere esferaCapsula2 = new Sphere(0.2f*t,paraTextura,textura.crearTexturas("Pelo.jpg"));
        tgCapsula.addChild(tgEsferaCapsula2);
        tgEsferaCapsula2.addChild(esferaCapsula2);
    }
    
}
