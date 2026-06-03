package bo.gob.sigep.seg.usuarios.application.readmodel;

import bo.gob.sigep.seg.usuarios.application.dto.UserResponse;
import bo.gob.sigep.seg.usuarios.application.dto.UserSummaryResponse;

import java.util.List;
import java.util.UUID;

public interface UserReadRepository {

    UserResponse findById(UUID id);

    List<UserSummaryResponse> findAll();

}
