package me.team.usercrud.shared.domain.services;

import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ListUtils {
    /**
     * Applies the given map function to each element in the list and returns a new list
     * containing the results.
     *
     * @param <In>        the type of elements in the input list
     * @param <Out>       the type of elements in the resulting list
     * @param list        the input list to be mapped
     * @param mapFunction the function to apply to each element in the list
     * @return a new list containing the results of applying the map function to each
     * element in the input list
     */
    @NonNull
    public static <In, Out> List<Out> map(@NonNull List<In> list, @NonNull Function<In, Out> mapFunction) {
        return list.stream().map(mapFunction).toList();
    }
    
    /**
     * Applies the given map function to each element in the input list and returns a new list containing the results.
     *
     * @param <In>        the type of elements in the input list
     * @param <Out>       the type of elements in the resulting list
     * @param list        the input list to be mapped
     * @param mapFunction the function to apply to each element in the list
     * @return a new list containing the results of applying the map function to each element in the input list
     */
    @NonNull
    public static <In, Out> Optional<List<Out>> map(
        @NonNull Optional<List<In>> list, @NonNull Function<In, Out> mapFunction
    ) {
        return list.map(interiorList -> map(interiorList, mapFunction));
    }
}
