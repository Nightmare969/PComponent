package PComponent_Eva3.PComponent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PComponent_Eva3.PComponent.model.RolesUsuarios;
import PComponent_Eva3.PComponent.repository.RolUsuariosRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class RolesUsuariosService {

    @Autowired
    private RolUsuariosRepository rolUsuariosRepository;

    public List<RolesUsuarios> findAll(){
        return rolUsuariosRepository.findAll();
    }


}
