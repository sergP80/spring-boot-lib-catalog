package ua.edu.chmnu.ki.network.lib.persistence.repository;

import ua.edu.chmnu.ki.network.lib.web.dto.CatalogDTO;

import java.util.List;
import java.util.Optional;

public interface CatalogRepository {
    Optional<CatalogDTO> findById(Integer id);

    List<CatalogDTO> findAll();

    boolean existById(Integer id);

    CatalogDTO save(CatalogDTO catalog);
}
