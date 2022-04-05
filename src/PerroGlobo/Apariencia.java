/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PerroGlobo;

import javax.media.j3d.Appearance;
import javax.media.j3d.ColoringAttributes;
import javax.vecmath.Color3f;

/**
 *
 * @author DE LA CRUZ VILLANUEV
 */
public class Apariencia {
    
    public Appearance color(float r, float g, float b)
    {
        Appearance ap = new Appearance();
        Color3f objColor = new Color3f(r/255f,g/255f,b/255f);
        ColoringAttributes ca = new ColoringAttributes();
        ca.setColor(objColor);
        
        ap.setColoringAttributes(ca);
        
        return ap;
    }
    
}
