package lld.moviebooking.service;

import lld.moviebooking.entities.City;
import lld.moviebooking.entities.Movie;

import java.time.Duration;
import java.util.List;

public class MovieService {

    public List<Movie> getMoviesByCity(City city) {
        return getAllMovies().stream().filter(movie -> hasCity(movie.getReleaseLocation(), city)).toList();
    }

    private boolean hasCity(List<City> city, City searchCity) {
        return !city.stream().filter(city1 -> city1.getId() == searchCity.getId()).toList().isEmpty();
    }

    public List<Movie> getAllMovies() {
        return List.of(new Movie("id","name", Duration.ofHours(2).toMillis(),List.of(new City())));
    }
}
