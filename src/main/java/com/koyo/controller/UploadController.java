package com.koyo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koyo.model.User;
import com.koyo.model.UserFiles;
import com.koyo.repository.UserRepository;
import com.koyo.service.UserService;

@Controller
public class UploadController {

    //Save the uploaded file to this folder
//    private static String UPLOADED_FOLDER = "";

    @Autowired private UserService userService;
    
    @GetMapping(value="/")
    public String users (Model model) {
    	List<User> users = userService.getAllUsers();
    	model.addAttribute("users", users);
    	model.addAttribute("user", new User());
    	model.addAttribute("userfiles", new ArrayList<UserFiles>() );
    	model.addAttribute("isAdd",true);
    	return "view/user";
//    @GetMapping("/")
//    public String index() {
//        return "upload";
    }
    
    @PostMapping(value="/save")
    public String save(@ModelAttribute User user, RedirectAttributes redirectAttributes, Model model) {
    	User dbUser = userService.save(user);
    	if(dbUser != null) {
    		redirectAttributes.addFlashAttribute("successmessage", "User is saved successfully");
    		return "redirect:/";
    	}else {
    		model.addAttribute("user", user);
    		
    		return "view/user";
    	}
    	
    }

//    @PostMapping("/upload")
//    public String singleFileUpload(@RequestParam("file") MultipartFile file,
//                                   RedirectAttributes redirectAttributes) {
//
//        if (file.isEmpty()) {
//            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
//            return "redirect:uploadStatus";
//        }
//
//        try {
//
//         
//            byte[] bytes = file.getBytes();
//            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
//            Files.write(path, bytes);
//
//            redirectAttributes.addFlashAttribute("message",
//                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return "redirect:/uploadStatus";
//    }
//
//    @GetMapping("/uploadStatus")
//    public String uploadStatus() {
//        return "uploadStatus";
//    }
    
    

}