package com.renovatipoint.webApi.controllers;

import com.renovatipoint.business.abstracts.AdsService;
import com.renovatipoint.business.requests.CreateAdsRequest;
import com.renovatipoint.business.requests.UpdateAdsRequest;
import com.renovatipoint.business.responses.GetAdsByIdResponse;
import com.renovatipoint.business.responses.GetAllAdsResponse;
import com.renovatipoint.business.rules.AdsBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ads")
@AllArgsConstructor
public class AdsController {
    private AdsService adsService;
    private AdsBusinessRules adsBusinessRules;

    @GetMapping
    public List<GetAllAdsResponse> getAllAds(){
        return adsService.getAll();
    }

    @GetMapping("/{id}")
    public GetAdsByIdResponse getAdById(@PathVariable int id){
        return adsService.getById(id);
    }

    @PostMapping("/ad")
    public ResponseEntity<?> add(@RequestBody CreateAdsRequest createAdsRequest) {
        return adsService.add(createAdsRequest);
    }
    @PutMapping("/ad_update/{id}")
    public void update(@RequestBody UpdateAdsRequest updateAdsRequest){
        this.adsService.update(updateAdsRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.adsService.delete(id);
    }
}