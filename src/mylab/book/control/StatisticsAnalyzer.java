package mylab.book.control;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import mylab.book.entity.*;

public class StatisticsAnalyzer {
    
    public void printStatistics(Publication[] publications) {
        DecimalFormat df = new DecimalFormat("#,###.##");
        
        System.out.println("===== 출판물 통계 분석 =====");
        
        System.out.println("1. 타입별 평균 가격:");
        Map<String, Double> avgPrices = calculateAveragePriceByType(publications);
        System.out.println("소설: " + df.format(avgPrices.getOrDefault("소설", 0.0)) + "원");
        System.out.println("참고서: " + df.format(avgPrices.getOrDefault("참고서", 0.0)) + "원");
        System.out.println("잡지: " + df.format(avgPrices.getOrDefault("잡지", 0.0)) + "원");
        System.out.println(); // 1번과 2번 사이 빈 줄

        System.out.println("2. 출판물 유형 분포:");
        Map<String, Double> distribution = calculatePublicationDistribution(publications);
        System.out.println("소설: " + df.format(distribution.getOrDefault("소설", 0.0)) + "%");
        System.out.println("참고서: " + df.format(distribution.getOrDefault("참고서", 0.0)) + "%");
        System.out.println("잡지: " + df.format(distribution.getOrDefault("잡지", 0.0)) + "%");
        System.out.println(); // 2번과 3번 사이 빈 줄

        double ratio2007 = calculatePublicationRatioByYear(publications, "2007");
        System.out.println("3. 2007년에 출판된 출판물 비율: " + df.format(ratio2007) + "%");
    }

    private Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
        Map<String, Integer> sums = new HashMap<>();
        Map<String, Integer> counts = new HashMap<>();
        for (Publication p : publications) {
            String type = getPublicationType(p);
            sums.put(type, sums.getOrDefault(type, 0) + p.getPrice());
            counts.put(type, counts.getOrDefault(type, 0) + 1);
        }
        Map<String, Double> results = new HashMap<>();
        for (String type : sums.keySet()) {
            results.put(type, (double) sums.get(type) / counts.get(type));
        }
        return results;
    }

    private Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, Integer> counts = new HashMap<>();
        for (Publication p : publications) {
            String type = getPublicationType(p);
            counts.put(type, counts.getOrDefault(type, 0) + 1);
        }
        Map<String, Double> results = new HashMap<>();
        for (String type : counts.keySet()) {
            results.put(type, (double) counts.get(type) / publications.length * 100);
        }
        return results;
    }

    private double calculatePublicationRatioByYear(Publication[] publications, String year) {
        int count = 0;
        for (Publication p : publications) {
            if (p.getPublishDate().startsWith(year)) count++;
        }
        return (double) count / publications.length * 100;
    }

    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) return "소설";
        if (pub instanceof Magazine) return "잡지";
        if (pub instanceof ReferenceBook) return "참고서";
        return "기타";
    }
}