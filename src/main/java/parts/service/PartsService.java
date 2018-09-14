package parts.service;

import parts.model.Part;
import parts.utils.Filters;

import java.util.List;

public interface PartsService {

    List<Part> getParts(Filters filter, String search, int index);

    void addPart(Part part);

    void upDatePart(Part part);

    void deletePart(long id);

    Part getPart(long id);

    long getRowCount(Filters filter, String search);

    int getComplectCount();
}
