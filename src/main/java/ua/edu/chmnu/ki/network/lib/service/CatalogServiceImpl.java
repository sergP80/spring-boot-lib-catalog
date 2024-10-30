package ua.edu.chmnu.ki.network.lib.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.edu.chmnu.ki.network.lib.error.CatalogException;
import ua.edu.chmnu.ki.network.lib.persistence.repository.CatalogRepository;
import ua.edu.chmnu.ki.network.lib.web.dto.CatalogDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    private final CatalogRepository catalogRepository;

    @Override
    public CatalogDTO getById(Integer id) {

        return catalogRepository.findById(id)
                .orElseThrow(() -> new CatalogException("Item with id " + id + " not found"));
    }

    @Override
    public List<CatalogDTO> getAll() {
        return catalogRepository.findAll();
    }

    @Override
    public boolean existById(Integer id) {
        return catalogRepository.existById(id);
    }

    @Override
    public CatalogDTO create(CatalogDTO catalog) {
        if (this.existById(catalog.getId())) {
            throw new CatalogException("Catalog with id " + catalog.getId() + " already exists");
        }

        return catalogRepository.save(catalog);
    }
}
