package repositorio;

import model.Odontologo;

import java.sql.SQLException;

public interface OdontologoDAO {

    Odontologo listar(int id);

    void agregar(Odontologo o) throws SQLException;

    void modificar(Odontologo o) throws SQLException;

    void eliminar(int id);

}
