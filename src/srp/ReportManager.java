package srp;

import java.time.LocalDateTime;
import java.util.List;

public class ReportManager {
    private final List<Integer> data;
    private final ReportSaver saver; // Зависимость от класса сохранения

    public ReportManager(List<Integer> data, ReportSaver saver) {
        this.data = data;
        this.saver = saver;
    }

    public void generateReport() {
        System.out.println("=== Report ===");
        int sum = calculateSum();
        double avg = calculateAverage();
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + avg);
        System.out.println("Generated at: " + LocalDateTime.now());

        saver.saveToFile(sum, avg); // Делегируем сохранение
    }

    private int calculateSum() {
        int sum = 0;
        for (int n : data) sum += n;
        return sum;
    }

    private double calculateAverage() {
        if (data.isEmpty()) return 0;
        return (double) calculateSum() / data.size();
    }
}