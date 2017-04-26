package wk.easyonboard.common.typadapter;

import com.google.common.base.Strings;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Created by Luca Welker on 4/26/17.
 */
public class LocaleDateXmlTypeAdapter extends XmlAdapter<String, LocalDate> {
    @Override
    public String marshal(LocalDate v) {
        return v.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    @Override
    public LocalDate unmarshal(String v) {
        if (Strings.isNullOrEmpty(v)) {
            return null;
        } else {
            // Ist es ein gültiges ISO-Format, welches als zusätzliche Info auch noch Stunden enthält? Das tolerieren wir
            // Das Datum wird von der Stundenabgabe gemäß ISO-Standard durch ein 'T' getrennt
            DateTimeFormatter formatter = v.contains("T") ? DateTimeFormatter.ISO_LOCAL_DATE_TIME : DateTimeFormatter.ISO_LOCAL_DATE;

            try {
                return LocalDate.parse(v, formatter);
            } catch (DateTimeParseException e) {
            }
        }

        return null;
    }
}