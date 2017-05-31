package br.unipe.tad.service;
import java.util.List;

import br.unipe.tad.entidade.Article;

public interface IArticleService {
     List<Article> getAllArticles();
     Article getArticleById(int articleId);
     boolean addArticle(Article article);
     void updateArticle(Article article);
     void deleteArticle(int articleId);
} 