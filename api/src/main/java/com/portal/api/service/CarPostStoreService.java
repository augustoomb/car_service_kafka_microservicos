package com.portal.api.service;

import com.portal.api.dto.CarPostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarPostStoreService {

    List<CarPostDTO> getCarForSales(); // GET ALL

    void changeCarForSale(CarPostDTO carPost, String id); // UPDATE

    void removeCarForSale(String id); // DELETE
}
