package bo.gob.sigep.seg.usuarios.application.dto;

import java.util.UUID;

public record UserSummaryResponse(
        UUID id,
        String email,
        String name
) {
}
