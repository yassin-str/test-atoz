package lu.atozdigital.api.services;


import lu.atozdigital.api.models.Article;

import java.util.List;

public interface ArticleService {

      Article save(Article article);
      Article getArticleByID(Long id);
      List<Article>  getAll();

}
