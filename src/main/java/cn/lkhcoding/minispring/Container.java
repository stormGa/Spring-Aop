package cn.lkhcoding.minispring;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Container {
    private Map<String, Object> map = new HashMap<>();


    /**
     * 根据名字从map中取对象
     *
     * @param name
     * @return
     */
    public Object getBean(String name) {
        Object object = null;
        if (map.containsKey(name)) {
            object = map.get(name);
        }
        return object;
    }

    public Container(File file) {
        try {
            init(file);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取txt文件，创建对象放入map中
     *
     * @param file
     */
    private void init(File file) throws IOException, NoSuchFieldException, IllegalAccessException {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = null;

        while ((line = br.readLine()) != null) {
            String[] data = line.split("=");
            String left = data[0];
            String right = data[1];

            //判断第三行
            if (left.indexOf("#")>0) {
                String[] ref = left.split("#");
                String refLeft = ref[0];
                String refRight = ref[1];
                Object bean = map.get(refLeft);
                Class clazz = bean.getClass();
                Field field = clazz.getDeclaredField(refRight);
                field.setAccessible(true);
                field.set(bean, map.get(right));
            }else {
                Object object = makeObject(right);
                if (object != null) {
                    map.put(left, object);
                }
            }

        }


    }

    private Object makeObject(String className) {
        Object object = null;
        //使用反射创建对象
        try {
            //使用反射，调用无参数构造方法
            object  = Class.forName(className).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return object;
    }
    }


