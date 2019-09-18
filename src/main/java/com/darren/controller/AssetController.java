package com.darren.controller;


import com.darren.domain.Asset;
import com.darren.service.AssetService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Set;

@RestController
@RequestMapping(value = "/asset")
public class AssetController {
    private final AssetService assetService;

    public AssetController(@Qualifier("AssetServiceImpl") AssetService assetService, RestTemplate restTemplate) {
        this.assetService = assetService;
    }

    @PostMapping("/create")
    @ResponseBody
    public Asset create(@RequestBody Asset asset) {
        return assetService.create(asset);
    }

    @PutMapping("/update")
    @ResponseBody
    public Asset update(@RequestBody Asset asset) {
        return assetService.update(asset);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Asset read(@PathVariable String id) {
        return assetService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        assetService.delete(id);
    }

    @GetMapping("/getAll/all")
    @ResponseBody
    public Set<Asset> getAll() {
        return assetService.getAll();
    }
}