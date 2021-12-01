package uk.co.lukestevens.utils;

import java.util.List;
import java.util.Optional;

public class ListUtils {

    public static <T> Optional<T> toOptional(List<T> list){
        return list.isEmpty()? Optional.empty() : Optional.of(list.get(0));
    }
}
