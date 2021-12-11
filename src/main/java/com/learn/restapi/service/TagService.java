package com.learn.restapi.service;

import java.util.List;

import javax.transaction.Transactional;

import com.learn.restapi.model.Tag;
import com.learn.restapi.repository.TagRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public List<Tag> listAllTag()
    {
        return tagRepository.findAll();
    }

    public void saveTag(Tag tag)
    {
        tagRepository.save(tag);
    }

    public Tag getTag(Integer id)
    {
        return tagRepository.findById(id).get();
    }

    public void deleteTag(Integer id)
    {
        tagRepository.deleteById(id);
    }
    
}
