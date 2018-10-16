package cosee.candyshop.api;

import lombok.Data;

import java.util.List;

@Data
class CreateRequestDto {

    private String id;
    private String name;
    private String imageUrl;
    private String producer;

    private String kcal;
    private String weightValue;
    private String weightUnit;

    private List<String> ingredients;
    private List<NutrientDto> nutrients;

    @Data
    class NutrientDto {
        private String name;
        private String value;
        private String unit;
    }
}
