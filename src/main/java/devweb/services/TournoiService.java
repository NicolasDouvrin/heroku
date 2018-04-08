package devweb.services;

import devweb.dao.ArticleDao;
import devweb.dao.TournoiDao;

public class TournoiService {

    private static class TournoiServiceHolder {
        private static TournoiService instance = new TournoiService();
    }

    public static TournoiService getInstance() {

        return TournoiService.TournoiServiceHolder.instance;
    }

    private TournoiService() {
    }

    private TournoiDao tournoiDao = new TournoiDao();

    public void startTournoi(Integer nbPlace, String type){

        tournoiDao.startTournoi(nbPlace, type);
    }

    public void initTournoi(){

        tournoiDao.initTournoi();
    }


}
