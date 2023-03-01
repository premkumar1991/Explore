package lld.backend_patterns.repository.template;

public class User {
    private String id;
    private String name;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
    public User(String id,String name){
        this.id=id;
        this.name=name;
    }
}
