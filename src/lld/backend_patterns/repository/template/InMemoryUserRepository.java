package lld.backend_patterns.repository.template;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserRepository implements Repository<User> {
    List<User> users;
    public InMemoryUserRepository(){
        users = new ArrayList<>();
    }
    @Override
    public void add(User entity) {
        users.add(entity);
    }

    @Override
    public void remove(User entity) {
        users.remove(entity);
    }

    @Override
    public User update(String id, User entity) {
        final User filteredUser = getById(id);
        if(filteredUser!=null){
            users.remove(filteredUser);
            users.add(entity);
            return filteredUser;
        }
        return null;
    }

    @Override
    public User getById(String id) {
        return users.stream().filter(user -> user.getId()==id).findFirst().orElse(null);
    }

    @Override
    public List<User> getAll() {
        return users;
    }
}
