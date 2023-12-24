package Control_DZ;

import java.util.*;

public class NotebookFilter {
    private Set<Notebook> notebooks;

    public NotebookFilter(Set<Notebook> notebooks) {
        this.notebooks = notebooks;
    }

    public List<Notebook> filterNotebooks(Map<String, Object> filters) {
        List<Notebook> filteredNotebooks = new ArrayList<>();

        for (Notebook notebook : notebooks) {
            boolean match = true;

            for (Map.Entry<String, Object> entry : filters.entrySet()) {
                String filterProperty = entry.getKey();
                Object filterValue = entry.getValue();

                if (!matchesFilter(notebook, filterProperty, filterValue)) {
                    match = false;
                    break;
                }
            }

            if (match) {
                filteredNotebooks.add(notebook);
            }
        }

        return filteredNotebooks;
    }

    private boolean matchesFilter(Notebook notebook, String filterProperty, Object filterValue) {
        switch (filterProperty) {
            case "brand":
                return notebook.getBrand().equals(filterValue);
            case "model":
                return notebook.getModel().equals(filterValue);
            case "ram":
                return notebook.getRam() == (int) filterValue;
            case "storageCapacity":
                return notebook.getStorageCapacity() == (int) filterValue;
            case "operatingSystem":
                return notebook.getOperatingSystem().equals(filterValue);
            case "color":
                return notebook.getColor().equals(filterValue);
            default:
                return false;
        }
    }
}

