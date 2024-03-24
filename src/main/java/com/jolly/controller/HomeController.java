package com.jolly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jolly.model.Item;
import com.jolly.service.IItemService;

@Controller
public class HomeController {
	
	@Autowired
	private IItemService iItemService;
	
	@GetMapping("/")
	public String goHome() {
		return "redirect:/home";
	}
	
	@GetMapping("/home")
	public String goHome(Model model) {
		model.addAttribute("items", iItemService.getAllItems());
		return "home";
	}

	@GetMapping("/admin")
	public String goHomeAdmin(Model model) {
		model.addAttribute("items", iItemService.getAllItems());
		return "admin";
	}

	@GetMapping("/admin/new")
	public String createItem(Model model) {
		Item item = new Item();
		model.addAttribute("item", item);
		return "create_item";
	}

	@PostMapping("/admin")
	public String saveItem(@ModelAttribute("item") Item item) {
		iItemService.saveItem(item);
		return "redirect:/admin";
	}

	@GetMapping("/admin/edit/{id}")
	public String editItemForm(@PathVariable Long id, Model model) {
		model.addAttribute("item", iItemService.getItemById(id));
		return "edit_item";
	}

	@PostMapping("/admin/{id}")
	public String updateItem(@ModelAttribute("item") Item item) {
		iItemService.updateItem(item);
		return "redirect:/admin";
	}
	
	@GetMapping("/admin/{id}")
	public String deleteItem(@PathVariable Long id ) {
		iItemService.deleteItem(id);
		return "redirect:/admin";
	}
	
	@GetMapping("/home/item/{id}")
	public String getItem(@PathVariable Long id, Model model) {
		model.addAttribute("item", iItemService.getItemById(id));
		return "item";
	}

}
