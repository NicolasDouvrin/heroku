package devweb.services;

import devweb.dao.ArticleDao;
import devweb.entities.Article;

import java.util.List;

public class ArticleService {


    private static class ArticleServiceHolder {
        private static ArticleService instance = new ArticleService();
    }

    public static ArticleService getInstance() {
        return ArticleServiceHolder.instance;
    }

    private ArticleService() {
    }

    private ArticleDao articleDao = new ArticleDao();

    public List<Article> listArticles() {
            return articleDao.listArticles();
    }

    public void addArticle(Article article) {
        if (article == null) {
            throw new IllegalArgumentException("The article should not be null.");
        }
        if (article.getTitre() == null || "".equals(article.getTitre())) {
            throw new IllegalArgumentException("A article must have a title.");
        }
        if (article.getImage() == null || "".equals(article.getImage())) {
            throw new IllegalArgumentException("A article must have an image.");
        }
        if (article.getTexte() == null || "".equals(article.getTexte())) {
            throw new IllegalArgumentException("A article must have an text.");
        }

        articleDao.addArticle(article);
    }

    public void delArticle(Integer idArticle){

        articleDao.delArticle(idArticle);
    }

}

