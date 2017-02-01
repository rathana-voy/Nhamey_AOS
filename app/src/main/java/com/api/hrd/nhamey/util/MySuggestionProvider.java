package com.api.hrd.nhamey.util;

import android.content.SearchRecentSuggestionsProvider;

/**
 * Created by rathana on 13/1/17.
 */

public class MySuggestionProvider extends SearchRecentSuggestionsProvider {
    public final static String AUTHORITY = "com.api.hrd.nhamey.util.MySuggestionProvider";
    public final static int MODE = DATABASE_MODE_QUERIES;
    public MySuggestionProvider() {
        setupSuggestions(AUTHORITY, MODE);
    }
}

