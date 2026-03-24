package com.parcial.mathservice.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FibwinService {

    public String buildOutput(int n) {
        List<Long> fibonacciSeries = fibonacciUpTo(n);
        List<Long> rollingWindow = rollingWindowK3(fibonacciSeries);

        String seriesText = fibonacciSeries.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        String windowText = rollingWindow.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        return "serie: " + seriesText + " | ventana: " + windowText;
    }

    private List<Long> fibonacciUpTo(int n) {
        List<Long> series = new ArrayList<>(n + 1);
        series.add(0L);
        series.add(1L);

        for (int i = 2; i <= n; i++) {
            long next = series.get(i - 1) + series.get(i - 2);
            series.add(next);
        }

        return series;
    }

    private List<Long> rollingWindowK3(List<Long> numbers) {
        List<Long> windowSums = new ArrayList<>();

        for (int i = 0; i <= numbers.size() - 3; i++) {
            long sum = numbers.get(i) + numbers.get(i + 1) + numbers.get(i + 2);
            windowSums.add(sum);
        }

        return windowSums;
    }
}
