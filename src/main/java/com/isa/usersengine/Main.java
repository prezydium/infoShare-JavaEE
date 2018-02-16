package com.isa.usersengine;

import com.isa.usersengine.dao.UsersRepositoryDao;
import com.isa.usersengine.dao.UsersRepositoryDaoBean;
import com.isa.usersengine.domain.User;
import com.isa.usersengine.repository.UsersRepository;

public class Main {
    public static void main(String[] args) {
        System.out.println("HELLO WORLD!!!");


        UsersRepositoryDao usersRepositoryDaoBean = new UsersRepositoryDaoBean();
        User testUser = usersRepositoryDaoBean.getUserByLogin("ano");
        System.out.println(testUser.getName() +"\n\n");

        UsersRepository.getRepository().forEach(x -> System.out.println(x.getName()));

    }
}
