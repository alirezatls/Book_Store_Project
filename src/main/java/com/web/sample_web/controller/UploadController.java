package com.web.sample_web.controller;

import com.web.sample_web.domain.Book;
import com.web.sample_web.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class UploadController {

    private final UploadService service;

    @Autowired
    public UploadController(UploadService service) {
        this.service = service;
    }


    @RequestMapping(value = "/upload", method = GET)
    public String uploadPage() {
        return "upload";
    }

    @RequestMapping(value = "/upload", method = POST)
    public String upload(@RequestParam("file") MultipartFile multipartFile, ModelMap map) {
        String url = service.upload(multipartFile);
        map.addAttribute("url", url);
        map.addAttribute("book", new Book());
        return "add_book";
    }


}
