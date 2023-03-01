package lld.backend_patterns.repository.template;

import java.sql.SQLException;
import java.util.List;

public interface Repository<T>  {
    void add(T entity) throws SQLException;
    void remove(T entity) throws SQLException;
    T update(String id, T entity);
    T getById(String id);
    List<T> getAll();
}
