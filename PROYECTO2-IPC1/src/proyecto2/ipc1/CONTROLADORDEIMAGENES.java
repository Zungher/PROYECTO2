
package proyecto2.ipc1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class CONTROLADORDEIMAGENES{

    /**
     * @return the imagensalida
     */
    public File getImagensalida() {
        return imagensalida;
    }

    /**
     * @return the g2d
     */
    public Graphics2D getG2d() {
        return g2d;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @return the bytesImg
     */
    public byte[] getBytesImg() {
        return bytesImg;
    }

    /**
     * @return the imagenelegida
     */
    public File getImagenelegida() {
        return imagenelegida;
    }

    /**
     * @return the imagensegunda
     */
    public BufferedImage getImagensegunda() {
        return imagensegunda;
    }

    /**
     * @return the imagentrabajada
     */
    public BufferedImage getImagentrabajada() {
        return imagentrabajada;
    }

    /**
     * @return the ancho
     */
    public int getAncho() {
        return ancho;
    }

    /**
     * @return the altura
     */
    public int getAltura() {
        return altura;
    }

    /**
     * @return the R
     */
    public int[][] getR() {
        return R;
    }

    /**
     * @return the G
     */
    public int[][] getG() {
        return G;
    }

    /**
     * @return the B
     */
    public int[][] getB() {
        return B;
    }

    /**
     * @return the gris
     */
    public int[][] getGris() {
        return gris;
    }

    /**
     * @return the imagenoriginal
     */
    public BufferedImage getImagenoriginal() {
        return imagenoriginal;
    }
    private final JFileChooser acciones = new JFileChooser();
    private Graphics2D g2d;
    private File imagenelegida;
    public File imagensalida;
    private String direccion;
    private BufferedImage imagenoriginal;
    private BufferedImage imagensegunda;
    private BufferedImage imagentrabajada;
    private FileOutputStream imagenguardada;
    private int ancho;
    private int altura;
    private int[][] R, G, B, gris;
    FileInputStream entrada;
    FileOutputStream salida;
    private byte[] bytesImg;
    public final int RORATE_90=1;
    public final int RORATE_180=-1;
    public byte[] abririmagen(){
    bytesImg = new byte[1024*100];
    
        try {
            acciones.setDialogTitle("Seleccionar imagen");
        FileNameExtensionFilter filtroimagen = new FileNameExtensionFilter("JPG && BMP", "jpg", "bmp");
        acciones.setFileFilter(filtroimagen);
        int flag = acciones.showOpenDialog(null);
        if (flag == JFileChooser.APPROVE_OPTION) {
            imagenelegida = acciones.getSelectedFile();
            imagenoriginal = ImageIO.read(getImagenelegida());
            entrada = new FileInputStream(imagenelegida);
            entrada.read(getBytesImg());
            ancho = getImagenoriginal().getWidth();
            altura = getImagenoriginal().getHeight();
            direccion = imagenelegida.getCanonicalPath();
            imagensalida=imagenelegida;
        }else if (getImagenelegida()==null) {
                 
            }else{
            imagenelegida = acciones.getSelectedFile();
            imagensegunda = ImageIO.read(getImagenelegida());
            imagensalida=imagenelegida;
        }
//        obteberRGB();
        return getBytesImg();
        } catch (Exception e) {
        }
        return null;
        
    }
    
    public String guadarimagen(byte[] bytesImg, File archivo){
        String respuesta=null;
        String nombre = archivo.getName();
        nombre = "rotation-"+nombre.replace(".jpg", "")+".jpg";
        try {    
        imagenguardada = new FileOutputStream(new File(nombre));
        imagenguardada.write(bytesImg);
        respuesta = "La imagen se guardo con exito";
        } catch (Exception e) {
        }
        return respuesta;   
    }
    
    public void obteberRGB(){
        int mediaPixel;
        Color c;
        gris = new int[getAncho()][getAltura()];
        R = new int[getAncho()][getAltura()];
        G = new int[getAncho()][getAltura()];
        B = new int[getAncho()][getAltura()];
        for (int i = 0; i < getAncho(); i++) {
            for (int j = 0; j < getAltura(); j++) {
                c= new Color(imagenoriginal.getRGB(i, j));
                R[i][j]=c.getRed();
                G[i][j]=c.getGreen();
                B[i][j]=c.getBlue();
                mediaPixel=(int)((c.getRed()*0.3)+(c.getGreen()*0.59)+(c.getBlue()*0.11));
                gris[i][j]=mediaPixel;
            }
        }
    }
    
    public void crearimagen(int[][] imagen,int x,int y){
        try {
            imagentrabajada = new BufferedImage(x, y, imagenoriginal.getType());
            for (int i = 0; i < imagen.length; i++) {
                for (int j = 0; j < imagen[0].length; j++) {
                    int rgb=imagen[i][j]<<16 | imagen[i][j]<<8 | imagen[i][j];
                    getImagentrabajada().setRGB(i, j, new Color(rgb).getRGB());
                    
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void obteberRGBsepia()   {
        int tr, tg, tb;
        Color c;
        gris = new int[getAncho()][getAltura()];
        R = new int[getAncho()][getAltura()];
        G = new int[getAncho()][getAltura()];
        B = new int[getAncho()][getAltura()];
        
        imagentrabajada = new BufferedImage(getAncho(), getAltura(), imagenoriginal.getType());
        for (int i = 0; i < getAncho(); i++) {
            for (int j = 0; j < getAltura(); j++) {
                int p = imagenoriginal.getRGB(i, j);
                int a = (p>>24)&0xff;
                int r = (p>>16)&0xff;
                int g = (p>>8)&0xff;
                int b = p&0xff;
                
                tr = (int)(0.393*r+0.769*g+0.189*b);
                tg = (int)(0.349*r+0.686*g+0.168*b);
                tb = (int)(0.272*r+0.534*g+0.131*b);
                if (tr>255) {r=255;}else{r=tr;}
                if (tg>255) {g=255;}else{g=tg;}
                if (tb>255) {b=255;}else{b=tb;}
                
                p = (a<<24) | (r<<16) | (g<<8) | (b);
                
                getImagentrabajada().setRGB(i, j, p);
                
            }
        }
    }

     public String copiaImagenjpg(File archivo, byte [] bytesImg){
        String respuesta=null;
        String nombre = "Copy-"+archivo.getName();
        
        archivo.getName();
        try {
            salida = new FileOutputStream(new File(nombre));
            salida.write(bytesImg);
            respuesta = "La imagen se guardo con exito";
        } catch (Exception e) {
        }
        return respuesta;
    }
     
    public void rotate90(File archivo, File archivhosalida, int direccion){
        try {
            ImageInputStream inicial = ImageIO.createImageInputStream(archivo);
            Iterator<ImageReader> iterador = ImageIO.getImageReaders(inicial);
            ImageReader reader = iterador.next();
            String formato = reader.getFormatName();
            
            BufferedImage dato = ImageIO.read(inicial);
            int width = dato.getWidth();
            int height = dato.getHeight();
            BufferedImage rotacion = new BufferedImage(height, width, dato.getType());
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y   ++) {
                    switch(direccion){
                        case RORATE_90:
                            rotacion.setRGB(y, (width-1)-x, dato.getRGB(x, y));
                            break;
                        case RORATE_180:
                                                    
                    }
                }
            }
            
            ImageIO.write(rotacion, formato, archivhosalida);
        } catch (Exception e) {
        }
    }
}
