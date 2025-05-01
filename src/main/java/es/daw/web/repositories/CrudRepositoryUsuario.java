package es.daw.web.repositories;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import es.daw.web.entities.Usuario;
import es.daw.web.exceptions.JPAException;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@RequestScoped
public class CrudRepositoryUsuario implements CrudRepository<Usuario> {


    @Inject
    EntityManager em;

    @Override
    public Set<Usuario> select() throws JPAException {
        String jqpl = "SELECT u FROM Usuario u";
        try {
            List<Usuario> lista = em.createQuery(jqpl, Usuario.class).getResultList();
            return new HashSet<>(lista);
        } catch (Exception e) {
            throw new JPAException(JpaManagerCdi.getMessageError(e));
        }
    }

    @Override
    public Optional<Usuario> selectById(int id) throws JPAException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectById'");
    }

    @Override
    public void deleteById(int id) throws JPAException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    @Transactional
    public void save(Usuario t) throws JPAException {
        try {
            em.persist(t);
            //em.flush();
        } catch (Exception e) {
            throw new JPAException(JpaManagerCdi.getMessageError(e));
        }
    }
    
}
