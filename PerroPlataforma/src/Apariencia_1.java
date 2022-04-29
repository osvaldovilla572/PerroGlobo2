/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.scene.paint.Color;
import javax.media.j3d.AmbientLight;
import javax.media.j3d.Appearance;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.ColoringAttributes;
import javax.media.j3d.DirectionalLight;
import javax.media.j3d.Material;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3f;

/**
 *
 * @author DE LA CRUZ VILLANUEV
 */
public class Apariencia_1 {
    Color3f objColor;
    
    public Appearance color(float r, float g, float b)
    {
        Appearance ap = new Appearance();
        objColor = new Color3f(r/255f,g/255f,b/255f);
        ColoringAttributes ca = new ColoringAttributes();
        ca.setColor(objColor);
        
         Material material = new Material();
        material.setAmbientColor(new Color3f(java.awt.Color.darkGray));
        material.setDiffuseColor(new Color3f(java.awt.Color.RED));
        material.setSpecularColor(new Color3f(java.awt.Color.WHITE));
        material.setEmissiveColor(new Color3f(java.awt.Color.BLACK));
        material.setShininess(20.0f);
        ap.setMaterial(material);
        
        return ap;
    }
    
//    public AmbientLight luzAmbiente()
//    {
//        Appearance apariencia = new Appearance();
//        Material material = new Material();
//        material.setAmbientColor(new Color3f(java.awt.Color.DARK_GRAY));
//        material.setDiffuseColor(new Color3f(java.awt.Color.RED));
//        material.setSpecularColor(new Color3f(java.awt.Color.WHITE));
//        material.setEmissiveColor(new Color3f(java.awt.Color.BLACK));
//        material.setShininess(20.0f);
//        apariencia.setMaterial(material);
//        
//        Color3f colorAmbiente = new Color3f(java.awt.Color.GREEN);
//        AmbientLight luzAmbiente = new AmbientLight(colorAmbiente);
//        luzAmbiente.setInfluencingBounds(new BoundingSphere(new Point3d(0,0,0),100));
//        
//        return luzAmbiente;
//    }
    
}
