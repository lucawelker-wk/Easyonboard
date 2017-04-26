package wk.easyonboard.common;

import java.util.Set;

/**
 * Created by wkss on 4/26/17.
 */
public abstract class Launchable {
    private Set<Class<?>> resources;

    public Set<Class<?>> getResources() {
        return resources;
    }

    protected abstract Set<Class<?>> provideResources();

    public abstract int getPortNr();
}
