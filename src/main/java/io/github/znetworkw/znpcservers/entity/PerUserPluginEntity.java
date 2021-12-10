package io.github.znetworkw.znpcservers.entity;

import io.github.znetworkw.znpcservers.user.User;

public interface PerUserPluginEntity extends PluginEntity {
    void onSpawn(User user) throws Exception;
    void onDelete(User user) throws Exception;

    boolean isViewer(User user);

    /**
     * All users viewing this entity.
     *
     * @return viewers of this entity.
     */
    Iterable<User> getViewers();
}