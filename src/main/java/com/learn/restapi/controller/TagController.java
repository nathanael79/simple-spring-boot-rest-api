package com.learn.restapi.controller;

import java.util.List;
import java.util.NoSuchElementException;

import com.learn.restapi.model.Tag;
import com.learn.restapi.service.TagService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("")
    public List<Tag> list()
    {
        return tagService.listAllTag();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tag> get(@PathVariable Integer id) {
        try {
            Tag tag = tagService.getTag(id);
            return new ResponseEntity<Tag>(tag, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Tag>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public void add(@RequestBody Tag tag) {
        tagService.saveTag(tag);;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Tag tag, @PathVariable Integer id) {
        try {
            Tag existTag = tagService.getTag(id);
            existTag.setName(tag.getName()); 
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        tagService.deleteTag(id);
    }
    
}
