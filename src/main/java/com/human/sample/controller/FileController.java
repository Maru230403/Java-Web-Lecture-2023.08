package com.human.sample.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping("/file")
public class FileController {
	@Value("${spring.servlet.multipart.location}")
	private String uploadDir;

	@GetMapping("/formUpload")
	public String formUpload() {
		return "file/form";
	}
	
	@PostMapping("/formUpload")
	public String formProc(String title, MultipartFile file, Model model) {
		model.addAttribute("title", title);
		String filename = file.getOriginalFilename();
		model.addAttribute("filename", filename);
		String path = uploadDir + "sample/" + filename;
		try {
			file.transferTo(new File(path));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "file/formRes";
	}
	
	@GetMapping("/download/{filename}")
	public ResponseEntity<Resource> fileDownload(@PathVariable String filename) {
		String pathStr = uploadDir + "sample/" + filename;
		Path path = Paths.get(pathStr);
		try {
			String contentType = Files.probeContentType(path);
			HttpHeaders header = new HttpHeaders();
			header.setContentDisposition(
					ContentDisposition.builder("attachment")
						.filename(filename, StandardCharsets.UTF_8).build()
					);
			header.add(HttpHeaders.CONTENT_TYPE, contentType);
			Resource resource = new InputStreamResource(Files.newInputStream(path));
			return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/formUploadMultiple")
	public String formUploadMultiple() {
		return "file/formMutiple";
	} 
	
	@PostMapping("/formUploadMultiple")
	public String formUploadMutipleProc(MultipartHttpServletRequest req, Model model) { 	// (HttpServletRequest req, Model model) 파일이 아닌 데이터를 받으려면 이렇게 사용하면 된다.
		String title = req.getParameter("title"); 											// request안에는 어마어마한 객체가 들어가 있음
		List<MultipartFile> multipartFileList = req.getFiles("files");
		for (MultipartFile part: multipartFileList) {
			
		}
		return "file/fromMultipleRes";
	}
	
}