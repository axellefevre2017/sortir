package com.sortir.sortir.controller;

import com.sortir.sortir.controller.dto.SortieDto;
import com.sortir.sortir.controller.route.site.SiteEditRoute;
import com.sortir.sortir.controller.route.site.SiteRoute;
import com.sortir.sortir.controller.route.ville.VilleEditRoute;
import com.sortir.sortir.controller.route.ville.VilleRoute;
import com.sortir.sortir.entity.Lieu;
import com.sortir.sortir.entity.Site;
import com.sortir.sortir.entity.Ville;
import com.sortir.sortir.repository.LieuRepository;
import com.sortir.sortir.repository.ParticipantRepository;
import com.sortir.sortir.repository.SiteRepository;
import com.sortir.sortir.repository.VilleRepository;
import com.sortir.sortir.service.SortieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SiteController {

    @Autowired
    SortieService sortieService;

    @Autowired
    SiteRepository siteRepository;

    @Autowired
    VilleRepository villeRepository;

    @Autowired
    LieuRepository lieuRepository;

    @Autowired
    ParticipantRepository participantRepository;


    List<String> errors = new ArrayList<>();

    @GetMapping("/site/")
    public String add(Principal principal, Model model){

        SiteRoute route = new SiteRoute();
        model.addAttribute("route",route);
        model.addAttribute("villes",villeRepository.findAll());
        model.addAttribute("user", participantRepository.findByPseudo(principal.getName()));

        model.addAttribute("sites", lieuRepository.findAll());

        return route.getTemplate();
    }

    @PostMapping("/site/")
    public RedirectView addValidation(Principal principal,@RequestParam("site") String siteParam,
                                      @RequestParam("ville") Integer ville,
                                      @RequestParam("rue") String rue,
                                      @RequestParam("latitude") String latitude,
                                      @RequestParam("longitude") String longitude,
                                        Model model, RedirectAttributes ra) throws Exception {

        SiteRoute route = new SiteRoute();
        model.addAttribute("route",route);
        model.addAttribute("user", participantRepository.findByPseudo(principal.getName()));

        Lieu site = new Lieu();
        site.setLibelle(siteParam);

        String newLongitude = longitude.replace(",",".");
        String newLatitude = latitude.replace(",",".");

        site.setLongitude(new Float(newLongitude));
        site.setLatitude(new Float(newLatitude));

        site.setRue(rue);
        site.setVille(villeRepository.getOne(ville));

        if (checkSite(siteParam) && checkIfExist(siteParam)) {
            lieuRepository.save(site);
        } else {
            ra.addFlashAttribute("errors", errors);
        }

        model.addAttribute("sites", lieuRepository.findAll());

        return new RedirectView("/site/");
    }

    @PostMapping("/site/rechercher/")
    public String search(Principal principal,@RequestParam("site") String siteParam,Model model){

        SiteRoute route = new SiteRoute();
        model.addAttribute("route",route);
        model.addAttribute("user", participantRepository.findByPseudo(principal.getName()));
        model.addAttribute("filtre", siteParam);
        model.addAttribute("sites", lieuRepository.findAllByLibelleContaining(siteParam));

        return route.getTemplate();
    }

    @GetMapping("/site/edit/{id}/")
    public String edit(Principal principal,@PathVariable Integer id, Model model){

        SiteEditRoute route = new SiteEditRoute();
        model.addAttribute("user", participantRepository.findByPseudo(principal.getName()));
        model.addAttribute("route",route);
        model.addAttribute("villes",villeRepository.findAll());

        model.addAttribute("site", lieuRepository.findById(id).get());

        return route.getTemplate();
    }

    @PostMapping("/site/edit/{id}/")
    public RedirectView editValidation(Principal principal, @PathVariable Integer id, @RequestParam("site") String site,
                                       @RequestParam("ville") Integer ville,
                                       @RequestParam("rue") String rue,
                                       @RequestParam("latitude") String latitude,
                                       @RequestParam("longitude") String longitude, Model model, RedirectAttributes ra) throws Exception {

        SiteRoute route = new SiteRoute();
        model.addAttribute("route",route);
        model.addAttribute("user", participantRepository.findByPseudo(principal.getName()));

        Lieu site1 = lieuRepository.getOne(id);
        site1.setLibelle(site);
        site1.setVille(villeRepository.getOne(ville));
        site1.setRue(rue);

        String newLongitude = longitude.replace(",",".");
        String newLatitude = latitude.replace(",",".");

        site1.setLongitude(new Float(newLongitude));
        site1.setLatitude(new Float(newLatitude));

        if (checkSite(site)) {
            lieuRepository.save(site1);
        } else {
            ra.addFlashAttribute("errors", errors);
            return new RedirectView("/site/edit/"+id+"/");
        }

        model.addAttribute("sites", lieuRepository.findAll());

        return new RedirectView("/site/");
    }

    @GetMapping("/site/delete/{id}/")
    public RedirectView delete(Principal principal,@PathVariable Integer id, Model model, RedirectAttributes ra) throws Exception {

        SiteRoute route = new SiteRoute();
        model.addAttribute("route",route);
        model.addAttribute("user", participantRepository.findByPseudo(principal.getName()));

        if (checkIfAttached(id)) {
            lieuRepository.deleteById(id);
        } else {
            ra.addFlashAttribute("errors", errors);
        }

        model.addAttribute("sites", lieuRepository.findAll());

        return new RedirectView("/site/");
    }

    public Boolean checkSite(String site) throws Exception {

        //On vide la liste d'erreur
        errors.removeAll(errors);

        if (site == null || site.isEmpty()) {
            errors.add("Le site ne peut pas être vide.");
        }

        if (!errors.isEmpty()) {
            return false;
        } else {
            return true;
        }

    }


    public boolean checkIfExist(String lieu) {

        for (int i = 0; i < lieuRepository.findAll().size(); i++) {
            if (lieuRepository.findAll().get(i).getLibelle().toLowerCase().equals(lieu.toLowerCase())) {
                errors.add("Ce site (" + lieu + ") existe déjà.");
            }
        }

        if (!errors.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean checkIfAttached(Integer id) throws Exception {

        //On vide la liste d'erreur
        errors.removeAll(errors);

        List<SortieDto> sortieList = sortieService.findAll();

        int compteur = 0;

        for (int i = 0; i < sortieList.size(); i++) {

            if (sortieList.get(i).getLieu().getId() == id) {
                compteur = compteur + 1;
            }
        }

        if (compteur == 1) {
            errors.add("Impossible de supprimer ce site. Il est lié à " + compteur + " sortie.");
        }
        if (compteur > 1) {
            errors.add("Impossible de supprimer ce site. Il est lié à " + compteur + " sorties.");
        }

        if (!errors.isEmpty()) {
            return false;
        } else {
            return true;
        }

    }

}
