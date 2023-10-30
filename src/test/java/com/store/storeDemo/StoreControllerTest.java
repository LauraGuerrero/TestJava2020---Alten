package com.store.storeDemo;

import com.store.storeDemo.controller.StoreController;
import com.store.storeDemo.dto.PricesDtoRequest;
import com.store.storeDemo.dto.PricesDtoResponse;
import com.store.storeDemo.model.Prices;
import com.store.storeDemo.service.PricesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
@SpringBootTest
@AutoConfigureMockMvc
public class StoreControllerTest {
    @InjectMocks
    private StoreController storeController;

    @Mock
    private PricesService pricesService;

    private static final Long idProduct =35455L;
    private static final Long brand=1L;

    @BeforeEach
    public void setup() throws ParseException {
        when(pricesService.getPrices(idProduct, brand, parseDate("2023-10-14 10:00:00"))).thenReturn(createPrice());
        when(pricesService.getPrices(idProduct, brand, parseDate("2023-10-14 16:00:00"))).thenReturn(createPrice());
        when(pricesService.getPrices(idProduct, brand, parseDate("2023-10-14 21:00:00"))).thenReturn(createPrice());
        when(pricesService.getPrices(idProduct, brand, parseDate("2023-10-15 10:00:00"))).thenReturn(createPrice());
        when(pricesService.getPrices(idProduct, brand, parseDate("2023-10-16 21:00:00"))).thenReturn(createPrice());
    }
    @Test
    public void test1410() throws Exception {
        PricesDtoResponse response = storeController.getPrice(createRequest("2023-10-14 10:00:00"));
        assertResponse(response);
    }

    @Test
    public void test1416() throws Exception {
        PricesDtoResponse response = storeController.getPrice(createRequest("2023-10-14 16:00:00"));
        assertResponse(response);
    }

    @Test
    public void test1421() throws Exception {
        PricesDtoResponse response = storeController.getPrice(createRequest("2023-10-14 21:00:00"));
        assertResponse(response);
    }

    @Test
    public void test1510() throws Exception {
        PricesDtoResponse response = storeController.getPrice(createRequest("2023-10-15 10:00:00"));
        assertResponse(response);
    }

    @Test
    public void test1621() throws Exception {
        PricesDtoResponse response = storeController.getPrice(createRequest("2023-10-16 21:00:00"));
        assertResponse(response);
    }

    private Date parseDate(String dateStr) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.parse(dateStr);
    }

    private Prices createPrice() throws ParseException {
        Prices price = new Prices();
        price.setProductId(idProduct);
        price.setBrandId(brand);
        price.setStartDate(parseDate("2023-10-14 10:00:00"));
        return price;
    }

    private PricesDtoRequest createRequest(String startDateStr) throws ParseException {
        PricesDtoRequest request = new PricesDtoRequest();
        request.setProductId(idProduct);
        request.setBrandId(brand);
        request.setStartDate(parseDate(startDateStr));
        return request;
    }

    private void assertResponse(PricesDtoResponse response) throws ParseException {
        assertNotNull(response);
        assertEquals(idProduct, response.getProductId());
        assertEquals(brand, response.getBrandId());
        assertEquals(parseDate("2023-10-14 10:00:00"), response.getStartDate());
    }
}
