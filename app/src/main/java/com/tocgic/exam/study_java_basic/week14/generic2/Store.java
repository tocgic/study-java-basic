package com.tocgic.exam.study_java_basic.week14.generic2;

import java.util.List;

public class Store {
    public static void main(String[] args) {
        AppleDao appleDao = new AppleDao();
        appleDao.save(Apple.of(Apple.class, 1));
        appleDao.save(Apple.of(Apple.class, 2));

        List<Apple> all = appleDao.findAll();
        all.forEach(System.out::println);

//        GenericDao<Banana, Integer> bananaDao = new GenericDao<>();
        GenericDao<Banana, Integer> bananaDao = new BananaDao();
        bananaDao.save(Banana.of(1));
        bananaDao.save(Banana.of(2));

        List<Banana> allBanana = bananaDao.findAll();
        allBanana.forEach(System.out::println);

        System.out.println(appleDao.getEntityClass());
    }
}
