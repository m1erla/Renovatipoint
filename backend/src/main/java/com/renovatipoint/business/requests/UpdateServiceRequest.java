package com.renovatipoint.business.requests;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateServiceRequest {
    private int id;
    private String name;
    private String categoryName;
    private int categoryId;
    private String jobTitleName;
    private int jobTitleId;
    private boolean isActive;
}
