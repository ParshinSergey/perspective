package ua.univer.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ua.univer.exeptions.MyException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ConverterUtil {

    private ConverterUtil() {
    }


    public static String objectToJson(Object obj){

        ObjectMapper objectMapper = new ObjectMapper();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        objectMapper.setDateFormat(df);
        String valueAsString;
        try {
            valueAsString = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new MyException("Ошибка в методе objectToJson. " + e.getMessage());
        }
        return valueAsString;
    }


    public static <T> T jsonToObject(String json, Class<T> clas) {

        ObjectMapper objectMapper = new ObjectMapper();
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm");
        objectMapper.setDateFormat(df);
        T t;
        try {
            t = objectMapper.readValue(json, clas);
        } catch (JsonProcessingException e) {
            throw new MyException("Ошибка в методе jsonToObject. " + e.getMessage());
        }
        return t;
    }


    public static <T> String objectToXML(T object) {

        Class<?> objectClass = object.getClass();
        Writer writer = new StringWriter();
        try {
            JAXBContext jc = JAXBContext.newInstance(objectClass);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(object, writer);
        }
        catch (JAXBException ex) {
            String message = ex.getMessage();
            if (message == null) {
                message = ex.getCause().getMessage();
                if (message == null) {
                    message = "Unidentified JAXB error";
                }
            }
            throw new MyException(message);
        }

        return writer.toString();
    }

}
