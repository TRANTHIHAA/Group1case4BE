package com.example.demo.service.impl;

import com.example.demo.model.Category;
import com.example.demo.model.Foods;
import com.example.demo.repository.IFoodRepository;
import com.example.demo.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService implements IFoodService {
    @Autowired
    private IFoodRepository foodRepository;

//    @Override
//    public Page<Foods> findAll(Pageable pageable) {
//        return foodRepository.findAll(pageable);
//    }

    @Override
    public List<Foods> findAll() {
        return foodRepository.findAll();
    }

    @Override
    public Optional<Foods> findById(Long id) {
        return foodRepository.findById(id);
    }

    @Override
    public Foods save(Foods t) {
        return foodRepository.save(t);
    }

    @Override
    public Page<Foods> findAllByNameContaining(Pageable pageable, String name) {
        return null;
    }


    @Override
    public void removeById(Long id) {
        foodRepository.deleteById(id);
    }


    @Override
    public Page<Foods> findByPage(Pageable pageable) {
        return foodRepository.findAll(pageable);
    }

    @Override
    public Page<Foods> findFoodByCategoryContaining(String name, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Foods> findAllByCategory(Category category, Pageable pageable) {
        return foodRepository.findAllByCategory(category,pageable);
    }

    @Override
    public Page<Foods> findFoodsByUsersNotInThat(Long id, Pageable pageable) {
        return foodRepository.findFoodsByUsersNotInThat(id,pageable);
    }

    @Override
    public Page<Foods> findFoodsByUsersInThat(Long id, Pageable pageable) {
        return foodRepository.findFoodsByUsersInThat(id,pageable);
    }

    @Override
    public Page<Foods> findAllByLikeName(String name, Pageable pageable) {
        return foodRepository.findAllByLikeName("%"+name+"%", pageable);
    }

    @Override
    public List<Foods> findAllByLikeNameNotUser(Long id, String name) {
        return foodRepository.findAllByLikeNameNotUser(id,"%"+name+"%");
    }

    @Override
    public Page<Foods> findAllByCategoryNotUser(Long id, Long idC, Pageable pageable) {
        return foodRepository.findAllByCategoryNotUser(id,idC,pageable);
    }
}
