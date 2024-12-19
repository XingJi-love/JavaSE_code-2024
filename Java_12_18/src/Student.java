public class Student {
    private String name;
    private String sex;
    private String community;
    private String intro;

    public Student(String name, String sex, String community, String intro) {
        this.name = name;
        this.sex = sex;
        this.community = community;
        this.intro = intro;
    }

    @Override
    public String toString() {
        return name + " " + sex + " " + community + " " + intro;
    }
}