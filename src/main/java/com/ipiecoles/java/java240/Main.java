package com.ipiecoles.java.java240;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    //dans le main, on ne peut pas faire d'autowired

    public static void main(String[] args) throws IOException {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);

        ProduitManager pm = ctx.getBean(ProduitManager.class);
        //ProduitManager pm = new ProduitManager();
        /*
        Optimisation de code : un seul BitcoinService créé (un qui gère le cache et un autre sans cache) :
        BitcoinService bitcoinServiceWithCache = new BitcoinService();
        bitcoinServiceWithCache.setForceRefresh(false);
        */

        /*
        BitcoinService bitcoinServiceWithoutCache = ctx.getBean(BitcoinService.class);
        Est équivalent à (s'il n'y a qu'un bean --> quand on a bitcoinServiceWithCache et bitcoinServiceWithoutCache,
        on doit utiliser la syntaxe ci-dessous) :
        */
        BitcoinService bitcoinServiceWithoutCache = ctx.getBean("bitcoinServiceWithoutCache", BitcoinService.class);
        /*
        BitcoinService bitcoinServiceWithoutCache = new BitcoinService();
        bitcoinServiceWithoutCache.setForceRefresh(true);
        */
        //BitcoinService bitcoinServiceWithCache = ctx.getBean("bitcoinServiceWithCache", BitcoinService.class);
        /*Optimisation du code : on crée dans le main :
        WebPageManager webPageManager = new WebPageManager();
        */
        //WebPageManager webPageManager = ctx.getBean(WebPageManager.class);

        /*
        Optimisation de code : grâce aux setters créés :
        pm.setBitcoinService(bitcoinServiceWithCache);
        pm.setWebPageManager(webPageManager);
        */

        //bitcoinServiceWithoutCache.setWebPageManager(webPageManager);
        //bitcoinServiceWithCache.setWebPageManager(webPageManager);

        System.out.println("Bienvenue !");
        while(true){
            System.out.println("Vous souhaitez : ");
            System.out.println("1 - Connaître le cours du bitcoin");
            System.out.println("2 - Ajouter un produit au catalogue");
            System.out.println("3 - Voir tous les produits du catalogue");
            System.out.println("4 - Voir les détails d'un produit");
            System.out.println("5 - Initialiser le catalogue");
            System.out.println("0 - Quitter");

            Scanner scanner = new Scanner(System.in);
            int saisie = scanner.nextInt();
            switch (saisie){
                case 1:
                    System.out.println("1 BTC = " + bitcoinServiceWithoutCache.getBitcoinRate() + " €");
                    break;
                case 2:
                    pm.ajouterProduit();
                    break;
                case 3:
                    pm.afficherTousLesProduits();
                    break;
                case 4:
                    System.out.println("Quel numéro de produit ?");
                    pm.afficherDetailProduit(scanner.nextInt());
                    break;
                case 5:
                    pm.initialiserCatalogue();
                    break;
                case 0:
                    System.out.println("Au revoir !");
                    return;
            }
        }
    }
}
