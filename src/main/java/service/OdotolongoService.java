package service;
import lombok.AllArgsConstructor;
import model.Odontologo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import repositorio.OdontologoDAO;
import repositorio.OdontologoDAOH2;

import java.sql.SQLException;

@AllArgsConstructor
public class OdotolongoService {
    private final static Logger logger = LogManager.getLogger(OdontologoDAOH2.class);
    private final OdontologoDAO odontologoDAO;

    public void agregar(Odontologo o){
        try{
            odontologoDAO.agregar(o);

        } catch (SQLException e){
            logger.fatal("no se puede agregar el odontologo");
        }
    }

    public Odontologo listar(int id){
        return odontologoDAO.listar(id);
    }


    public void eliminar(int id){
        odontologoDAO.eliminar(id);
    }

    public void modificar(Odontologo o){
        try{
            odontologoDAO.modificar(o);

        } catch (SQLException e){
                logger.fatal("error en la modificacion");
        }
    }



}
