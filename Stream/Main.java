package Stream;

import java.util.ArrayList;
import java.util.List;

class Stream {
  public static void main(String[] args) {
    List<Movie> movies = new ArrayList<>();

    movies.add(new Movie("A", 2));
    movies.add(new Movie("B", 4.2F));
    movies.add(new Movie("A", 2.8F));
    movies.add(new Movie("A", 3.2F));

    movies.stream().filter(movie -> movie.getRating() > 3)
        .forEach(movie -> System.out.println(movie.getName()));

  }
}