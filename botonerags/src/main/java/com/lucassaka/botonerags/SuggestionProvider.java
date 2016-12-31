package com.lucassaka.botonerags;

import android.content.SearchRecentSuggestionsProvider;

/**
 * Created by Lucas on 30/10/2016.
 */
public class SuggestionProvider extends SearchRecentSuggestionsProvider {
    public final static String AUTHORITY = "com.lucassaka.botonerags.SuggestionProvider";
    public final static int MODE = DATABASE_MODE_QUERIES;

    public SuggestionProvider() {
        setupSuggestions(AUTHORITY, MODE);
    }
}
