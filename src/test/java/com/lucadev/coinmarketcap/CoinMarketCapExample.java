package com.lucadev.coinmarketcap;

import com.lucadev.coinmarketcap.model.CoinListing;
import com.lucadev.coinmarketcap.model.CoinMarket;
import com.lucadev.coinmarketcap.model.CoinMarketList;

import java.util.List;

/**
 * Example to show how to use the API. This is not a unit test.
 * @author Luca Camphuisen < Luca.Camphuisen@hva.nl >
 * @since 21-11-17
 */
public class CoinMarketCapExample {

    public static void main(String[] args) {
        CoinMarketList coinMarkets  = CoinMarketCap.ticker().setLimit(5).get();
        coinMarkets.getMarkets().forEach(System.out::println);

        //find a market
        CoinMarket bitcoinMarket = coinMarkets.findMarket("bitcoin");
        System.out.println(bitcoinMarket.getPriceQuotes().get("USD").getPrice());

        System.out.println("Specific Currency:");

        CoinMarket market = CoinMarketCap.ticker(1).get();
        System.out.println(market);

        System.out.println("Listings: ");

        List<CoinListing> listings = CoinMarketCap.listings();
        listings.forEach(System.out::println);
    }

}
