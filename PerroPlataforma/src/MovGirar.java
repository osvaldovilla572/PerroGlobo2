
import javax.media.j3d.Transform3D;
import javax.vecmath.Vector3f;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Karina Benitez
 */
public class MovGirar {
    Transform3D t3dMover;
    public MovGirar(float x, float y, float z, float g, char eje){
        Transform3D Girar=new Transform3D();
        t3dMover=new Transform3D();
        t3dMover.setTranslation(new Vector3f(x,y,z));
        if (eje=='z')
        Girar.rotZ(Math.PI/180*-g);
        if (eje=='x')
        Girar.rotX(Math.PI/180*-g);
        if (eje=='y')
        Girar.rotY(Math.PI/180*-g);
                
        
        t3dMover.mul(Girar);
    }
}
