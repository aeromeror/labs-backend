package co.edu.unal.software_engineering.labs.service;

import co.edu.unal.software_engineering.labs.model.Role;
import co.edu.unal.software_engineering.labs.model.User;
import co.edu.unal.software_engineering.labs.model.UserRole;
import co.edu.unal.software_engineering.labs.pojo.RegisterUserPOJO;
import co.edu.unal.software_engineering.labs.repository.UserRepository;
import co.edu.unal.software_engineering.labs.repository.UserRoleRepository;
import org.springframework.stereotype.Service;


@Service
public class UserService{

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    public UserService( UserRepository userRepository , UserRoleRepository userRoleRepository){
        this.userRepository = userRepository;
        this.userRoleRepository=userRoleRepository;
    }


    public User findByUsername( String username ){
        return userRepository.findByUsername( username );
    }

    public void save( User user ){
        userRepository.save( user );
    }
    public void saveUserRole(User user, Role role){
        //UserRole.UserRolePK urpk=new UserRole.UserRolePK(user,role);
        UserRole us=new UserRole();
        us.setUser(user);
        us.setRole(role);
        userRoleRepository.save(us);
    }

    public boolean isRightUser( RegisterUserPOJO user ){
        boolean correctness = user.getNames( ) != null && user.getPassword( ) != null && user.getUsername( ) != null &&
                user.getSurnames( ) != null;
        if( correctness ){
            correctness = !user.getNames( ).trim( ).isEmpty( )
                    && !user.getPassword( ).trim( ).isEmpty( )
                    && !user.getUsername( ).trim( ).isEmpty( )
                    && !user.getSurnames( ).trim( ).isEmpty( );
        }
        return correctness;
    }

}