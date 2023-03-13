# Repository and dao pattern
1. Rest controller
   1. Responsible for rest api request and deserialize request
   2. Create/ Inject respective service class
   3. Handle exception from service and convert to respective response status code
2. Service
   1. Responsible for managing repository
   2. Dedicate service and its relevant repository modules mapping happens here
3. Repository
   1. Responsible to create, invoke DAO and cache dao operations results
   2. one to one mapping with DAO operations
   3. All top layer caching, state maintenance  of DAO 
4. DAO
   1. Responsible to prepare respective domain model from operation results
   2. DAO operations are access to underlying persistent layer.
   3. Persistent layer may be any storage or cache
5. Persistent layer
   1. Database or cache or any underlying storage


# DAO and Repository separation example
```
public interface UserDao {
    void save(User user);
    void update(User user);
    void delete(User user);
    User findById(long id);
    List<User> findAll();
}

public class JdbcUserDao implements UserDao {
    // implementation details using JDBC
}

public interface UserProfileRepository {
    void createProfile(UserProfile profile);
    void updateProfile(UserProfile profile);
    UserProfile findByUsername(String username);
}

public class UserProfileRepositoryImpl implements UserProfileRepository {
    private UserDao userDao;

    public UserProfileRepositoryImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public void createProfile(UserProfile profile) {
        User user = new User(profile.getUsername(), profile.getPassword());
        userDao.save(user);
    }

    public void updateProfile(UserProfile profile) {
        User user = userDao.findByUsername(profile.getUsername());
        user.setPassword(profile.getPassword());
        userDao.update(user);
    }

    public UserProfile findByUsername(String username) {
        User user = userDao.findByUsername(username);
        if (user != null) {
            return new UserProfile(user.getUsername(), user.getPassword());
        } else {
            return null;
        }
    }
}

Repository manages domain object built from dao, processing DTO
DAO works on perisitence layer

UserProfile is  DTO managed in repository and invokes DAO after processing DTO
```


# Exception handling responsibilities in all layer controller, service, repository and dao
Common exceptions 
   - service quality exception - service not able to process the request
   - data quality exception - request input is not valid
   - transient exception - network failure on server

