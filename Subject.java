public class Subject {
    private final String id;
    private final String name;

    public Subject(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return id + " " + name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
