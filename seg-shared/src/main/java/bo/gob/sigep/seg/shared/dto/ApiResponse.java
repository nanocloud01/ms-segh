package bo.gob.sigep.seg.shared.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiResponse<T>(
        boolean success,
        String message,
        T data,
        List<String> errors,
        LocalDateTime timestamp,
        String path
) {

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(
                true,
                null,
                data,
                null,
                LocalDateTime.now(),
                null
        );
    }

    public static <T> ApiResponse<T> success(T data, String message) {
        return new ApiResponse<>(
                true,
                message,
                data,
                null,
                LocalDateTime.now(),
                null
        );
    }

    public static <T> ApiResponse<T> error(String message, List<String> errors) {
        return new ApiResponse<>(
                false,
                message,
                null,
                errors,
                LocalDateTime.now(),
                null
        );
    }

    public ApiResponse<T> withPath(String path) {
        return new ApiResponse<>(
                this.success,
                this.message,
                this.data,
                this.errors,
                this.timestamp,
                path
        );
    }
}