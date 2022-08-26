package lu.atozdigital.api.endpoints;


import lombok.AllArgsConstructor;
import lu.atozdigital.api.models.Article;
import lu.atozdigital.api.models.OrderT;
import lu.atozdigital.api.models.dto.ArticleDTO;
import lu.atozdigital.api.models.dto.OrderDTO;
import lu.atozdigital.api.services.OrderService;
import lu.atozdigital.api.utils.AlphaNumeric;
import lu.atozdigital.api.utils.Mapper;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/orders")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class OrderEndpoint {

    private final Mapper<ArticleDTO, Article> mapperArticle;
    private final Mapper<OrderT, OrderDTO> mapperOrder;
    private final OrderService orderService;

    @PostMapping
    public OrderDTO add(@RequestBody List<ArticleDTO> articlesDTO) {
        List<Article> articles = articlesDTO.stream()
                .map(a -> mapperArticle.toDTO(a, Article.class))
                .collect(Collectors.toList());

        LocalDate now = LocalDate.now();

        OrderT order = new OrderT();

        order.setArticles(articles);
        order.setReference(AlphaNumeric.getAlphaNumericString(15));
        order.setDate(java.sql.Date.valueOf(now));

        return mapperOrder.toDTO(orderService.save(order), OrderDTO.class);

    }

    @GetMapping()
    List<OrderDTO> getAll() {

        return orderService.getAll().stream()
                .map(a -> mapperOrder.toDTO(a, OrderDTO.class))
                .collect(Collectors.toList());
    }


}
































