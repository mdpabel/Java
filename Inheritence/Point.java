package Inheritence;

import java.util.Objects;

public class Point {
  private int x;
  private int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }


 
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;

    if (!(obj instanceof Point)) {
      return false;
    }

    var other = (Point) obj; // Downcasting

    return x == other.x && y == other.y;
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }



  @Override
  public String toString() {
    return "(" + x + "," + y + ")";
  }
  
}
