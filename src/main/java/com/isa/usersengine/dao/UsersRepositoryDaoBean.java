package com.isa.usersengine.dao;

import com.isa.usersengine.domain.User;
import com.isa.usersengine.repository.UsersRepository;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class UsersRepositoryDaoBean implements UsersRepositoryDao {


    @Override
    public void addUser(User user) {
        UsersRepository.getRepository().add(user);
    }

    @Override
    public User getUserById(int id) {

        return UsersRepository.getRepository()
                .stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .get();
    }

    @Override
    public User getUserByLogin(String login) {

        return UsersRepository.getRepository()
                .stream()
                .filter(x -> x.getLogin().equals(login))
                .findFirst()
                .get();
    }

    @Override
    public List<User> getUsersList() {
        return UsersRepository.getRepository();
    }
}
