package java_8;

import lombok.SneakyThrows;

import java.util.List;


public class ListUtils {



    @SneakyThrows
    public static <T> void forEachWithDelay(List<T> list, Integer delay , Action<T> action){
        for (T t : list)
        {
            action.run(t);
            Thread.sleep(delay);
        }

    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3);
        forEachWithDelay(list,2000,integer -> System.out.println(integer));
    }

}
