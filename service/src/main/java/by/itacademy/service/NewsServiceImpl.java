package by.itacademy.service;

import by.itacademy.entity.News;
import by.itacademy.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Override
    public List<News> getAllNews() {
        return (List<News>) newsRepository.findAll();
    }
}
