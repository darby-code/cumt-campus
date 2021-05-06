package edu.cumt.phyExperiment.util;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Json工具类，将对应对象转为Json对象
 */
public class JsonUtil {

    public static String objectToJson(Object object) {
        StringBuilder json = new StringBuilder();
        if (object == null) {
            json.append("\"\"");
        } else if (object instanceof String || object instanceof Integer || object instanceof Float
                || object instanceof Boolean || object instanceof Short || object instanceof Double
                || object instanceof Long || object instanceof BigDecimal || object instanceof BigInteger
                || object instanceof Byte) {
            json.append("\"").append(stringToJson(object.toString())).append("\"");
        } else if (object instanceof Object[]) {
            json.append(arrayToJson((Object[]) object));
        } else if (object instanceof List) {
            json.append(listToJson((List<?>) object));
        } else if (object instanceof Map) {
            json.append(mapToJson((Map<?, ?>) object));
        } else if (object instanceof Set) {
            json.append(setToJson((Set<?>) object));
        } else {
            json.append(beanToJson(object));
        }
        return json.toString();
    }

    public static String beanToJson(Object bean) {
        StringBuilder json = new StringBuilder();
        json.append("{");
        PropertyDescriptor[] descriptors = null;
        try {
            descriptors = Introspector.getBeanInfo(bean.getClass(), Object.class).getPropertyDescriptors();
        } catch (IntrospectionException e) {}

        if (descriptors != null) {
            for (int i = 0; i < descriptors.length; i++) {
                try {
                    String name = objectToJson(descriptors[i].getName());
                    String value = objectToJson(descriptors[i].getReadMethod().invoke(bean));
                    json.append(name).append(":").append(value).append(",");
                } catch (Exception e) {}
            }
            json.setCharAt(json.length() - 1, '}');
        } else {
            json.append("}");
        }
        return json.toString();
    }

    public static String listToJson(List<?> list) {
        StringBuilder json = new StringBuilder();
        json.append("[");
        if (list != null && list.size() > 0) {
            for (Object object : list) {
                json.append(objectToJson(object)).append(",");
            }
            json.setCharAt(json.length() - 1, ']');
        } else {
            json.append("]");
        }
        return json.toString();
    }

    public static String arrayToJson(Object[] array) {
        StringBuilder json = new StringBuilder();
        json.append("[");
        if (array != null && array.length > 0) {
            for (Object object : array) {
                json.append(objectToJson(object)).append(",");
            }
            json.setCharAt(json.length() - 1, ']');
        } else {
            json.append("]");
        }
        return json.toString();
    }

    public static String mapToJson(Map<?, ?> map) {
        StringBuilder json = new StringBuilder();
        json.append("{");
        if (map != null && map.size() > 0) {
            for (Object key : map.keySet()) {
                json.append(objectToJson(key)).append(":")
                        .append(objectToJson(map.get(key))).append(",");
            }
            json.setCharAt(json.length() - 1, '}');
        } else {
            json.append("}");
        }
        return json.toString();
    }

    public static String setToJson(Set<?> set) {
        StringBuilder json = new StringBuilder();
        json.append("[");
        if (set != null && set.size() > 0) {
            for (Object object : set) {
                json.append(objectToJson(object)).append(",");
            }
            json.setCharAt(json.length() - 1, ']');
        } else {
            json.append("]");
        }
        return json.toString();
    }

    public static String stringToJson(String s) {
        if (s == null) {
            return "";
        }
        StringBuilder json = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '"': json.append("\\\""); break;
                case '\\': json.append("\\\\"); break;
                case '\b': json.append("\\b"); break;
                case '\f': json.append("\\f"); break;
                case '\n': json.append("\\n"); break;
                case '\r': json.append("\\r"); break;
                case '\t': json.append("\\t"); break;
                case '/': json.append("\\/"); break;
                default:
                    if (ch <= '\u001F'){
                        String ss = Integer.toHexString(ch);
                        json.append("\\u");
                        for (int k = 0; k < 4 - ss.length(); k++) {
                            json.append('0');
                        }
                        json.append(ss.toUpperCase());
                    } else {
                        json.append(ch);
                    }
            }
        }
        return json.toString();
    }
}
