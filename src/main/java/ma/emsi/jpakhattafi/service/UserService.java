package ma.emsi.jpakhattafi.service;

import ma.emsi.jpakhattafi.entities.Role;
import ma.emsi.jpakhattafi.entities.User;

public interface UserService {
    User addNewUser (User user);
    Role addNewRole (Role role);
    User findUserByUserName(String userName);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String username,String roleName);
    User authenticate (String userName,String password);
}
