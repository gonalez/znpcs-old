package io.github.znetworkw.znpcservers.task.internal;

import io.github.znetworkw.znpcservers.task.Task;

/**
 * @author Gaston Gonzalez {@literal <znetworkw.dev@gmail.com>}
 */
public class DefaultTask implements Task {
    private final Runnable runnable;

    private boolean cancel;

    public DefaultTask(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override
    public void run() {
        runnable.run();
    }

    @Override
    public boolean cancel() {
        return this.cancel=!cancel;
    }

    @Override
    public boolean isCanceled() {
        return cancel;
    }
}
