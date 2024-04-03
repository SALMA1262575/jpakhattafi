package ma.emsi.jpakhattafi.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.emsi.jpakhattafi.entities.Role;
import ma.emsi.jpakhattafi.entities.User;
import ma.emsi.jpakhattafi.repositories.RoleRepository;
import ma.emsi.jpakhattafi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {

        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = findUserByUserName(username);
        Role role = findRoleByRoleName(roleName);
        if (user!=null && user.getRoles() != null) {
            user.getRoles().add(role);
            role.getUsers().add(user);
            // userRepository.save(user);

        }
    }

    @Override
    public User authenticate(String userName, String password) {
        User user=userRepository.findByUsername(userName);
        if (user==null) throw new RuntimeException("Bad credentials");
        if (user.getPassword().equals(password)) {
            return user;
        }

        throw new RuntimeException("Bad credentials");
    }
}
