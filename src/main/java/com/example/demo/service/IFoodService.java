package com.example.demo.service;

import com.example.demo.common.IGeneral;
import com.example.demo.model.Category;
import com.example.demo.model.Foods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IFoodService extends IGeneral<Foods> {
    Page<Foods> findByPage(Pageable pageable);
    Page<Foods> findFoodByCategoryContaining (String name, Pageable pageable);
    Page<Foods> findAllByCategory(Category category, Pageable pageable);

    Page<Foods> findFoodsByUsersNotInThat( Long id , Pageable pageable );
    Page<Foods> findFoodsByUsersInThat( Long id , Pageable pageable );

    Page<Foods> findAllByLikeName( String name, Pageable pageable);

    List<Foods> findAllByLikeNameNotUser( Long id , String name );

    Page<Foods> findAllByCategoryNotUser( Long id, Long idC, Pageable pageable);
}
