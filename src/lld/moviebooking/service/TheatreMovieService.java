package lld.moviebooking.service;


import lld.moviebooking.entities.City;
import lld.moviebooking.entities.Movie;
import lld.moviebooking.entities.ShowScreen;
import lld.moviebooking.entities.Theatre;


import java.time.Duration;
import java.util.List;

public class TheatreMovieService {
    TheatreService theatreService;
    MovieService movieService;
    public TheatreMovieService(TheatreService theatreService, MovieService movieService){
        this.theatreService=theatreService;
        this.movieService=movieService;
    }
    public List<Theatre> getAllTheatresMatchingMovieCities(Movie movie){
        List<Theatre> allTheatres = theatreService.getAllTheatres();
        List<City> moviePlayingCities = movie.getReleaseLocation();
        return allTheatres.
                stream().
                filter(theatre -> isCityMatchingMovie(moviePlayingCities,theatre.getAddress().getCity())).
                toList();
    }
    private boolean isCityMatchingMovie(List<City> cities,City searchCity){
        return !cities.stream().filter(city -> city.getId()==searchCity.getId()).toList().isEmpty();
    }

    // Theatre Movie relation service api, ShowScreen enii
    public List<ShowScreen> getAllShowsInTheatre(Theatre theatre, Movie movie){
        return theatre.
                getScreens().
                stream().
                map(screen ->
                        new ShowScreen(
                                screen.getShow().getId(),
                                screen.getShow().getTime(),
                                screen,
                                theatre,
                                movie
                        )
                ).
                toList();
    }
}
