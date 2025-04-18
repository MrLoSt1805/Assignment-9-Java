public class Student {
    private int id;
    private String name;
    private String prn;
    private int age;

    public Student(String name, String prn, int age) {
        this.name = name;
        this.prn = prn;
        this.age = age;
    }

    public Student(int id, String name, String prn, int age) {
        this.id = id;
        this.name = name;
        this.prn = prn;
        this.age = age;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getPrn() { return prn; }
    public int getAge() { return age; }
}
