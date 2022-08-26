package lu.atozdigital.api.models.dto;

import lombok.Data;
import lu.atozdigital.api.models.Article;

import java.sql.Date;
import java.util.List;

@Data
public class OrderDTO {

    private Long id;
    private String reference;
    private Date date;
    private List<Article> articles;
}
