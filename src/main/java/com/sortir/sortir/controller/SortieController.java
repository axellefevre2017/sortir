package com.sortir.sortir.controller;

import com.sortir.sortir.controller.route.HomeRoute;
import com.sortir.sortir.controller.route.sortie.SortieAddRoute;
import com.sortir.sortir.controller.route.sortie.SortieEditRoute;
import com.sortir.sortir.entity.Etat;
import com.sortir.sortir.entity.Lieu;
import com.sortir.sortir.entity.Participant;
import com.sortir.sortir.repository.LieuRepository;
import com.sortir.sortir.repository.VilleRepository;
import com.sortir.sortir.service.SortieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class SortieController {

    @Autowired
    SortieService sortieService;

    @Autowired
    LieuRepository lieuRepository;

    @Autowired
    VilleRepository villeRepository;

    @GetMapping("/sortie/add/")
    public String add(Model model) {

        SortieAddRoute route = new SortieAddRoute();
        model.addAttribute("route", route);

        model.addAttribute("sorties", sortieService.findAll());
        model.addAttribute("villes", villeRepository.findAll());
        model.addAttribute("lieux", lieuRepository.findAll());

        return route.getTemplate();
    }

    @PostMapping("/sortie/add/")
    public RedirectView addValidation(@RequestParam("nom") String nom,
                                      @RequestParam("date") String date,
                                      @RequestParam("duree") Integer duree,
                                      @RequestParam("limite") String limite,
                                      @RequestParam("nombre") Integer nbMax,
                                      @RequestParam("description") String infos,
                                      @RequestParam("lieu") Integer lieu,
                                      @RequestParam("etat") Boolean etat,
                                      Model model) throws ParseException {

        HomeRoute route = new HomeRoute();
        model.addAttribute("route", route);

        Integer etatPublication;

        if (etat == true) {
            etatPublication = 3;
        } else {
            etatPublication = 1;
        }

        Date date1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(date);
        Date date2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(limite);

        sortieService.add(nom, date1, duree, date2, nbMax, infos, 1, lieu, etatPublication);

        return new RedirectView("/");
    }

    @GetMapping("/sortie/edit/{id}/")
    public String edit(@PathVariable Integer id, Model model) {

        SortieEditRoute route = new SortieEditRoute();
        model.addAttribute("route", route);


        model.addAttribute("sortie", sortieService.findById(id).get());

        model.addAttribute("villes", villeRepository.findAll());
        model.addAttribute("lieux", lieuRepository.findAll());

        return route.getTemplate();
    }

    @PostMapping("/sortie/edit/{id}/")
    public String editValidation(@PathVariable Integer id, @RequestParam("nom") String nom,
                                 @RequestParam("date") String date,
                                 @RequestParam("duree") Integer duree,
                                 @RequestParam("limite") String limite,
                                 @RequestParam("nombre") Integer nbMax,
                                 @RequestParam("description") String infos,
                                 @RequestParam("lieu") Integer lieu,
                                 @RequestParam("etat") @Nullable Boolean etat, Model model) throws ParseException {

        SortieEditRoute route = new SortieEditRoute();
        model.addAttribute("route", route);


        Integer etatPublication;

        if (etat != null && etat == true) {
            etatPublication = 3;
        } else {
            etatPublication = 1;
        }

        Date date1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(date);
        Date date2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(limite);

        sortieService.edit(id, nom, date1, duree, date2, nbMax, infos, 1, lieu, etatPublication);

        model.addAttribute("sortie", sortieService.findById(id).get());

        model.addAttribute("villes", villeRepository.findAll());
        model.addAttribute("lieux", lieuRepository.findAll());

        return route.getTemplate();
    }

    @GetMapping("/sortie/delete/{id}/")
    public String delete(@PathVariable Integer id, Model model) {

        HomeRoute route = new HomeRoute();
        model.addAttribute("route",route);

        sortieService.delete(id);

        model.addAttribute("sorties", sortieService.findAll());

        return route.getTemplate();
    }


}
