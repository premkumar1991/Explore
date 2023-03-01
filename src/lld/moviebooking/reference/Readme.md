# Design 1

Here's an example low-level design:

# Classes:
- MovieTicketSystem: main class to control the movie ticket system.
- Movie: a class to represent a movie with details like title, duration, genre, director, etc.
- Theater: a class to represent a theater with details like name, location, number of screens, etc.
- Screen: a class to represent a screen in a theater with details like screen number, capacity, and availability status.
- Customer: a class to represent a customer with details like name, phone number, and email.
- Ticket: a class to represent a movie ticket with details like customer, movie, screen, show time, etc.
- MovieRepository: a class to manage movie data with methods like addMovie, getMovie, deleteMovie, etc.
- TheaterRepository: a class to manage theater data with methods like addTheater, getTheater, deleteTheater, etc.
- ScreenRepository: a class to manage screen data with methods like addScreen, getScreen, deleteScreen, etc.
- TicketRepository: a class to manage ticket data with methods like bookTicket, cancelTicket, getTicket, etc.
# Class relationships:
- MovieTicketSystem uses MovieRepository, TheaterRepository, ScreenRepository, and TicketRepository to manage movies, theaters, screens, and tickets.
- Ticket contains a Customer, Movie, and Screen object.
- Screen contains a Theater object.
# System flow:
- When a customer wants to book a ticket, MovieTicketSystem shows a list of available theaters and movies.
- After the customer selects a movie and theater, MovieTicketSystem shows the available showtimes for the selected movie and theater.
- The customer selects the desired showtime and the number of tickets required.
- MovieTicketSystem checks the availability of the requested screen and the number of tickets.
- If the screen is available and the requested number of tickets is less than or equal to the screen's capacity, MovieTicketSystem creates a Ticket object with customer, movie, screen, showtime, and other details and adds it to the TicketRepository.
- If the screen is not available or the requested number of tickets is greater than the screen's capacity, MovieTicketSystem shows a message to the customer that the screen is not available or the requested number of tickets is not available.
- When a customer wants to cancel a ticket, MovieTicketSystem removes the corresponding Ticket object from TicketRepository.


# Design 2



# reference

Repository pattern
https://learn.microsoft.com/en-us/dotnet/architecture/microservices/microservice-ddd-cqrs-patterns/infrastructure-persistence-layer-design