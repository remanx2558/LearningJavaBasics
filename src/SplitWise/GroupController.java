package SplitWise;

import java.util.ArrayList;
import java.util.List;

public class GroupController {
    List<Group> groupList;

    GroupController(){
        groupList=new ArrayList<>();
    }


    Group getGroup(String name){
        for(Group group: groupList){
            if(group.getName().equals(name)){
                return group;
            }
        }
        return null;
    }
    void createGroup(String name){
        Group newGroup=new Group(name);
        addGroup(newGroup);
    }

    void createNewGroup(String name, String description, User createdBy){
        Group newGroup=new Group(name);
        newGroup.setDescription(description);
        newGroup.getUsers().add(createdBy);
        addGroup(newGroup);
    }
    void addGroup(Group group){
        groupList.add(group);
    }



    void removeGroup(Group group){
        groupList.remove(group);
    }
}
