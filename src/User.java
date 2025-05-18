public class User {
    private String name;
    private String candidateName;
    private int age;
    private String gender;

    public User(String name, String candidateName, int age, String gender) {
        this.name = name;
        this.candidateName = candidateName;
        this.age = age;
        this.gender = gender;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return name + "," + candidateName + "," + age + "," + gender;
    }

    public static User fromString(String userStr) {
        String[] parts = userStr.split(",");
        return new User(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3]);
    }
} 