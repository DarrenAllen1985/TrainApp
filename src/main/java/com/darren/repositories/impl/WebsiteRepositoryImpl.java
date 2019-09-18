package com.darren.repositories.impl;

import com.darren.domain.Region;
import com.darren.domain.Website;
import com.darren.repositories.WebsiteRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("WebsiteRepository")
public class WebsiteRepositoryImpl implements WebsiteRepository {

    private static WebsiteRepositoryImpl repository = null;
    private Set<Website> website;

    private WebsiteRepositoryImpl(){
        this.website = new HashSet<>();
    }

    private Website findwebsite(String websitename) {
        return this.website.stream()
                .filter(website -> website.getWebsiteName().trim().equals(websitename))
                .findAny()
                .orElse(null);
    }

    public static WebsiteRepositoryImpl getRepository(){
        if (repository == null) repository = new WebsiteRepositoryImpl();
        return repository;
    }


    public Website create(Website website){
        this.website.add(website);
        return website;
    }

    public Website read(final String websitename){
        Website website= findwebsite(websitename);
        return website;
    }

    public void delete(String websitename) {
        Website website = findwebsite(websitename);
        if (website != null) this.website.remove(websitename);
    }

    public Website update(Website website){
        Website toDelete = findwebsite(website.getWebsiteName());
        if(toDelete != null) {
            this.website.remove(toDelete);
            return create(website);
        }
        return null;
    }


    public Set<Website> getAll(){
        return this.website;
    }
}
