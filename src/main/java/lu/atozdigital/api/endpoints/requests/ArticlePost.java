package lu.atozdigital.api.endpoints.requests;


import lombok.Data;


@Data
public class ArticlePost {
    private String name;
    private double price;
    private byte[] picture;
}
