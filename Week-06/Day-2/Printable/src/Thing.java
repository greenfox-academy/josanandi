public class Thing implements Printable{
    private String name;
    private boolean completed;

    public Thing(String name) {
        this.name = name;
    }

    public void complete() {
        this.completed = true;
    }

    public Thing(String name, boolean completed) {
        this.name = name;
        this.completed = completed;
    }

    @Override
    public String toString() {
        return (completed ? "[x] " : "[ ] ") + name;
    }

    @Override
    public void printAllFields() {
        System.out.println((completed ? "[x] " : "[ ] ") + name);
    }
}