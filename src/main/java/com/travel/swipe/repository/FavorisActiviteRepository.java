package com.travel.swipe.repository;

import com.travel.swipe.model.FavorisActivite;
import com.travel.swipe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavorisActiviteRepository extends JpaRepository<FavorisActivite, User> {

    FavorisActivite findByUser(User user);
    FavorisActivite findByUserId(Long userId);


}
