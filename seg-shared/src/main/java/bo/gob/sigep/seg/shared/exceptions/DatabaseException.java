package bo.gob.sigep.seg.shared.exceptions;

import java.sql.SQLException;

public class DatabaseException extends DomainException {

    private final String sqlState;
    private final int vendorCode;

    public DatabaseException(String message, SQLException cause) {
        super(message, "DATABASE_ERROR", "INFRASTRUCTURE", cause);
        this.sqlState = cause.getSQLState();
        this.vendorCode = cause.getErrorCode();
    }

    public String getSqlState() {
        return sqlState;
    }

    public int getVendorCode() {
        return vendorCode;
    }
}