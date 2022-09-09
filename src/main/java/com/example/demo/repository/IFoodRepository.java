package com.example.demo.repository;

import com.example.demo.model.Category;
import com.example.demo.model.Foods;

import com.example.demo.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IFoodRepository extends JpaRepository<Foods,Long> {

    @Query(value = "select * from foods where name like :name", nativeQuery = true)
    Page<Foods> findAllByLikeName(@Param("name") String name, Pageable pageable);

    @Query(value = "select * from foods join category on category.id = foods.category_id where category.name like :name", nativeQuery = true)
    Page<Foods> findFoodByCategoryContaining (@Param("name") String name, Pageable pageable);


//    @Query(value = "select * from foods where id_cate= :id" , nativeQuery = true);
    Page<Foods> findAllByCategory(Category category, Pageable pageable);

    @Query(value = "select * from foods  where users_id not in ( :id ) ", nativeQuery = true)
    Page<Foods> findFoodsByUsersNotInThat(@Param("id") Long id , Pageable pageable );


    @Query(value = "select * from foods  where users_id  in ( :id ) ", nativeQuery = true)
    Page<Foods> findFoodsByUsersInThat(@Param("id") Long id , Pageable pageable );

    @Query(value = "select * from foods  where users_id not in ( :id ) and name like :name", nativeQuery = true)
    List<Foods> findAllByLikeNameNotUser(@Param("id") Long id ,@Param("name") String name );

    @Query(value = "select * from foods  where users_id not in ( :id ) and id_cate in ( :idC )  ", nativeQuery = true)
    Page<Foods> findAllByCategoryNotUser(@Param("id") Long id,@Param("idC") Long idC, Pageable pageable);
}
