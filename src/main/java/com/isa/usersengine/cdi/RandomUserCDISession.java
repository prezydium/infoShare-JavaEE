package com.isa.usersengine.cdi;

import com.isa.usersengine.domain.User;
import com.isa.usersengine.repository.UsersRepository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Random;


@SessionScoped
public class RandomUserCDISession implements Serializable, RandomUserCDISessionDao {

    private int randomNumber = new Random().nextInt(UsersRepository.getRepository().size()) ;

    @Override
    public User getRandomUser() {

        return UsersRepository.getRepository()
                .get(randomNumber);
    }
}
