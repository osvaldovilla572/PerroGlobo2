
import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.geometry.Primitive;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.image.TextureLoader;
import java.io.File;
import javax.media.j3d.Appearance;
import javax.media.j3d.Background;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Karina Benitez
 */
public class crearEscenaGraficaA {
    BranchGroup objRaiz = new BranchGroup();
    crearEscenaGraficaPerro p1=new crearEscenaGraficaPerro();
    TransformGroup tgmanzana;   
    TransformGroup tgPlataforma;
    Box manzana;
    Vector3f carre=new Vector3f(0.7f,0.02f,0.07f);
    
    public crearEscenaGraficaA() {
        
        apariencia ap=new apariencia();
        int paraTextura = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        Texturas tx=new Texturas();
        
        MovGirar mgCielo=new MovGirar(0.0f,0.0f,0.0f,270,'x');
        Sphere spCielo=new Sphere(-1.8f,paraTextura,tx.crearTexturas("montanas.jpg"));
        TransformGroup tgCielo=new TransformGroup(mgCielo.t3dMover);
        tgCielo.addChild(spCielo);
        
        MovGirar mgPlataforma=new MovGirar(0.0f,0.0f,0.0f,0,'y');
        MovGirar mgPlataformaX=new MovGirar(0.0f,0.0f,0.0f,-40,'x');
        mgPlataforma.t3dMover.setScale(1);
        mgPlataforma.t3dMover.mul(mgPlataformaX.t3dMover);
        

        tgPlataforma=new TransformGroup(mgPlataforma.t3dMover);
        tgPlataforma.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tgPlataforma.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        
        Box plataforma=new Box(0.7f,0.02f,0.7f,ap.getTransparency(0.3f, 0.6f, 0.9f));
        tgPlataforma.addChild(plataforma);
        
        MovGirar mgCarretera=new MovGirar(0.0f,0.01f,0.0f,0,'y');
        MovGirar mgCarreteraX=new MovGirar(0.0f,0.0f,0.0f,0,'x');
        mgCarretera.t3dMover.mul(mgCarreteraX.t3dMover);
        TransformGroup tgCarretera=new TransformGroup(mgCarretera.t3dMover);
        Box Carretera=new Box(carre.x,carre.y,carre.z,paraTextura,tx.crearTexturas("carretera.jpg"));
        tgCarretera.addChild(Carretera);
        tgPlataforma.addChild(tgCarretera);
        
        MovGirar mgCarretera2=new MovGirar(0.0f,0.01f,0.0f,90,'y');
        MovGirar mgCarretera2X=new MovGirar(0.0f,0.0f,0.0f,0,'x');
        mgCarretera2.t3dMover.mul(mgCarretera2X.t3dMover);
        TransformGroup tgCarretera2=new TransformGroup(mgCarretera2.t3dMover);
        Box Carretera2=new Box(carre.x,carre.y,carre.z,paraTextura,tx.crearTexturas("carretera.jpg"));
        tgCarretera2.addChild(Carretera2);
        tgPlataforma.addChild(tgCarretera2);
//        
        MovGirar mgCarretera3=new MovGirar(0.0f,0.01f,0.7f,0,'y');
        MovGirar mgCarretera3X=new MovGirar(0.0f,0.0f,0.0f,0,'x');
        mgCarretera3.t3dMover.mul(mgCarretera3X.t3dMover);
        TransformGroup tgCarretera3=new TransformGroup(mgCarretera3.t3dMover);
        Box Carretera3=new Box(carre.x,carre.y,carre.z,paraTextura,tx.crearTexturas("carretera.jpg"));
        tgCarretera3.addChild(Carretera3);
        tgPlataforma.addChild(tgCarretera3);
        
        MovGirar mgCarretera4=new MovGirar(0.0f,0.01f,-0.7f,0,'y');
        MovGirar mgCarretera4X=new MovGirar(0.0f,0.0f,0.0f,0,'x');
        mgCarretera4.t3dMover.mul(mgCarretera4X.t3dMover);
        TransformGroup tgCarretera4=new TransformGroup(mgCarretera4.t3dMover);
        Box Carretera4=new Box(carre.x,carre.y,carre.z,paraTextura,tx.crearTexturas("carretera.jpg"));
        tgCarretera4.addChild(Carretera4);
        tgPlataforma.addChild(tgCarretera4);
        
        MovGirar mgCarretera5=new MovGirar(0.7f,0.01f,0.0f,90,'y');
        MovGirar mgCarretera5X=new MovGirar(0.0f,0.0f,0.0f,0,'x');
        mgCarretera5.t3dMover.mul(mgCarretera5X.t3dMover);
        TransformGroup tgCarretera5=new TransformGroup(mgCarretera5.t3dMover);
        Box Carretera5=new Box(carre.x,carre.y,carre.z,paraTextura,tx.crearTexturas("carretera.jpg"));
        tgCarretera5.addChild(Carretera5);
        tgPlataforma.addChild(tgCarretera5);
        
        MovGirar mgCarretera6=new MovGirar(-0.7f,0.01f,0.0f,90,'y');
        MovGirar mgCarretera6X=new MovGirar(0.0f,0.0f,0.0f,0,'x');
        mgCarretera6.t3dMover.mul(mgCarretera6X.t3dMover);
        TransformGroup tgCarretera6=new TransformGroup(mgCarretera6.t3dMover);
        Box Carretera6=new Box(carre.x,carre.y,carre.z,paraTextura,tx.crearTexturas("carretera.jpg"));
        tgCarretera6.addChild(Carretera6);
        tgPlataforma.addChild(tgCarretera6);
        
        MovGirar mgmanzana=new MovGirar(-0.7f,0.08f,0.0f,0,'y');
        MovGirar mgmanzanaX=new MovGirar(0.0f,0.0f,0.0f,0,'x');
        mgmanzana.t3dMover.mul(mgmanzanaX.t3dMover);
        tgmanzana=new TransformGroup(mgmanzana.t3dMover);
        manzana=new Box(0.05f,0.05f,0.05f,paraTextura,tx.crearTexturas("manzana.png"));
        tgmanzana.addChild(manzana);
        tgPlataforma.addChild(tgmanzana);
        
        //objRaiz.addChild(e1.tgElefante);
        objRaiz.addChild(tgCielo);
        //objRaiz.addChild(tgPlataforma);
        MovGirar mgPerro=new MovGirar(0.8f, 0.0f, 0.0f, 0,'x');
        p1.escalarPerro.setScale(.15);
        
        p1.escalarPerro.mul(mgPerro.t3dMover);
        p1.panza.tgCapsula.setTransform(p1.escalarPerro);
        tgPlataforma.addChild(p1.panza.tgCapsula);
        
        
        ///////Rotar con Mouse
        TransformGroup objRotate = new TransformGroup();
        objRotate.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        objRotate.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        objRaiz.addChild(objRotate);
        
        MouseRotate myMouseRotate = new MouseRotate();
        myMouseRotate.setTransformGroup(objRotate);
        myMouseRotate.setSchedulingBounds(new BoundingSphere());
        objRaiz.addChild(myMouseRotate);
    
        objRotate.addChild(tgPlataforma);
       
        
    }
    
    

        
}

