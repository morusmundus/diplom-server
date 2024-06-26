package com.example.server.controller;

import com.example.server.service.AnalyticsService;
import com.example.server.service.ReceiptService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChartController {
    private final AnalyticsService analyticsService;
    private final ReceiptService receiptService;

    @GetMapping("/librarian/statistics/categories-fraction")
    public Object getPieDataCategoryFraction() {
        return analyticsService.getPieDataCategoryFraction();
    }

    @GetMapping("/librarian/statistics/purchases")
    public Object findPurchaseCountForLastSevenDays(
            @RequestParam(name = "days", required = false, defaultValue = "7") int days) {
        return receiptService.findPurchaseCountForLastDays(days);
    }

    @GetMapping("/librarian/statistics/xyz-analisys")
    public Object getXYZAnalisys(
            @RequestParam(name = "date1") String date1,
            @RequestParam(name = "date2") String date2
    ) {
        return analyticsService.getXYZAnalisys(date1, date2);
    }

}
