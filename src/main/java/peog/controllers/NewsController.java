package peog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peog.CurrentSession;
import peog.entities.Information;
import peog.services.NewsService;
import peog.services.UserService;

import java.sql.Date;
import java.util.Calendar;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private UserService userService;

    @Autowired
    private NewsService newsService;

    @GetMapping
    public String getNewsPage(Model model) {
        model.addAttribute("new_news", new Information());
        model.addAttribute("all_news", newsService.getAllNews());
        return "news";
    }

    @PostMapping("/new")
    public String createNews(@RequestParam("news_information") String information) {
        Information news = new Information(information, new Date(Calendar.DATE), false);
        news.setOwner(CurrentSession.getUser());
        newsService.createNews(news);

        return "redirect:/news";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteNews(@PathVariable Integer id) {
        Information news = newsService.getNewsById(id);
        if (news != null) {
            newsService.deleteNews(news);
        }
        return "redirect:/news";
    }

    @GetMapping(value = "/hideorunhide/{id}")
    public String hideOrUnhide(@PathVariable Integer id) {
        Information news = newsService.getNewsById(id);
        if (news != null) {
            news.setHidden(!news.getHidden());
            newsService.updateNews(news);
        }
        return "redirect:/news";
    }


}
