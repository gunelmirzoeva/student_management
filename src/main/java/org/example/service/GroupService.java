package org.example.service;

import org.example.dao.GroupDao;
import org.example.dto.GroupDto;
import org.example.entity.Group;
import org.example.exception.EntityNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GroupService {
    private final GroupDao groupDao;

    public GroupService(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    public void createGroup(GroupDto groupDto) {
        Group group = new Group(groupDto.getName(), groupDto.getDescription());
        groupDao.save(group);
    }

    public List<GroupDto> getAllGroups() {
        return groupDao.getAll().stream()
                .map(group -> new GroupDto(group.getName(), group.getDescription()))
                .collect(Collectors.toList());
    }

    public GroupDto getGroupById(int id) {
        Optional<Group> group = groupDao.get(id);
        if (group.isPresent()) {
            return new GroupDto(group.get().getName(), group.get().getDescription());
        } else {
            throw new EntityNotFoundException("Group with ID " + id + " not found");
        }
    }

    public void updateGroup(int id, GroupDto groupDto) {
        Group group = new Group(id, groupDto.getName(), groupDto.getDescription());
        String[] params = { groupDto.getName(), groupDto.getDescription() };
        groupDao.update(group, params);
    }

    public void deleteGroup(int id) {
        Optional<Group> group = groupDao.get(id);
        if (group.isPresent()) {
            groupDao.delete(group.get());
        } else {
            throw new EntityNotFoundException("Group with ID " + id + " not found");
        }
    }

}
