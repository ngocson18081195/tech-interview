package techbase.interview.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import techbase.interview.entity.Role;
import techbase.interview.entity.Users;
import techbase.interview.repository.RoleRepository;
import techbase.interview.repository.UsersRepository;

import java.util.List;

/**
 * Description:
 * The DataSeeder class.
 * change history:
 * date              person             comments
 * -------------------------------------------------------------------------------
 * 3/2/2021        Ngoc Son           create file
 *
 * @author: Ngoc Son
 * @date: 3/2/2021
 */
@Component
public class DataSeeder {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @EventListener
    public void seed(ContextRefreshedEvent event) {
//        seedUser(10);
    }

    private void seedUser(int numberOfUser) {
        if (0 >= numberOfUser) {
            numberOfUser = 1;
        }
        List<Role> roles = roleRepository.findAll();
        for (int i = 1; i <= numberOfUser; i++) {
            String username = "sonnn" + i;
            Users user = this.usersRepository.findByUsername(username);
            if (null == user && !roles.isEmpty()) {
                user = Users.builder().name("sonnn").isActive(true).username(username)
                        .password(this.passwordEncoder.encode("sonnn@123"))
                        .roleId(roles.get(0).getId()).build();
                this.usersRepository.save(user);
            }
        }
    }
}
