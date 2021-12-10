package io.github.znetworkw.znpcservers.npc.internal.function;

import io.github.znetworkw.znpcservers.npc.function.NpcFunction;
import io.github.znetworkw.znpcservers.npc.function.NpcFunctionRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Gaston Gonzalez {@literal <znetworkw.dev@gmail.com>}
 */
public class DefaultNpcFunctionRegistry implements NpcFunctionRegistry {
    private final Map<String, NpcFunction> functions = new HashMap<>();

    @Override
    public NpcFunction getFunction(String name) {
        return functions.get(name);
    }

    @Override
    public NpcFunction register(String name, NpcFunction function) {
        return functions.computeIfAbsent(name, (n) -> function);
    }

    @Override
    public NpcFunction unregister(String name) {
        return functions.remove(name);
    }

    @Override
    public Iterable<NpcFunction> getFunctions() {
        return functions.values();
    }
}
