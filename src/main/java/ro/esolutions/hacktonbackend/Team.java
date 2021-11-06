package ro.esolutions.hacktonbackend;

import lombok.Getter;

import java.util.Arrays;

public enum Team {

    Team1("CFR CLUJ", 200, 200, 200, 200, 50, 50),
    Team2("FCSB", 200, 0, 0, 0, 0, 200),
    Team3("UNIVERSITATEA CRAIOVA", 200, 200, 200, 0, 0, 200),
    Team4("FC BOTOSANI", 200, 200, 200, 200, 0, 0),
    Team5("FC VOLUNTARI", 200, 200, 200, 130, 238, 255),
    Team6("FC RAPID 1923", 200, 200, 200, 139, 0, 0),
    Team7("UTA ARAD", 200, 200, 200, 200, 0, 0),
    Team8("FARUL CONSTANTA", 200, 200, 200, 0, 0, 200),
    Team9("FC ARGES", 200, 200, 200, 186, 85, 211),
    Team10("AFC CHINDIA", 200, 0, 0, 0, 0, 200),
    Team11("GAZ METAN", 200, 200, 200, 0, 0, 200),
    Team12("SEPSI OSK", 200, 200, 200, 200, 0, 0),
    Team13("U CRAIOVA 1948", 200, 200, 200, 0, 0, 200),
    Team14("CS MIOVENI", 200, 200, 200, 200, 200, 0),
    Team15("FC DINAMO 1948", 200, 200, 200, 200, 0, 0),
    Team16("ACADEMICA CLINCENI", 200, 200, 200, 0, 0, 200);

    @Getter
    private String name;
    @Getter
    private Integer red1;
    @Getter
    private Integer green1;
    @Getter
    private Integer blue1;
    @Getter
    private Integer red2;
    @Getter
    private final Integer green2;
    @Getter
    private Integer blue2;

    Team(String name, Integer red1, Integer green1, Integer blue1, Integer red2, Integer green2, Integer blue2) {
        this.name = name;
        this.red1 = red1;
        this.green1 = green1;
        this.blue1 = blue1;

        this.red2 = red2;
        this.green2 = green2;
        this.blue2 = blue2;
    }
}
