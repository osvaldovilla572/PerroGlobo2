/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PerroGlobo;

import javafx.scene.AmbientLight;
import javafx.scene.paint.Color;
import javax.media.j3d.Appearance;
import javax.media.j3d.ColoringAttributes;
import javax.media.j3d.DirectionalLight;
import javax.vecmath.Color3f;
import javax.vecmath.Vector3f;

/**
 *
 * @author DE LA CRUZ VILLANUEV
 */
public class Apariencia {
    Color3f objColor;
    
    public Appearance color(float r, float g, float b)
    {
        Appearance ap = new Appearance();
        objColor = new Color3f(r/255f,g/255f,b/255f);
        ColoringAttributes ca = new ColoringAttributes();
        ca.setColor(objColor);

        //DirectionalLight luzDireccional = new DirectionalLight(objColor, new Vector3f(0.1f,0.1f,0.1f));

        return ap;
    }
    
    public DirectionalLight luzDireccional(float r, float g, float b, Vector3f vector)
    {
        objColor = new Color3f(r/255f,g/255f,b/255f);
        DirectionalLight ld = new DirectionalLight(objColor,vector);
        return ld;
    }
    
    public AmbientLight luzAmbiental(Color3f c)
    {
        AmbientLight la = new AmbientLight(Color.CORAL);
        return la;
    }
    
}
