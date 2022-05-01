/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PerroGlobo;

import com.sun.j3d.utils.image.TextureLoader;
import java.awt.Color;
import java.awt.Container;
import java.io.File;
import javax.media.j3d.AmbientLight;
import javax.media.j3d.Appearance;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.DirectionalLight;
import javax.media.j3d.Material;
import javax.media.j3d.Texture;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3f;

/**
 *
 * @author DE LA CRUZ VILLANUEV
 */
class Textura {
    
    public Appearance crearTexturas(String nomarch){
        File file = new File("");
        String ruta = file.getAbsolutePath()+"\\src\\img\\";
        TextureLoader loader = new TextureLoader((ruta+nomarch), new Container());
        Texture texture = loader.getTexture();
        Appearance app = new Appearance();
        app.setTexture(texture);
        
         Material material = new Material();
        material.setAmbientColor(new Color3f(java.awt.Color.darkGray));
        material.setDiffuseColor(new Color3f(java.awt.Color.RED));
        material.setSpecularColor(new Color3f(java.awt.Color.WHITE));
        material.setEmissiveColor(new Color3f(java.awt.Color.BLACK));
        material.setShininess(20.0f);
        app.setMaterial(material);
        
        AmbientLight luzAmbiente = new AmbientLight(new Color3f(Color.PINK));
        luzAmbiente.setInfluencingBounds(new BoundingSphere(new Point3d(0,0,0),100));
        
        DirectionalLight luzD = new DirectionalLight(new Color3f(Color.yellow), new Vector3f(-1.0f,-1.0f,-1.0f));
         luzD.setInfluencingBounds(new BoundingSphere(new Point3d(0,0,0),100));
         
        return app;
    }
    
}
