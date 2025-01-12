package com.example.practice.Service;

import com.example.practice.Entity.Item;
import com.example.practice.Repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public void saveItem(String title, Integer price){
        Item newItem = new Item();
        newItem.setTitle(title);
        newItem.setPrice(price);
        itemRepository.save(newItem);
    }

    public List<Item> findAll() {
        List<Item> result = itemRepository.findAll();
        System.out.println(result);
        return result;
    }

    public Optional<Item> findById(Long id) {
        Optional<Item> result = itemRepository.findById(id);
        if (result.isPresent()) {
            return result;
        } else {
            throw new Exception("Can not found");
        }
    }
}
