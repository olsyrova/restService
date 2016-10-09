import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.City;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * this class maps json to a list of java City objects
 * Created by olgasyrova on 09.10.16.
 */
public class JsonTransformer {

    public static List<City> parseJson(String json){

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<City> cityList = null;
        try {
            cityList = Arrays.asList(mapper.readValue(json, City[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (cityList != null && cityList.size() > 0){
            return cityList;
        }
        return null;

    }
}
