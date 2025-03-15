package org.example.dto;

public class StudentDto {
    private String name;
    private String email;
    private int groupId;
    public StudentDto() {

    }
    public StudentDto(String name, String email, int groupId) {
        this.name = name;
        this.email = email;
        this.groupId = groupId;
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
        return "StudentDto [name=" + name + ", email=" + email + ", groupId=" + groupId + "]";
    }
}
