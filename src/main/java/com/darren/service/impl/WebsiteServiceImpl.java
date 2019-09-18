package com.darren.service.impl;

import com.darren.domain.Website;
import com.darren.repositories.ContactRepository;
import com.darren.repositories.WebsiteRepository;
import com.darren.repositories.impl.WebsiteRepositoryImpl;
import com.darren.service.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("WebsiteServiceImpl")
public class WebsiteServiceImpl implements WebsiteService {
    private final WebsiteRepository websiteRepository;

    private WebsiteServiceImpl() {
        this.websiteRepository = WebsiteRepositoryImpl.getRepository();
    }

    /*public static WebsiteServiceImpl getService(){
        if (service == null) service = new WebsiteServiceImpl();
        return service;
    }*/

    @Override
    public Website create(Website website) {
        return this.websiteRepository.create(website);
    }

    @Override
    public Website update(Website website) {
        return this.websiteRepository.update(website);
    }

    @Override
    public void delete(String s) {
        this.websiteRepository.delete(s);
    }

    @Override
    public Website read(String s) {
        return this.websiteRepository.read(s);
    }

    @Override
    public Set<Website> getAll() {
        return this.websiteRepository.getAll();
    }
}
