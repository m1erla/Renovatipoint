package com.werkspot.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAdsRequest {
    private int id;
    private String adName;
    private String descriptions;
    private String updateAdDate;
    private boolean isActive;
}