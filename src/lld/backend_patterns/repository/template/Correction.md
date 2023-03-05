# last session question


# DTO question
- Q: What is the best practises for DTO objects for 2 or more entity relation?
- A: DTO can have builder pattern to build required inputs if it seems to more combinations

# Exceptional handling in DAO, repository, service and controller 
    controller layer
```
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
        try {
            userService.registerUser(userDTO);
            return ResponseEntity.ok().build();
        } catch (UserAlreadyExistsException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
```
    service layer
```
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(UserDTO userDTO) {
        User existingUser = userRepository.findByEmail(userDTO.getEmail());
        if (existingUser != null) {
            throw new UserAlreadyExistsException("User already exists with email " + userDTO.getEmail());
        }

        // code to create and save user to database
    }
}
```
    # repository layer/ dao layer  
```
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email) throws DataAccessException;
}
```
    
    # exception handler
```
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {UserAlreadyExistsException.class})
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value = {DataAccessException.class})
    protected ResponseEntity<Object> handleDataAccessException(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, "Error accessing data", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<Object> handleGeneralException(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, "An unexpected error occurred", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
```

# Flow of events from rest api request to persistent layer 
    Rest controller > Service > Repository > Dao

# Common questions
    how distrubuted joins works and what is the best practises on those joins use cases
    