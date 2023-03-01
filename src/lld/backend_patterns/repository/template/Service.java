package lld.backend_patterns.repository.template;

import java.util.List;

public class Service<T> {
    private Repository<T> repository;
    public Service(Repository repository){
        this.repository=repository;
    }
    public void add(T entity){
        repository.add(entity);
    }
    public void remove(T entity){
        repository.remove(entity);
    }
    public T getById(String id){
        return repository.getById(id);
    }
    public List<T> getAll(){
        return repository.getAll();
    }
}
