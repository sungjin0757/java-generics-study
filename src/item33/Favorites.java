package item33;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Favorites {
    private Map<Class<?>,Object> favorites=new HashMap<>();

    public <T> void putFavorite(Class<T> type,T instance){
        favorites.put(Objects.requireNonNull(type),type.cast(instance));
    }

    public <T> T getFavorites(Class<T> type){
        return type.cast(favorites.get(type));
    }
}

class Main{
    public static void main(String[] args){
        Favorites favorites=new Favorites();

        favorites.putFavorite(String.class,"Java");
        favorites.putFavorite(Integer.class,14);
        favorites.putFavorite(Class.class,Favorites.class);

        String favorites1 = favorites.getFavorites(String.class);
        Integer favorites2 = favorites.getFavorites(Integer.class);
        Favorites favorites3 = favorites.getFavorites(Favorites.class);
    }
}