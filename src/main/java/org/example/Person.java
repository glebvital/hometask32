package org.example;

class Person {
    private String name;
    private int age;
    private String email;

    // Getters and setters (or use Lombok for auto-generation)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person}"+"name='"+name+'\''+", age="+age+", email='"+email+'\''+"}";
    }
}
