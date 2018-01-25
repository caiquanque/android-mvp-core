package core;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * Created by luantruong on 7/12/17.
 */

public class BaseApplication extends DaggerApplication{
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
       return null;
    }
}
