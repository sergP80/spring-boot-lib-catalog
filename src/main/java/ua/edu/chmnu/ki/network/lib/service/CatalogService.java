package ua.edu.chmnu.ki.network.lib.service;

import ua.edu.chmnu.ki.network.lib.dto.CatalogDTO;

import java.util.List;

public interface CatalogService {
    CatalogDTO getById(Integer id);

    List<CatalogDTO> getAll();

    boolean existById(Integer id);

    void create(CatalogDTO catalog);
}