package io.github.znetworkw.znpcservers.npc.internal.function;

import com.google.common.collect.ImmutableList;
import io.github.znetworkw.znpcservers.npc.function.AbstractNpcFunction;
import io.github.znetworkw.znpcservers.npc.Npc;
import io.github.znetworkw.znpcservers.npc.function.NpcFunctionContext;
import io.github.znetworkw.znpcservers.npc.function.NpcFunctionValue;

/**
 * An {@link AbstractNpcFunction} that does nothing.
 *
 * @author Gaston Gonzalez {@literal <znetworkw.dev@gmail.com>}
 */
public class EmptyNpcFunction extends AbstractNpcFunction {
    public EmptyNpcFunction(String name) {
        super(name);
    }

    public EmptyNpcFunction(String name, ImmutableList<NpcFunctionValue<?>> requiredValues) {
        super(name, requiredValues);
    }

    @Override
    protected void function(Npc npc, NpcFunctionContext functionContext) throws Exception {}

    @Override
    protected boolean isSaveAllowed() {
        return false;
    }
}
