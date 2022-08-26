package lu.atozdigital.api.services.impl;

import lombok.AllArgsConstructor;
import lu.atozdigital.api.models.Article;
import lu.atozdigital.api.repositories.ArticleRepository;
import lu.atozdigital.api.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleRepository articleRepository;
    @Override
    public Article save( Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article getArticleByID(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    @Override
    public List<Article> getAll() {
        return (List<Article>) articleRepository.findAll();
    }
}
