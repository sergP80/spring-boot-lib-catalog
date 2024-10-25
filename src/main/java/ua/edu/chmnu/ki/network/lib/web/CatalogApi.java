package ua.edu.chmnu.ki.network.lib.web;

import ua.edu.chmnu.ki.network.lib.dto.CatalogDTO;

import java.util.List;

public interface CatalogApi {

    CatalogDTO getById(Integer id);

    List<CatalogDTO> getAll();

    void add(CatalogDTO catalog);
}
