package parts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import parts.model.Part;
import parts.model.PartType;
import parts.service.PartsService;
import parts.utils.Filters;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PartsController {

    private PartsService partsService;
    private int partsPerPage;
    private String sort;
    private String search;
    private int page;

    @Autowired
    public PartsController(PartsService partsService, int partsPerPage) {
        this.partsService = partsService;
        this.partsPerPage = partsPerPage;
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String welcomePage() {
        return "redirect:/list";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getPartsListPost(@RequestParam(name = "sort", defaultValue = "ALL") String sort, //вид отбора для сортирвкои
                                   @RequestParam(name = "search", defaultValue = "") String search, //строка поиска
                                   @RequestParam(name = "currentPage", defaultValue = "1") int page, //текущая страница
                                   @RequestParam(name = "change", defaultValue = "0") int change,    // флаг того что мы пришли от addEditPart
                                   Model model) {
        if(change == 1){
            sort = this.sort;
            search = this.search;
            page = this.page;
        }


        List<Part> parts = partsService.getParts(Filters.valueOf(sort),search,page);

        long rowCount = partsService.getRowCount(Filters.valueOf(sort), search);

        List<Integer> pages = new ArrayList<>();
        for(int i = 1; i <= (rowCount/partsPerPage) + ((rowCount%partsPerPage) > 0?1:0); i++){
            pages.add(i);
        }

        int comp = partsService.getComplectCount();

        model.addAttribute("parts", parts);
        model.addAttribute("sort", Filters.valueOf(sort));
        model.addAttribute("search", search);
        model.addAttribute("currentPage", page);
        model.addAttribute("comp", comp);
        model.addAttribute("rowCount", rowCount);
        model.addAttribute("pages", pages);

        this.sort   = sort;
        this.search = search;
        this.page   = page;

        return "list";

    }

    @RequestMapping(value = "/addPart", method = RequestMethod.GET)
    public String AddPart(Model model){

        model.addAttribute("part", new Part());
        model.addAttribute("types", PartType.values());

        return "addEditPart";
    }

    @RequestMapping(value = "/editPart", method = RequestMethod.GET)
    public String EditPart(@RequestParam("id") long id, Model model){

        Part part = partsService.getPart(id);
        model.addAttribute("part", part);
        model.addAttribute("types", PartType.values());

        return "addEditPart";
    }

    @RequestMapping(value = "/addEditPart", method = RequestMethod.POST)
    public String EditPart(@ModelAttribute("part") Part part, @RequestParam("type") String type, Model model){

        part.setType(PartType.valueOf(type));

        if (part.getId() == 0){
            partsService.addPart(part);
        }
        else {
            partsService.upDatePart(part);
        }

        model.addAttribute("change",1);
        return "redirect:/list";
    }

    @RequestMapping(value = "/deletePart", method = RequestMethod.GET)
    public String deletePart(@RequestParam("id") long id, Model model){
        partsService.deletePart(id);
        model.addAttribute("change",1);
        return "redirect:/list";
    }

}
