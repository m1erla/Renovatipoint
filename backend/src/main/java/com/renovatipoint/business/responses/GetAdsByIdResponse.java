package com.renovatipoint.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAdsByIdResponse {
    private int id;
    private String name;
    private String descriptions;
    private String adReleaseDate;
    private int categoryId;
    private String categoryName;
    private int serviceId;
    private String serviceName;
    private int userId;
    private String userName;

}