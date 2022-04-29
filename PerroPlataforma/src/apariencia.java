/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.media.j3d.Appearance;
import javax.media.j3d.ColoringAttributes;
import javax.media.j3d.Material;
import javax.media.j3d.TransparencyAttributes;
import javax.vecmath.Color3f;

/**
 *
 * @author draw-
 */
public class apariencia {

    public Appearance color(float r, float b, float g) {
        Appearance ap = new Appearance();
        Color3f objcolor = new Color3f(r / 255f, b / 255f, g / 255f);
        ColoringAttributes ca = new ColoringAttributes();
        ca.setColor(objcolor);
       
        ap.setColoringAttributes(ca);

        return ap;

    }
    
    public Appearance getTransparency(Float n1, Float n2, Float n3){
        Appearance ap=new Appearance();
        TransparencyAttributes t=new TransparencyAttributes(TransparencyAttributes.BLENDED, 0.75f);
        ap.setTransparencyAttributes(t);
        ColoringAttributes ca=new ColoringAttributes();
        ca.setColor(n1, n2, n3);
        ap.setColoringAttributes(ca);
        return ap;
    }

}
