package lld.backend_patterns.repository.template;

import java.util.List;

public interface Repository<T>  {
    void add(T entity);
    void remove(T entity);
    T update(String id, T entity);
    T getById(String id);
    List<T> getAll();
}
