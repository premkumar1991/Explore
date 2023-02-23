package lld.moviebooking.service;

import lld.moviebooking.entities.Movie;
import lld.moviebooking.entities.Screen;
import lld.moviebooking.entities.Show;
import lld.moviebooking.entities.Theatre;

import java.util.List;

public class TheatreService {
    public List<Theatre> getTheatresShowingMovie(Movie movie){
        List<Theatre> theatres=getAllTheatres();
        return theatres.stream().filter(theatre -> hasMoviePlayingInCity(theatre.getMovies(),movie)).toList();
    }
    private boolean hasMoviePlayingInCity(List<Movie> movies,Movie searchMovie){
        return !movies.stream().filter(movie -> movie.getId().equals(searchMovie.getId()) && movie.getCity().equals(searchMovie.getCity())).toList().isEmpty();
    }
    public List<Theatre> getAllTheatres(){
        return List.of(new Theatre());
    }

    public List<Show> getAllShowsByScreen(List<Screen> screens){
        List<Show> shows = List.of(new Show());
        return shows.stream().filter(show -> hasMovieInScreen(screens,show.getScreen())).toList();
    }
    public boolean hasMovieInScreen(List<Screen> screens,Screen searchScreen){
        return !screens.stream().filter(screen -> screen.getId().equals(searchScreen.getId())).toList().isEmpty();
    }
}
