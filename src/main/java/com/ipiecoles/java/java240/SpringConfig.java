package com.ipiecoles.java.java240;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;


@Configuration
@PropertySource("classpath:app.properties")
@ComponentScan("com.ipiecoles.java.java240")
public class SpringConfig {
    @Value("${bitcoinService.forceRefresh}")
    boolean forceRefresh;


    //beans
    @Bean(name="bitcoinServiceWithoutCache")
    @Scope("singleton")//Facultatif car scope singleton par défaut
    public BitcoinService bitcoinServiceWithoutCache() {
        BitcoinService bitcoinService = new BitcoinService();
        bitcoinService.setForceRefresh(true);
        //bitcoinService.setWebPageManager(webPageManager());
        return bitcoinService;
    }

    /*
    @Bean(name="bitcoinServiceWithCache")
    public BitcoinService bitcoinServiceWithCache() {
        BitcoinService bitcoinService = new BitcoinService();
        bitcoinService.setForceRefresh(false);
        //bitcoinService.setWebPageManager(webPageManager());
        return bitcoinService;
    }

    /*
    @Bean
    public WebPageManager webPageManager() {
        return new WebPageManager();
    }

    @Bean
    //@Bean(initMethod = "initialiserCatalogue")
    public ProduitManager produitManager(){
        ProduitManager produitManager = new ProduitManager();
        produitManager.setWebPageManager(webPageManager());
        produitManager.setBitcoinService(bitcoinServiceWithCache());
        return produitManager;
    }
    */

}
