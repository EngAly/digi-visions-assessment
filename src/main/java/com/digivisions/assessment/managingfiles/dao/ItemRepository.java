package com.digivisions.assessment.managingfiles.dao;

import com.digivisions.assessment.managingfiles.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {

    Optional<Item> findByName(String name);
}
