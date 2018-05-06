package com.lucadev.coinmarketcap;

import com.lucadev.coinmarketcap.model.CoinMarket;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests the {@link CurrencyTicker}. Includes tests for invalid coins etc..
 *
 * @author Luca Camphuisen < Luca.Camphuisen@hva.nl >
 * @since 7-12-17
 */
public class CurrencyTickerTest {

    /**
     * Should get a valid coin, assumes bitcoin
     */
    @Test
    public void shouldGetValidCoinMarketResponse() {
        long expectedMarket = 1;
        CoinMarket market = CoinMarketCap.ticker(expectedMarket).get();
        assertNotNull(market);
        assertEquals(expectedMarket, market.getId());
    }

    /**
     * What happens when we enter an invalid market.
     */
    @Test
    public void shouldGetNullMarketOnInvalidMarketId() {
        long marketId = -1;
        CoinMarket market = CoinMarketCap.ticker(marketId).get();
        assertNull(market);
    }

}