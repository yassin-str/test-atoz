package lu.atozdigital.api.endpoints;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lu.atozdigital.api.models.Article;
import lu.atozdigital.api.models.dto.ArticleDTO;
import lu.atozdigital.api.services.ArticleService;
import lu.atozdigital.api.utils.Mapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/articles")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")

public class ArticleEndpoint {

    private final  ArticleService articleService;
    private final Mapper<Article, ArticleDTO> mapper;


    @GetMapping()
    List<ArticleDTO> getAll()
    {

        return  articleService.getAll() .stream()
                .map(a -> mapper.toDTO(a, ArticleDTO.class))
                .collect(Collectors.toList());
    }

    @PostMapping(value="",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ArticleDTO  add(@RequestParam("data") String articleStr,@RequestParam("picture") MultipartFile picture) throws IOException {
        ArticleDTO articleDTO = new ObjectMapper().readValue(articleStr, ArticleDTO.class);

        Article article=new Article();
        article.setName(articleDTO.getName());
        article.setPrice(articleDTO.getPrice());
        article.setPicture(picture.getBytes());



        return mapper.toDTO(articleService.save(article), ArticleDTO.class);
    }
    @GetMapping("/{id}")
    ArticleDTO getArticleById(@PathVariable Long id)
    {
        return mapper.toDTO(articleService.getArticleByID(id), ArticleDTO.class);
    }



}
