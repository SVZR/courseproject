package by.itacademy.service;

import by.itacademy.dto.SaveSeriesDto;
import by.itacademy.entity.Series;
import by.itacademy.entity.Theme;
import by.itacademy.repository.SeriesRepository;
import by.itacademy.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author kirylhrybouski
 */
@Service
@Transactional
public class SeriesServiceImpl implements SeriesService {

    private SeriesRepository seriesRepository;
    private ThemeRepository themeRepository;

    @Autowired
    public SeriesServiceImpl(SeriesRepository seriesRepository, ThemeRepository themeRepository) {
        this.seriesRepository = seriesRepository;
        this.themeRepository = themeRepository;
    }

    @Override
    public List<Series> getAllSeries() {
        return seriesRepository.findAll();
    }

    @Override
    public void createNewSeries(SaveSeriesDto series) {
        Theme one = themeRepository.findOne(series.getThemeId());
        Series saveSeries = new Series();
        saveSeries.setTheme(one);
        saveSeries.setName(series.getSeriesName());
        seriesRepository.save(saveSeries);
    }
}
