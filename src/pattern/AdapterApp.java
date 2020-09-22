package pattern;

import java.io.FileNotFoundException;

public class AdapterApp {

    public static void main(String[] args){
        // 1-й способ через наследование
        VectorGraphicsInterface g1 = new VectorAdapterFromRaster();
        g1.drawLine();
        g1.drawSquare();
        // 2-й способ через композицию
        VectorGraphicsInterface g2 = new VectorAdapterFromRaster2();
        g2.drawLine();
        g2.drawSquare();

    }
}

interface VectorGraphicsInterface{
    void drawLine();
    void drawSquare();
}
class RasterGraphics{
    void drawRasterLine(){
        System.out.println("Line");
    }
    void drawRasterSquare(){
        System.out.println("Square");
    }
}
class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphicsInterface{
    public void drawLine(){
        drawRasterLine();
    }
    public void drawSquare(){
        drawRasterSquare();
    }
}
class VectorAdapterFromRaster2 implements VectorGraphicsInterface {
    RasterGraphics raster = new RasterGraphics();
    public void drawLine() {
       raster.drawRasterLine();
    }
    public void drawSquare() {
        raster.drawRasterSquare();
    }
}
