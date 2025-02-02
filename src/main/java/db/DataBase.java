package db;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import com.google.common.collect.Maps;

import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import webserver.WebServer;

public class DataBase {
    private static final Logger log = LoggerFactory.getLogger(DataBase.class);
    private static Map<String, User> users = Maps.newHashMap();

    public static void addUser(User user) {
        log.debug("save user {}",user.toString());
        users.put(user.getUserId(), user);
    }

    public static Optional<User> findUserById(String userId) {
        log.debug("find user Id={}", userId);
        return Optional.ofNullable(users.get(userId));
    }

    public static Collection<User> findAll() {
        return users.values();
    }
}
