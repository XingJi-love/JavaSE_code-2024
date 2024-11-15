// 定义抽象类Shape
abstract class Shape {
    // 定义抽象方法getArea
    public abstract double getArea();
}

// 定义Shape类的子类Rectangle
class Rectangle extends Shape {
    private double width;
    private double height;

    // 构造函数
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // 重写getArea方法计算矩形面积
    public double getArea() {
        return width * height;
    }
}

// 定义Shape类的子类Circle
class Circle extends Shape {
    private double radius;

    // 构造函数
    public Circle(double radius) {
        this.radius = radius;
    }

    // 重写getArea方法计算圆形面积
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

// 定义含有main()方法的主类Main
public class Main {
    public static void main(String[] args) {
        // 创建Shape数组保存2个形状
        Shape[] shapes = new Shape[2];
        shapes[0] = new Rectangle(5, 2);
        shapes[1] = new Circle(1);

        // 计算并输出这些形状的总的面积
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.getArea();
        }
        System.out.println("总的面积是: " + totalArea);
    }
}