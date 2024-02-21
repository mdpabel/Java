package Generics;

public class ComparableInterface implements Comparable<ComparableInterface> {
  private int point;

  public ComparableInterface(int point) {
    this.point = point;
  }

  @Override
  public int compareTo(ComparableInterface o) {
    return point - o.point;
  }

}