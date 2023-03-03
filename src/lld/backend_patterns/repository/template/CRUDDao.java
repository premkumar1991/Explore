package lld.backend_patterns.repository.template;

public interface CRUDDao<T> {
    void add(T entity);
    void remove(T entity);
    void update(long id, T entity);
}
