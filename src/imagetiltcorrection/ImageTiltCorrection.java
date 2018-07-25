/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagetiltcorrection;


import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;
import org.opencv.core.RotatedRect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import static org.opencv.imgproc.Imgproc.ADAPTIVE_THRESH_MEAN_C;
import static org.opencv.imgproc.Imgproc.THRESH_BINARY;

/**
 * @author House
 **/
public class ImageTiltCorrection extends JPanel {

    public static void main(String[] args) {
        /*JFrame F = new JFrame();

        F.add(new ImageTiltCorrection());
        F.setSize(600, 600);
        F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        F.setVisible(true);*/
        ImageTiltCorrection tiltC = new ImageTiltCorrection();
        tiltC.paintComponent(new Graphics() {
            @Override
            public Graphics create() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void translate(int x, int y) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Color getColor() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void setColor(Color c) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void setPaintMode() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void setXORMode(Color c1) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Font getFont() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void setFont(Font font) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public FontMetrics getFontMetrics(Font f) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Rectangle getClipBounds() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void clipRect(int x, int y, int width, int height) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void setClip(int x, int y, int width, int height) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Shape getClip() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void setClip(Shape clip) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void copyArea(int x, int y, int width, int height, int dx, int dy) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void drawLine(int x1, int y1, int x2, int y2) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void fillRect(int x, int y, int width, int height) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void clearRect(int x, int y, int width, int height) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void drawOval(int x, int y, int width, int height) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void fillOval(int x, int y, int width, int height) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void drawString(String str, int x, int y) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void drawString(AttributedCharacterIterator iterator, int x, int y) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, ImageObserver observer) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, Color bgcolor, ImageObserver observer) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void dispose() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    public void paintComponent(Graphics g) {
        //File dir = new File()
        //GraphDisplay graphImg = new GraphDisplay(p);
        //Graphics2D g2d = (Graphics2D) g;
        //La convertimos a escala de grises
        
        //Después, realizamos la corrección de inclinación computada
        computeSkew("tilteada");
        System.out.println("IS THIS HAPPENNING MORE THAN ONCE????");
        //OBJETIVO:
        //Transformar estas funciones a clases bien establecidas....
        //¿Qué queremos?
        //Buscamos poder utilizar las funciones sin tener que estar haciendo 
        //tanto intercambio de archivos.
        //Una funcion que reciba una imagen, el nombre de salida?
        //Separar las funciones de escala de grises, binarización y corrección de tilt
        //... proceder con el problema de calificar el examen, Good Luck, bitch.
    }

    BufferedImage LoadImage(String FileName) {

        BufferedImage img = null;

        try {
            img = ImageIO.read(new File(FileName));
        } catch (IOException ex) {
            Logger.getLogger(ImageTiltCorrection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return img;
    }

    public Mat deskew(Mat src, double angle) {
        Point center = new Point(src.width() / 2, src.height() / 2);
        Mat rotImage = Imgproc.getRotationMatrix2D(center, angle, 1.0);
        //1.0 means 100 % scale
        Size size = new Size(src.width(), src.height());
        Imgproc.warpAffine(src, src, rotImage, size, Imgproc.INTER_LINEAR + Imgproc.CV_WARP_FILL_OUTLIERS);
        return src;
    }

    public void computeSkew(String inFile) {
        //Load this image in grayscale
        
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.out.println("NOMBRE QUE ENTRO A COMPUTE SKEW:" + inFile);
        
        //Mat img = Imgcodecs.imread(, Imgcodecs.IMREAD_GRAYSCALE);
        //Binarize it
        //Use adaptive threshold if necessary
        

        //BINARIZACIONPROCESOTIPO1
        //Imgproc.adaptiveThreshold(img, img, 255, ADAPTIVE_THRESH_MEAN_C, THRESH_BINARY, 15, 40);
        //Imgproc.threshold(img, img, 200, 255, THRESH_BINARY);
        //BINARIZACIONPROCESOTIPO1
        
        //BINARIZACIONPROCESO2
         
        Mat source = Imgcodecs.imread(ConvertirEscalaDeGrises(inFile+".jpg").getPath(),
                Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);
        Mat img = new Mat(source.rows(), source.cols(), source.type());

        
        Imgproc.threshold(source, img, 127, 255, Imgproc.THRESH_BINARY);
        Imgcodecs.imwrite("BINARIZED"+inFile+".jpg", img);
        //BINARIZACIONPROCESO2
       


        //Invert the colors (because objects are represented as white pixels, and the background is represented by black pixels)
        Core.bitwise_not(img, img);
        Mat element = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(3, 3));

        //We can now perform our erosion, we must declare our rectangle-shaped structuring element and call the erode function
        Imgproc.erode(img, img, element);

        //Find all white pixels
        Mat wLocMat = Mat.zeros(img.size(), img.type());
        Core.findNonZero(img, wLocMat);

        //Create an empty Mat and pass it to the function
        MatOfPoint matOfPoint = new MatOfPoint(wLocMat);

        //Translate MatOfPoint to MatOfPoint2f in order to user at a next step
        MatOfPoint2f mat2f = new MatOfPoint2f();
        matOfPoint.convertTo(mat2f, CvType.CV_32FC2);

        //Get rotated rect of white pixels
        RotatedRect rotatedRect = Imgproc.minAreaRect(mat2f);

        Point[] vertices = new Point[4];
        rotatedRect.points(vertices);
        ArrayList<MatOfPoint> boxContours = new ArrayList<>();
        boxContours.add(new MatOfPoint(vertices));
        Imgproc.drawContours(img, boxContours, 0, new Scalar(128, 128, 128), -1);
        
        double resultAngle = rotatedRect.angle;
        
        if (rotatedRect.size.width > rotatedRect.size.height) {
            rotatedRect.angle += 90.f;
        }
        //Or
        //rotatedRect.angle = rotatedRect.angle < -45 ? rotatedRect.angle + 90.f : rotatedRect.angle;
        Mat result = deskew(Imgcodecs.imread("BINARIZED"+inFile + ".jpg"), rotatedRect.angle);
        Imgcodecs.imwrite("ROTATED" + inFile + ".jpg", result);
    }

    public File ConvertirEscalaDeGrises(String file) {
        try {
            BufferedImage image;
            int width;
            int height;
            File input = new File(file);
            image = ImageIO.read(input);
            width = image.getWidth();
            height = image.getHeight();
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    Color c = new Color(image.getRGB(j, i));
                    int red = (int) (c.getRed() * 0.299);
                    int green = (int) (c.getGreen() * 0.587);
                    int blue = (int) (c.getBlue() * 0.114);
                    Color newColow = new Color(red + green + blue,
                            red + green + blue, red + green + blue);
                    image.setRGB(j, i, newColow.getRGB());
                }
            }
            File output = new File("GS" + file);
            
            ImageIO.write(image, "jpg", output);
            return output;
        } catch (IOException ex) {
            Logger.getLogger(ImageTiltCorrection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
