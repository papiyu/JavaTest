package exam;

class Matrix { // 各种格式的文件最终都被转化为像素矩阵
    // 简化实现，仅作为载体
}

abstract class ImageImp {
    public abstract void doPaint(Matrix m); // 显示像素矩阵 m
}

class WinImp extends ImageImp {
    public void doPaint(Matrix m) { 
        // 模拟调用Windows绘制函数
        System.out.println("Windows系统绘制像素矩阵"); 
    }
}

class LinuxImp extends ImageImp {
    public void doPaint(Matrix m) { 
        // 模拟调用Linux绘制函数
        System.out.println("Linux系统绘制像素矩阵"); 
    }
}

abstract class Image {
    public void setImp(ImageImp imp) {
        this.imp = imp; // (1) 补全：给当前类的imp成员变量赋值
    }
    public abstract void parseFile(String fileName);
    protected ImageImp imp; // (2) 补全：声明ImageImp类型的成员变量（桥接的核心）
}

class BMP extends Image {
    public void parseFile(String fileName) {
        // 模拟解析BMP文件获得像素矩阵m
        Matrix m = new Matrix();
        imp.doPaint(m); // (3) 补全：调用实现类的绘制方法显示矩阵
    }
}

class GIF extends Image {
    public void parseFile(String fileName) {
        Matrix m = new Matrix();
        imp.doPaint(m);
    }
}

class JPEG extends Image {
    public void parseFile(String fileName) {
        Matrix m = new Matrix();
        imp.doPaint(m);
    }
}

public class javaMain {
    public static void main(String[] args) {
        // 在 windows 操作系统上查看 demo.bmp图像文件
        Image image1 = new BMP(); // (4) 补全：创建BMP格式的Image对象
        ImageImp imageImp1 = new WinImp(); // (5) 补全：创建Windows系统的实现对象
        image1.setImp(imageImp1); // (6) 补全：将实现对象桥接到抽象对象
        image1.parseFile("demo.bmp");
    }
}