package bo.gob.sigep.seg.usuarios.application.commands;

public record CreateUserCommand(
        String email,
        String name
) {
}
