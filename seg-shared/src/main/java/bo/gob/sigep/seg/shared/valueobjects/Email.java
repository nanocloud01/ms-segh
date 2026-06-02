package bo.gob.sigep.seg.shared.valueobjects;


import bo.gob.sigep.seg.shared.exceptions.ValidacionException;

public record Email(String value) {

    public Email {
        if (value == null || !value.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new ValidacionException("Formato inválido del correo: " + value);
        }
    }

    public String getDomain() {
        return value.substring(value.indexOf('@') + 1);
    }

    public String getLocalPart() {
        return value.substring(0, value.indexOf('@'));
    }
}