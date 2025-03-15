package org.example.entity;

public class Student {
    private int id;
    private String name;
    private String email;
    private int groupId;
    public Student() {

    }
    public Student(int id, String name, String email, int groupId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.groupId = groupId;
    }
    public Student(String name, String email, int groupId) {
        this.name = name;
        this.email = email;
        this.groupId = groupId;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getGroupId() {
        return groupId;
    }
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", email=" + email + ", groupId=" + groupId + "]";
    }
}
