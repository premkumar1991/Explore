# last session question


# DTO question
- Q: What is the best practises for DTO objects for 2 or more entity relation?
- A: DTO can have builder pattern to build required inputs if it seems to more combinations
- Q: Is Deserialization of json to builder possible?
- A: Yes, no arg constructor and static builder class is a way for parser.
- Q: Example
A: 
```
>> invoking code on deserialization
ObjectMapper mapper = new ObjectMapper();
Person person = mapper.readValue(jsonString, Person.Builder.class).build();

>> json
{
  "name": "John",
  "age": 30,
  "address": {
    "street": "123 Main St",
    "city": "Anytown",
    "state": "CA",
    "zip": "12345"
  }
}

>> builder
public class Person {
    private String name;
    private int age;
    private Address address;

    private Person(Builder builder) {
        name = builder.name;
        age = builder.age;
        address = builder.address;
    }

    public static class Builder {
        private String name;
        private int age;
        private Address address;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder address(Address address) {
            this.address = address;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    // getters and setters omitted for brevity

    public static class Address {
        private String street;
        private String city;
        private String state;
        private String zip;

        // getters and setters omitted for brevity
    }
}
```

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
    