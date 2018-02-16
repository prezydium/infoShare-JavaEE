package com.isa.usersengine.cdi;

import com.isa.usersengine.domain.User;
import com.isa.usersengine.repository.UsersRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.Random;

@RequestScoped
public class RandomUserCDIRequest implements RandomUserCDIRequestDao {

    private int randomNumber = new Random().nextInt(UsersRepository.getRepository().size()) ;

    @Override
    public User getRandomUser() {

        return UsersRepository.getRepository()
                .get(randomNumber);
    }
}
