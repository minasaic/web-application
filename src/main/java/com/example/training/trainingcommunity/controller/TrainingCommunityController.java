package com.example.training.trainingcommunity.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.training.trainingcommunity.model.TrainingCommunity;
import com.example.training.trainingcommunity.service.TrainingCommunityService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/")
public class TrainingCommunityController {

	@Autowired
	private TrainingCommunityService service;

	// ホームページ
	@RequestMapping
	public String home() {
		return "/training-community/home";
	}

	// ユーザー一覧
	@GetMapping("/users/{userPage}")
	public String getTrainingCommunity(@PathVariable Integer userPage, Model model) {
		// List<TrainingCommunity> usersAll = service.getAllUser();
		List<TrainingCommunity> users = service.getUser(userPage);
		for (var user : users) {
			System.out.println(user.getName());
		}
		// レコード数によってページ数を調整する
		int countNum = service.count();
		int p = 0;
		if (countNum % 10 == 0) {
			p = countNum / 10;
		} else if (countNum <= 10) {
			p = 1;
		} else {
			p = countNum / 10 + 1;
		}
		model.addAttribute("p", p);
		model.addAttribute("users", users);
		return "/training-community/users";
	}

	// 新規入力
	@GetMapping("/create")
	public String inputUser(Model model) {
		return "/training-community/create";
	}

	// 新規入力確認
	@PostMapping("/create_confirm")
	public String createUser(
			@RequestParam("userName") String name,
			@RequestParam("userEmail") String email,
			Model model) {
		// File file = new File("1.jpg");
		model.addAttribute("confirmName", name);
		model.addAttribute("confirmEmail", email);
		return "/training-community/create_confirm";
	}

	// 新規登録処理
	@PostMapping("/create_complete")
	public String createCompleteUser(@RequestParam("userName") String name,
			@RequestParam("userEmail") String email,
			Model model) {
		service.createUser(name, email);
		return "redirect:/users/1";
	}

	// 編集入力
	@PostMapping("/update")
	public String updateUser(Model model, @RequestParam Integer id) {
		model.addAttribute("confirmId", id);
		return "/training-community/update";
	}

	// 編集入力確認
	@PostMapping("/update_comfirm")
	public String updateComfirmUser(
			@RequestParam Integer id,
			@RequestParam("userName") String name,
			@RequestParam("userEmail") String email,
			Model model) {
		model.addAttribute("comfirmId", id);
		model.addAttribute("comfirmName", name);
		model.addAttribute("comfirmEmail", email);
		return "/training-community/update_comfirm";
	}

	// 編集登録処理
	@PostMapping("/update_complete")
	public String updateCompleteUser(@RequestParam Integer id, @RequestParam("userName") String name,
			@RequestParam("userEmail") String email,
			Model model) {
		service.updateUser(id, name, email);
		return "redirect:/users/1";
	}

	// 削除確認
	@PostMapping("/delete")
	public String deleteUser(
			@RequestParam("userId") Integer id,
			@RequestParam("userName") String name,
			@RequestParam("userEmail") String email,
			Model model) {
		model.addAttribute("comfirmId", id);
		model.addAttribute("comfirmName", name);
		model.addAttribute("comfirmEmail", email);
		return "/training-community/delete";
	}

	// 削除処理
	@PostMapping("/delete_complete")
	public String deleteCompleteUser(@RequestParam Integer id, Model model) {
		service.deleteUser(id);
		return "redirect:/users/1";
	}
}
