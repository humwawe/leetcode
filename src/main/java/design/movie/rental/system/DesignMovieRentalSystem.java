package design.movie.rental.system;

import java.util.*;

/**
 * @author hum
 */
public class DesignMovieRentalSystem {
    Map<Long, Movie> idToMovie;
    TreeSet<Movie> rent = new TreeSet<>(Comparator.<Movie>comparingInt(x -> x.price).thenComparingInt(x -> x.shop).thenComparingInt(x -> x.movie));
    Map<Integer, TreeSet<Movie>> available = new HashMap<>();

    private long genId(int s, int m) {
        return (long) 1e9 * s + m;
    }

    private long genId(Movie m) {
        return genId(m.shop, m.movie);
    }

    private TreeSet<Movie> getGivenMovie(int type) {
        TreeSet<Movie> res = available.get(type);
        if (res == null) {
            res = new TreeSet<>(Comparator.<Movie>comparingInt(x -> x.price).thenComparingInt(x -> x.shop));
            available.put(type, res);
        }
        return res;
    }

    public DesignMovieRentalSystem(int n, int[][] entries) {
        idToMovie = new HashMap<>(n);
        for (int[] entry : entries) {
            Movie movie = new Movie();
            movie.shop = entry[0];
            movie.movie = entry[1];
            movie.price = entry[2];
            idToMovie.put(genId(movie), movie);
            getGivenMovie(movie.movie).add(movie);
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> ans = new ArrayList<>(5);
        for (Movie m : getGivenMovie(movie)) {
            if (ans.size() == 5) {
                break;
            }
            ans.add(m.shop);
        }
        return ans;
    }

    public void rent(int shop, int movie) {
        Movie m = idToMovie.get(genId(shop, movie));
        rent.add(m);
        getGivenMovie(movie).remove(m);
    }

    public void drop(int shop, int movie) {
        Movie m = idToMovie.get(genId(shop, movie));
        rent.remove(m);
        getGivenMovie(movie).add(m);
    }

    public List<List<Integer>> report() {
        List<List<Integer>> ans = new ArrayList<>(5);
        for (Movie m : rent) {
            if (ans.size() == 5) {
                break;
            }
            ans.add(Arrays.asList(m.shop, m.movie));
        }
        return ans;
    }
}

class Movie {
    int price;
    int movie;
    int shop;
}
