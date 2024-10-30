package ua.edu.chmnu.ki.network.lib.persistence.repository;

import org.springframework.stereotype.Repository;
import ua.edu.chmnu.ki.network.lib.web.dto.CatalogDTO;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class CatalogRepositoryImpl implements CatalogRepository {
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
    public Optional<CatalogDTO> findById(Integer id) {
        return catalogs.stream()
                .filter(t -> Objects.equals(t.getId(), id))
                .findFirst();
    }

    @Override
    public List<CatalogDTO> findAll() {
        return catalogs;
    }

    @Override
    public boolean existById(Integer id) {
        return catalogs.stream().anyMatch(t -> Objects.equals(t.getId(), id));
    }

    @Override
    public CatalogDTO save(CatalogDTO catalog) {
        catalogs.add(catalog);
        return catalog;
    }
}
