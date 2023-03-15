package lld.backend_patterns.repository.template;

import java.sql.SQLException;
import java.util.List;

public class Service<T> {
    private Repository<T> repository;
    public Service(Repository repository){
        this.repository=repository;
    }
    public void add(T entity) throws SQLException {
        repository.add(entity);
    }
    public void remove(T entity) throws SQLException {
        repository.remove(entity);
    }
    public T getById(String id){
        return repository.getById(id);
    }
    public List<T> getAll(){
        return repository.getAll();
    }
}
