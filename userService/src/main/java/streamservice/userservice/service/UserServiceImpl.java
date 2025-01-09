package streamservice.userservice.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import streamservice.userservice.model.User;
import streamservice.userservice.reposiotry.UserRepository;

import java.util.ArrayList;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findFirstByUserName(username);
        if (user == null) {
            throw new RuntimeException("User not found: " + username);
        }
        String name = user.getUserName();
        return new org.springframework.security.core.userdetails.User(
                name,
                user.getPassword(),
                new ArrayList<>()
        );
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
