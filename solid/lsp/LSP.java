package solid.lsp;

class Rectangle {
    protected int width, height;

    public Rectangle() {
    }
  
    public Rectangle(int width, int height) {
      this.width = width;
      this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public int getArea() {
        return width * height;
    }

    public boolean isSquare()
    {
      return width == height;
    }

    @Override
    public String toString() {
        return "Rectangle{"+
        "width=" + width +
        ", height=" + height +
        '}';
    }
}

class Square extends Rectangle
{

    public Square() {
    }
  
    public Square(int size) {
      width = height = size;
    }

    @Override
    public int getArea() {
        return super.getArea();
    }

    @Override
    public int getHeight() {
        return super.getHeight();
    }

    @Override
    public int getWidth() {
        return super.getWidth();
    }

    @Override
    public void setHeight(int height) {
        super.setWidth(height);
        super.setHeight(height);
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);

    }
    
}

class RectangleFactory
{
  public static Rectangle newSquare(int side)
  {
    return new Rectangle(side, side);
  }

  public static Rectangle newRectangle(int width, int height)
  {
    return new Rectangle(width, height);
  }
}

public class LSP {
 
    static void useIT(Rectangle r) {
        int width = r.getWidth();
        r.setHeight(10);

        System.out.println(
            "Expected area of " + (width * 10) +
            ", got " + r.getArea()
        );
    }

    public static void main(String[] args) {
        Rectangle rc = new Rectangle(10, 10);
        useIT(rc);

        // violates liskov pattern
        Rectangle sq = new Square();
        sq.setWidth(5);
        useIT(sq);

    }
}
