package by.itacademy.service;

import by.itacademy.dto.SaveSeriesDto;
import by.itacademy.entity.Series;

import java.util.List;

/**
 * @author kirylhrybouski
 */
public interface SeriesService {

    List<Series> getAllSeries();

    void createNewSeries(SaveSeriesDto series);
}
