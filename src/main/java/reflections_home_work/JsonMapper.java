package reflections_home_work;

import lombok.SneakyThrows;
import java.lang.reflect.Field;



public class JsonMapper {


    @SneakyThrows
    public static <T> T convertFromJson(String json, Class<T> type)
    {
        Field[] fields = type.getDeclaredFields();
        Object obj = type.getDeclaredConstructor().newInstance();
        String[] out = json.replaceAll("[{}]","").split(",");

        for (String s : out) {
            String[] pair = s.replaceAll("\"","").trim().split(":");
            Field field = type.getDeclaredField(pair[0].trim());
            field.setAccessible(true);
            if(field.getType().equals(String.class)) {
                field.set(obj,pair[1].trim());
            }
            else if(field.getType().equals(int.class)){
                field.set(obj,Integer.parseInt(pair[1].trim()));
            }
        }

        return (T) obj;
    }
    @SneakyThrows
    public static String convertToJson(Object object) {
        StringBuilder sb = new StringBuilder();
        Field[] fields = object.getClass().getDeclaredFields();
        sb.append("{");
        for (Field field : fields) {
            field.setAccessible(true);
            if(field.getType().equals(String.class)) {
                sb.append("\\");
                sb.append("\"");
                sb.append(field.getName());
                sb.append("\\");
                sb.append("\"");
                sb.append(": ");
                sb.append("\\");
                sb.append("\"");
                sb.append(field.get(object).toString());
                sb.append("\\");
                sb.append("\"");
            }
            else if(field.getType().equals(int.class))
            {
                sb.append("\\");
                sb.append("\"");
                sb.append(field.getName());
                sb.append("\\");
                sb.append("\"");
                sb.append(": ");
                sb.append(field.get(object).toString());
            }
            sb.append(",");
        }
        sb.setCharAt(sb.length()-1,'}');
        return sb.toString();
    }
}
