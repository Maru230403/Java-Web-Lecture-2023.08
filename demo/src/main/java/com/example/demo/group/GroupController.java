package com.example.demo.group;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.blog.Blog;
import com.example.demo.blog.BlogService;

@Controller
@RequestMapping("/group")
public class GroupController {
	@Autowired private GroupService groupService;
	
	@GetMapping("/gpage")
	public String gpage(@RequestParam(name="f", defaultValue ="title") String field,
			@RequestParam(name="q", defaultValue ="") String query, 
			Model model) {
			List<Group> list = groupService.getGroupgpage(field, query);
	model.addAttribute("groupGpage",list);
	model.addAttribute("menu", "group");
	model.addAttribute("field", field);
	model.addAttribute("query", query);
	return "group/gpage";
	}
	@GetMapping("/profile")
	public String profileForm(Model model) {
		model.addAttribute("menu", "group");
		return "group/profile";
	}
	@PostMapping("/profile")
	public String profileProc(Group group) {
		groupService.insertGroup(group);
		return "redirect:/group/gpage";
	}
}
