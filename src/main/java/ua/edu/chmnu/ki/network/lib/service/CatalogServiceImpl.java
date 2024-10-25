package ua.edu.chmnu.ki.network.lib.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.edu.chmnu.ki.network.lib.dto.CatalogDTO;
import ua.edu.chmnu.ki.network.lib.error.CatalogException;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    private final List<CatalogDTO> catalogs = new ArrayList<>();

    @PostConstruct
    public void init() {
        catalogs.add(new CatalogDTO(1, "History"));
        catalogs.add(new CatalogDTO(2, "Math"));
        catalogs.add(new CatalogDTO(3, "Detective"));
        catalogs.add(new CatalogDTO(4, "OOP"));
        catalogs.add(new CatalogDTO(5, "Network"));
    }

    @Override
    public CatalogDTO getById(Integer id) {
        if (catalogs.isEmpty()) {
            throw new CatalogException("No catalogs found");
        }

        return catalogs.stream()
                .filter(t -> Objects.equals(t.getId(), id))
                .findFirst()
                .orElseThrow(() -> new CatalogException("Item with id " + id + " not found"));
    }

    @Override
    public List<CatalogDTO> getAll() {
        return catalogs;
    }

    @Override
    public boolean existById(Integer id) {
        return catalogs.stream().anyMatch(t -> Objects.equals(t.getId(), id));
    }

    @Override
    public void create(CatalogDTO catalog) {
        if (this.existById(catalog.getId())) {
            throw new CatalogException("Catalog with id " + catalog.getId() + " already exists");
        }

        catalogs.add(catalog);
    }
}
