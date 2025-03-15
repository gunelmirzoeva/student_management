package org.example.controller;

import org.example.dto.GroupDto;
import org.example.entity.Group;
import org.example.service.GroupService;

import java.util.List;

public class GroupController {
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }
    public void createGroup(String name, String description) {
        groupService.createGroup(new GroupDto(name, description));
        System.out.println("Group created successfully");
    }

    public void listGroups() {
        List<GroupDto> groups = groupService.getAllGroups();
        if(groups.isEmpty()) {
            System.out.println("No groups found");
        } else {
            groups.forEach(group -> System.out.println("Name " + group.getName() + " Description " + group.getDescription()));

        }
    }

    public void updateGroup(int id, String name, String description) {
        groupService.updateGroup(id, new GroupDto(name, description));
        System.out.println("Group updated successfully");
    }
    public void deleteGroup(int id) {
        groupService.deleteGroup(id);
        System.out.println("Group deleted successfully");
    }
}
