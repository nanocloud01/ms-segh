package bo.gob.sigep.seg.shared.dto;

import java.util.List;

public record PaginatedResponse<T>(
        List<T> content,
        int page,
        int size,
        long totalElements,
        int totalPages,
        boolean first,
        boolean last,
        boolean empty
) {
    public static <T> PaginatedResponse<T> of(
            List<T> content,
            int page,
            int size,
            long totalElements) {

        int totalPages = (int) Math.ceil((double) totalElements / size);
        boolean first = page == 0;
        boolean last = page >= totalPages - 1;
        boolean empty = content.isEmpty();

        return new PaginatedResponse<>(
                content,
                page,
                size,
                totalElements,
                totalPages,
                first,
                last,
                empty
        );
    }
}