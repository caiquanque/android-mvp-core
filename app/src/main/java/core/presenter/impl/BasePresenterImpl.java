package core.presenter.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import core.presenter.Presenter;
import core.view.BaseView;

/**
 * Abstract presenter implementation that contains base implementation for other presenters.
 * Subclasses must call super for all {@link Presenter} method overriding.
 */
@SuppressWarnings("unused")
public abstract class BasePresenterImpl<V extends BaseView> implements Presenter<V> {
    /**
     * The view, will be null if the presenter isn't attached to a view
     */
    @SuppressWarnings("WeakerAccess")
    @Nullable
    protected V mView;

// ------------------------------------------->

    @Override
    public void onViewAttached(@NonNull V view) {
        mView = view;
    }


    @Override
    public void onStart(boolean viewCreated) {
        // No-op but subclasses can override it
    }

    @Override
    public void onStop() {
        // No-op but subclasses can override it
    }

    @Override
    public void onViewDetached() {
        mView = null;
    }

    @Override
    public void onFinish() {
        // No-op but subclasses can override it
    }
}
