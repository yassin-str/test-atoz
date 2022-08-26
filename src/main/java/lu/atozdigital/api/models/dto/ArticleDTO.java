package lu.atozdigital.api.models.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
public class ArticleDTO {

    private Long id;
    private String name;
    private double price;
    private byte[] picture;
}
