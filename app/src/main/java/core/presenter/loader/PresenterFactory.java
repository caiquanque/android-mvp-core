package core.presenter.loader;

import android.support.annotation.NonNull;

import core.presenter.Presenter;

/**
 * Factory to create a presenter.
 */
@SuppressWarnings("unused")
public interface PresenterFactory<P extends Presenter> {
    @NonNull
    P create();
}
