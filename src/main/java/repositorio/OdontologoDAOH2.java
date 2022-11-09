package repositorio;

import model.Odontologo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OdontologoDAOH2 implements OdontologoDAO{

    private final static String BD_URL = "jdbc:h2:~/BaseDatosParcial;INIT=RUNSCRIPT FROM 'script.sql'";

    private final static String Insert = "INSERT INTO odontologos(nombre, apellido) VALUES(?,?)";

    private final static String Select = "SELECT id,nombre,apellido FROM odontologos where id = ?";

    private final static Logger logger = LogManager.getLogger(OdontologoDAOH2.class);


    @Override
    public Odontologo listar(int id) {
        Connection connection = null;
        try{
            connection = getConnection();
            var listar = connection.prepareStatement(Select);
            listar.setInt(1,id);
            var result = listar.executeQuery();

            if(result.next()){
                var Id = result.getInt(1);
                var nombre = result.getString(2);
                var apellido = result.getString(3);
                return new Odontologo(Id,nombre,apellido);
            }

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void agregar(Odontologo o) throws SQLException {
        Connection connection = null;
        try{
            connection = getConnection();
            var insert = connection.prepareStatement(Insert);
            insert.setString(1,o.nombre());
            insert.setString(2,o.apellido());
            insert.execute();

        } catch (SQLException e){
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public void modificar(Odontologo o) {
        Connection connection = null;
        try{
            connection = getConnection();
            var modificar = connection.prepareStatement("UPDATE odontologos set nombre = ? where id = ?");
            modificar.setString(1,o.nombre());
            modificar.setInt(2,o.id());
            modificar.executeUpdate();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void eliminar(int id) {
        Connection connection = null;
        try{
            connection = getConnection();
            var delete = connection.prepareStatement("DELETE from odontologos where id = ?");
                delete.setInt(1,id);
                delete.executeUpdate();
        }  catch (SQLException e){
            throw new RuntimeException(e);

        }
    }


    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(BD_URL);
    }
}
