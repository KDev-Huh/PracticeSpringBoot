package com.example.practice.Service;

import com.example.practice.Entity.Item;
import com.example.practice.Exception.ItemNotFoundException;
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

    public Item findById(Long id) {
        Optional<Item> result = itemRepository.findById(id);
        if (result.isPresent()) {
            System.out.println(result.get());
            return result.get();
        } else {
            throw new ItemNotFoundException("Can not found");
        }
    }

    public void editItem(Long id, String title, Integer price){
        Item editedItem = new Item();
        editedItem.setId(id);
        editedItem.setTitle(title);
        editedItem.setPrice(price);
        itemRepository.save(editedItem);
    }
}
