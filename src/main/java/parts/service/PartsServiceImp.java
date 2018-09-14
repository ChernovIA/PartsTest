package parts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import parts.dao.PartsDAO;
import parts.model.Part;
import parts.utils.Filters;

import java.util.List;

@Service
public class PartsServiceImp implements PartsService {

    @Autowired
    private PartsDAO partsDAO;

    @Override
    public List<Part> getParts(Filters filter, String search, int index) {
        return partsDAO.getAllPartsFromIndex(filter, search, index);
    }

    @Override
    public long getRowCount(Filters filter, String search) {
        return partsDAO.getRowCount(filter, search);
    }

    @Override
    public int getComplectCount() {
        return partsDAO.getComplectCount();
    }

    @Override
    public void addPart(Part part) {
        partsDAO.addPart(part);
    }

    @Override
    public void upDatePart(Part part) {
        partsDAO.upDatePart(part);
    }

    @Override
    public void deletePart(long id) {
        partsDAO.deletePart(id);
    }

    @Override
    public Part getPart(long id) {
        return partsDAO.getPart(id);
    }
}
