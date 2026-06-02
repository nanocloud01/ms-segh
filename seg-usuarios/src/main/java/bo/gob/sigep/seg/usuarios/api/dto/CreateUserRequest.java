package bo.gob.sigep.seg.usuarios.api.dto;

public record CreateUserRequest(
        String email,
        String name
) {
}
