package lld.moviebooking.service;

import lld.moviebooking.dal.MovieDAL;
import lld.moviebooking.entities.City;
import lld.moviebooking.entities.Movie;
import java.util.List;

public class MovieService {

    public List<Movie> getMoviesByCity(City city){
        return getAllMovies().stream().filter(movie -> hasCity(movie.getCity(),city)).toList();
    }
    private boolean hasCity(List<City> city,City searchCity){
        return !city.stream().filter(city1 ->  city1.getId()==searchCity.getId()).toList().isEmpty();
    }
    public List<Movie> getAllMovies(){
        return MovieDAL.getInstance().getAllMovies();
    }
}
