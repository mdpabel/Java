package Stream;

import java.util.ArrayList;
import java.util.List;

public class Filter {
  public static void main(String[] args) {
    List<Movie> movies = new ArrayList<>();

    movies.add(new Movie("A", 2));
    movies.add(new Movie("B", 4.2F));
    movies.add(new Movie("A", 2.8F));
    movies.add(new Movie("A", 3.2F));

    // movies.stream().map(movie -> movie.getName()).forEach(name ->
    // System.out.println(name));

    List<List<Integer>> arrayOfNums = new ArrayList<>();

    arrayOfNums.add(List.of(1, 2, 3, 4));
    arrayOfNums.add(List.of(5, 6, 7));

    arrayOfNums.stream().flatMap(nums -> nums.stream()).forEach(num -> System.out.println(num));
  }
}
