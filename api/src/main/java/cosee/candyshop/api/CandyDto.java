package cosee.candyshop.api;

import lombok.Data;

@Data
class CandyDto {

    private String id;
    private String name;
    private String imageUrl;
    private String producer;
    private Integer price;
}
