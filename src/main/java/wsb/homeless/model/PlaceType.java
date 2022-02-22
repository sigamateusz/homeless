package wsb.homeless.model;

import lombok.Getter;

@Getter
public enum PlaceType {
    RESTAURANT("restauracja"),
    BAR("bar"),
    BISTRO("bistro"),
    LAUNDRIES("pralnia"),
    HOSTEL("hostel"),
    B_AND_B("b&b"),
    ACCOMMODATION("noclegownia"),
    TRANSPORT("firma transportowa"),
    DOCTOR("lekarz"),
    PHARMACY("apteka"),
    HAIRDRESSER("fryzjer"),
    PHYSIOTHERAPIST("fizjoterapeuta");

    private final String text;

    PlaceType(String text) {
        this.text = text;
    }
}