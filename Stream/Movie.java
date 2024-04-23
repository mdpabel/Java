package Stream;

public class Movie {
  private String name;
  private float rating;

  public Movie(String name, float rating) {
    this.name = name;
    this.rating = rating;
  }

  public String getName() {
    return name;
  }

  public float getRating() {
    return rating;
  }

}