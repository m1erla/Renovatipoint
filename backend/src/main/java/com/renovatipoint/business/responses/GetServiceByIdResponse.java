package com.renovatipoint.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetServiceByIdResponse {
    private int id;
    private String name;
    private String jobTitleName;
    private int categoryId;
    private String categoryName;
    private boolean isActive;
}
