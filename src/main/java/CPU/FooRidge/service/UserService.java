package CPU.FooRidge.service;

import CPU.FooRidge.domain.User;
import CPU.FooRidge.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    public List<User> findAllUser(){
        return userRepository.findAll();
    }

    @Transactional
    public User addUser(User user){
        return userRepository.save(user);
    }

    public User login(User user) {
        User loggedUser = userRepository.findByUserEmail(user.getUserEmail());
        if (loggedUser != null && loggedUser.getUserPassword().equals(user.getUserPassword())) {
            return loggedUser;
        } else {
            return null;
        }
    }
}
