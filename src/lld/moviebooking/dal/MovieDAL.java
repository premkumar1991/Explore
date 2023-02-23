package lld.moviebooking.dal;


import lld.moviebooking.entities.City;
import lld.moviebooking.entities.DALConfig;
import lld.moviebooking.entities.Movie;

import java.time.Duration;
import java.util.List;

// DAL is good candidate for singleton
// cons; how to keep db config or other config during bootstrap
public class MovieDAL {
    DALConfig dalConfig;
    private MovieDAL(){}
    private void setConfig(DALConfig dalConfig){
        this.dalConfig=dalConfig;
    }
    public List<Movie> getAllMovies(){
        // here connection to db/cache/whatever may happen
        return List.of(new Movie("1","Avatar2", Duration.ofHours(2).toMillis(),List.of(new City())));
    }
    private static class MovieDALHelper{
        private static final MovieDAL instance = new MovieDAL();
    }
    public static MovieDAL getInstance(){
        return MovieDALHelper.instance;
    }
}
