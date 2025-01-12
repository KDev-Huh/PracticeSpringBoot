package com.example.practice.Controller;

import com.example.practice.Entity.Item;
import com.example.practice.Repository.ItemRepository;
import com.example.practice.Service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemRepository itemRepository;
    private final ItemService itemService;

    @GetMapping("/list")
    String list(Model model) {
        List<Item> result = itemService.findAll();
        model.addAttribute("items", result);
        return "list.html";
    }

    @GetMapping("/write")
    String write() {
        return "write.html";
    }

    @PostMapping("/add")
    String writePost(@RequestParam String title, @RequestParam Integer price) {
        // String writePost(@ModelAttribute Item newItem) {
        itemService.saveItem(title, price);
        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    String detail(@PathVariable Long id, Model model) {
        System.out.println(id);
        Optional<Item> result = itemRepository.findById(id);
        if (result.isPresent()){
            System.out.println(result.get());
            model.addAttribute("item", result.get());
            return "detail.html";
        } else {
            return "~~~";
        }
    }
    //ItemController.java
    @GetMapping("/edit/{id}")
    String edit(@PathVariable Long id, Model model) {
        return "edit.html";
    }
}