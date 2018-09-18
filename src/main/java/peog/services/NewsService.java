package peog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peog.entities.Information;
import peog.repositories.InformationRepository;

import java.util.List;

@Service
public class NewsService {

    @Autowired
    private InformationRepository informationRepository;

    public Information createNews(Information information){
        return informationRepository.save(information);
    }

    public Information getNewsById(int id){
        return informationRepository.findById(id).get();
    }

    public List<Information> getAllNews(){
        return informationRepository.findAll();
    }

    public void updateNews(Information information){
        informationRepository.save(information);
    }

    public void deleteNews(Information information){
        informationRepository.delete(information);
    }
}
