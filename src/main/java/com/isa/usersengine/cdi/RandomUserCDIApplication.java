package com.isa.usersengine.cdi;

import com.isa.usersengine.domain.User;
import com.isa.usersengine.repository.UsersRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Random;

@ApplicationScoped
public class RandomUserCDIApplication implements RandomUserCDIApplicationDao {

    private int randomNumber = new Random().nextInt(UsersRepository.getRepository().size()) ;

    @Override
    public User getRandomUser() {

        return UsersRepository.getRepository()
                .get(randomNumber);
    }
}
