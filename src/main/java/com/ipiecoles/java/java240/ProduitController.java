package com.ipiecoles.java.java240;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produits")
public class ProduitController {

    @Autowired
    ProduitRepository produitRepository;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public Iterable<Produit> findAll() {
        return produitRepository.findAll();
    }
}
