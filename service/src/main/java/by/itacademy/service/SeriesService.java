package by.itacademy.service;

import by.itacademy.dao.SeriesDao;
import by.itacademy.entity.Series;

import java.util.List;

public final class SeriesService {

    private static SeriesService instance = null;

    private SeriesService() {}

    public static SeriesService getInstance() {
        if (instance == null) {
            synchronized (SeriesService.class) {
                if (instance == null) {
                    instance = new SeriesService();
                }
            }
        }
        return instance;
    }

    public List<Series> getAllSeriesByCountryId(long countryId) {
        return new SeriesDao().findSeriesByCountryId(countryId);
    }
}
