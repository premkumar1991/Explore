# services
- get movies showing in the city - done, movie_service alone return all movies matching the input city from client
- get theatres showing the movie with the selected city - done, separate theatre_movie service is created to get computed results from movie and theatre service
- get shows available in the selected theatre - done, mapping entity ShowScreen created to link between show and screen as we don't have show to screen link
- get all seats available for the show - done, theatre will have list of screen and each screen will have seat information
- select seat and book seat for the show - done
  - pre-booking happens first, lock seats for concurrency(various methods are there)
  - actual real booking happens on confirm booking


# learnings 
- controller, service and middleware patterns seems good for scale
- entity should be strict, no other responsibility should be added to it, introduce mapping service and mapping entity when your service needs it
-  getters,setters constructor injection and boilerplate code can be optimised using advance annotation
-  streams, collections api should be practised well 

# Generalisation tips
- Think Theatre as Some Venue, Screen as VenueRooms to make generic abstraction

# next action item
Think how other patterns work and framework are used for scale to avoid boilerplate


# Patterns
  MVC
  Repository
  DTO
  DAO