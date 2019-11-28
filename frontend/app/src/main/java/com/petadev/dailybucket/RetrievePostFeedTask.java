package com.petadev.dailybucket;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;

import com.petadev.dailybucket.list_adapter.PostListAdapter;
import com.petadev.dailybucket.list_adapter.TaskExecutor;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class RetrievePostFeedTask extends AsyncTask<String, Void, Drawable> {
    private final TaskExecutor executedOnPost;

    public RetrievePostFeedTask(TaskExecutor taskExecutor) {
        this.executedOnPost = taskExecutor;
    }

    private static Drawable loadImageFromWebOperations(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, url);
            Log.d(PostListAdapter.class.getCanonicalName(), d.toString());
            return d;
        } catch (IOException e) {
            Log.d(PostListAdapter.class.getCanonicalName(), e.getMessage());
            return null;
        }
    }

    @Override
    protected Drawable doInBackground(String... urls) {
        return loadImageFromWebOperations(urls[0]);
    }

    @Override
    protected void onPostExecute(Drawable drawable) {
        this.executedOnPost.onComplete(drawable);
    }
}
