package com.example.demo.group;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
			List<Group> list = groupService.getGroupList(field, query);
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
	@GetMapping("/dpage/{gid}")
	public String fix(@PathVariable int gid, Model model) {
		Group group = groupService.getGroup(gid);
		model.addAttribute("group", group);
		model.addAttribute("menu", "group");
		return "group/dpage";
		
	}
	@GetMapping("/update/{gid}")
	public String updateForm(@PathVariable int gid, Model model) {
		Group group = groupService.getGroup(gid);
		model.addAttribute("group", group);
		model.addAttribute("menu", "group");
		return "group/update";
	}
	@PostMapping("/update")
	public String updateProc(Group group) {
		groupService.updateGroup(group);
		return "redirect:/group/dpage/" + group.getGid() + "?option=DNI";
	}
	@GetMapping("delete/{gid}")
	public String delete(@PathVariable int gid, Model model) {
		model.addAttribute("gid", gid);
		model.addAttribute("menu", "group");
		return "group/delete";
	}
	@GetMapping("/deleteConfirm/{gid}")
	public String deleteConfirm(@PathVariable int gid ) {
		groupService.deleteGroup(gid);
		return "redirect:/group/gpage";
	}
}
