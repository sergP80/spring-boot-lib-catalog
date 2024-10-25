package ua.edu.chmnu.ki.network.lib.error;

public class CatalogException extends RuntimeException {
    public CatalogException() {
    }

    public CatalogException(String message) {
        super(message);
    }

    public CatalogException(String message, Throwable cause) {
        super(message, cause);
    }

    public CatalogException(Throwable cause) {
        super(cause);
    }

    public CatalogException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
