package com.norrang.mortgageplan;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Component
public class MortgageCalculator implements CommandLineRunner {

    private List<Estimate> estimates = new ArrayList<>();

    public MortgageCalculator() {
        try {

            Reader reader = Files.newBufferedReader(Path.of("prospects.txt"));

            // Use CSVReader to read the attached CSV file, then filter out all invalid lines
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
            var prospects = csvReader.readAll().stream().filter(c -> c.length == 4).toList();

            prospects.stream().forEach(prospect -> {
                try {
                    // If comma separated name, replaces comma with space to make it look better
                    var name = prospect[0];
                    if (name.split(",").length > 0) {
                        name = name.replace(",", " ");
                    }

                    estimates.add(new Estimate(
                            name,
                            Double.parseDouble(prospect[1]),
                            Double.parseDouble(prospect[2]) / 100,
                            Integer.parseInt(prospect[3])
                    ));
                } catch (NumberFormatException e) {
                    System.out.println("Error processing prospect " + prospect[0] + ": " + e.getMessage());
                }
            });

            // Cleanup
            csvReader.close();
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while loading the text file. Error: " + e.getMessage());
        } catch (CsvException e) {
            System.out.println("An error occurred while parsing the CSV file. Error: " + e.getMessage());
        }
    }

    @Override
    public void run(String... args) {
        System.out.println("Printing mortgage estimates loaded from the CSV to terminal\n");

        var counter = 1;
        for (Estimate estimate :
                estimates) {
            System.out.println(
                    "Prospect " + counter + ": " + estimate.getProspectName() + " wants to borrow " + estimate.getLoanSize() +
                            "€ for a period of " + estimate.getDuration() + " years and pay " + estimate.getMonthlyMortgage() + "€ each month"
            );
            counter++;
        }

    }

    public Estimate addEstimate(Estimate estimate) {
        estimate.calculateMonthlyMortgage();
        estimates.add(estimate);
        System.out.println("Estimate for prospect " + estimate.getProspectName() + " that wants to borrow " + estimate.getLoanSize() +
                "€ for a period of " + estimate.getDuration() + " years and pay " + estimate.getMonthlyMortgage() + "€ each month");
        return estimate;
    }

    public List<Estimate> getEstimates() {
        return estimates;
    }
}
