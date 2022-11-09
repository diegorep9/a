package service;

import model.Odontologo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;
import repositorio.OdontologoDAO;
import repositorio.OdontologoDAOH2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class main {
    private final static Logger logger = LogManager.getLogger(OdontologoDAO.class);

    private final static String config = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "log4j2.xml";

    public static void main(String[] args) throws IOException {
        startLogger();
        var service = new OdotolongoService(new OdontologoDAOH2());
        var odontologo = new Odontologo(1, "Diego", "Bustamante");
        var newodontologo = new Odontologo(1,"lucia","Bustamante");
        //el id está autoincremental, para que no ejecute el metodo agregar mas de una vez con el la misma variable :3
        //service.agregar(odontologo);
        //service.agregar(odontologo2);
        //logger.info(service.listar(2));
        //System.out.println(service.listar(2));
        //service.eliminar(2);
        //service.modificar(newodontologo);

    }
    private static void startLogger() throws IOException {
        var source = new ConfigurationSource(new FileInputStream(config));
        Configurator.initialize(null, source);
    }
}
