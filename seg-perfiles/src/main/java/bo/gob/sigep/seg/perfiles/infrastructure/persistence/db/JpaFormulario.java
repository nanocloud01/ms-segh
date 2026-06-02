package bo.gob.sigep.seg.perfiles.infrastructure.persistence.db;

import bo.gob.sigep.seg.perfiles.domain.model.Formulario;
import bo.gob.sigep.seg.perfiles.domain.repository.FormularioRepository;
import bo.gob.sigep.seg.perfiles.infrastructure.persistence.entity.FormulariosEntity;
import bo.gob.sigep.seg.perfiles.infrastructure.persistence.factory.SpringDataFormularioRepo;
import bo.gob.sigep.seg.perfiles.infrastructure.persistence.mapper.FormularioEntityMapper;
import bo.gob.sigep.seg.shared.exceptions.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaFormulario implements FormularioRepository {

    private final SpringDataFormularioRepo springDataFormularioRepo;
    private final FormularioEntityMapper  formularioEntityMapper;

    public JpaFormulario(SpringDataFormularioRepo springDataFormularioRepo, FormularioEntityMapper formularioEntityMapper) {
        this.springDataFormularioRepo = springDataFormularioRepo;
        this.formularioEntityMapper = formularioEntityMapper;
    }

    @Override
    public Formulario save(Formulario formulario) {
        FormulariosEntity entity = formularioEntityMapper.toEntity(formulario);
         entity = springDataFormularioRepo.save(entity);
        return formularioEntityMapper.toDomain(entity);

    }

    @Override
    public Formulario findById(Long id) {
        var reg = springDataFormularioRepo.findById(id);
        if (reg.isPresent()) {
            return formularioEntityMapper.toDomain(reg.get());
        }else {
            throw new NotFoundException( "Formulario ", id.toString());
        }
    }

    @Override
    public List<Formulario> findAll() {
        return springDataFormularioRepo.findAll()
                .stream()
                .map(formularioEntityMapper::toDomain)
                .toList();
    }

    @Override
    public Page<Formulario> findAllByPaterno(String paterno, Pageable pageable) {
        Page<FormulariosEntity> allByPaterno = springDataFormularioRepo.buscarConFiltro(paterno, pageable);
        return allByPaterno.map(formularioEntityMapper::toDomain);
    }

    @Override
    public void deleteById(Long id) {
        var reg = springDataFormularioRepo.findById(id);
        if (reg.isPresent()) {
            springDataFormularioRepo.deleteById(id);
        }else {
            throw new NotFoundException( "Formulario ", id.toString());
        }
    }

    @Override
    public boolean existsById(Long id) {
         var reg = springDataFormularioRepo.findById(id);
        return reg.isPresent();
    }

    @Override
    public boolean existeRegistro(Formulario formulario) {
        return false;
    }

}
