package co.proyecto4.proyecto4.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.proyecto4.proyecto4.model.User;
import co.proyecto4.proyecto4.repository.crud.UserCrudRepository;

/**
 *
 * @author karent_saenz 
 */
@Repository
public class UserRepository {
    @Autowired
    /**
     * Atributo tipo UserCrudRepository
     */
    private UserCrudRepository userCrudRepository;
    /**
     * Metodo para obtener el id de un usuario
     */
    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }
    /**
     * Metodo para obtener la lista de usuarios
     */
    public List<User> listAll() {
        return userCrudRepository.findAll();
    }
    /**
     * Metodo para poder validar la existencia de un email
     */
    public boolean emailExists(String email) {
        Optional<User> usuario = userCrudRepository.findByEmail(email);
        return !usuario.isEmpty();
    }
    /**
     * Metodo que Permite la autenticacion de los usuarios
     */
    public Optional<User> autenticateUser(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
    /**
     *Metodo que logra crear nuevos usuarios
     */
    public User create(User user) {
        return userCrudRepository.save(user);
    }
    /**
     * Metodo que permite actualizar la informacion de 
     * los usuarios
     */
    public User update(User user) {
        return userCrudRepository.save(user);
    }
    /**
     * Permite eliminar un usuario
     */
    public void delete(User user) {
        userCrudRepository.delete(user);
    }
    /**
     * Permite identofocar el ultimo usuario id
     */
    public Optional<User> lastUserId(){
        return userCrudRepository.findTopByOrderByIdDesc();
    }
    /**
     * Permite obtener la lista de los cumpleaños de los usuarios
     * @param monthBirthtDay
     * @return
     */
    public List<User> birthtDayList(String monthBirthtDay) {
        return userCrudRepository.findByMonthBirthtDay(monthBirthtDay);
    }
     
}
