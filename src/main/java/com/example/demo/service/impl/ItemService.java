package com.example.demo.service.impl;

import com.example.demo.model.Cart;
import com.example.demo.model.Item;
import com.example.demo.repository.IItemRepository;
import com.example.demo.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService implements IItemService {

    @Autowired
    private IItemRepository itemRepository;


    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Page<Item> findAllByNameContaining(Pageable pageable, String name) {
        return itemRepository.findAll(pageable);
    }



    @Override
    public void removeById(Long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public List<Item> findItemByCustomerId(Long id) {
        return itemRepository.findItemByUsersId(id);
    }



    // Phần xử lý giỏ hàng


    // Trả sản phẩm ở trong giỏ hàng
    private Item getItemById(Long id, Long idCustomer){
        List<Item> items = findItemByCustomerId(idCustomer);
        for (Item item : items){
            if (item.getProduct().getId().equals(id)){
                return item;
            }
        }
        return null;
    }


    // Thêm vào giỏ hàng
    public void addItem(Item item, Long idCustomer){
        if (getItemById(item.getProduct().getId(), idCustomer) != null){
            // Tìm ra sản phẩm đã có trong giỏ hàng
            Item itemNew = getItemById(item.getProduct().getId(),idCustomer);
            // Tăng số lượng sản phẩm lên mà k thêm sản phẩm cũ vào
            assert itemNew != null;
            itemNew.setQuantity(itemNew.getQuantity() + item.getQuantity());
        }else {
            save(item);
        }
    }
    // Xóa sản phẩm trong giỏ hàng
    public void removeItem(Long id, Long idCustomer){
        if (getItemById(id,idCustomer) != null){
            removeById(id);
        }
    }
    @Override
    public void deleteAllByCart(Cart cart) {
        itemRepository.deleteAllByCart(cart);
    }

}